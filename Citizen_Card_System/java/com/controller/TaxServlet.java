package com.controller;

import java.io.IOException;

import com.dao.Dao;
import com.model.TaxModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TaxServlet")
public class TaxServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String citizenId = req.getParameter("citizenId");
    String payAmountStr = req.getParameter("payAmount");
    String bank = req.getParameter("bank");

    double payAmount = 0;

    HttpSession session = req.getSession();
    session.setAttribute("citizenId", citizenId);

    try 
    {
        payAmount = Double.parseDouble(payAmountStr);
    } 
    catch (NumberFormatException e) 
    {
        req.setAttribute("errorMessage", "Invalid amount entered. Please enter a valid number.");
        req.getRequestDispatcher("taxation.jsp").forward(req, resp);
        return;
    }

	    if (citizenId == null || citizenId.trim().isEmpty()) {
	        req.setAttribute("errorMessage", "Citizen ID is required.");
	        req.getRequestDispatcher("gas.jsp").forward(req, resp);
	        return;
	    }
        if (bank == null || bank.isEmpty()) 
        {
            req.setAttribute("errorMessage", "Bank information is required.");
            req.getRequestDispatcher("taxation.jsp").forward(req, resp);
            return;
        }

        double currentBalance = Dao.getUserBalance(citizenId, bank);
     
        if (currentBalance >= payAmount) {
            TaxModel tx = new TaxModel();
            tx.setCitizenId(citizenId);
            tx.setTaxPaid(payAmount);
            tx.setBank(bank);

            boolean taxInserted = Dao.insertTaxPayment(tx);
            boolean balanceUpdated = Dao.updateUserAccountBalance(tx);

            System.out.println("Tax Inserted: " + taxInserted);
            System.out.println("Balance Updated: " + balanceUpdated);

            if (taxInserted && balanceUpdated) 
            {
                req.setAttribute("successMessage", "Tax payment completed successfully!");
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("taxPaid", payAmount); 
                req.setAttribute("taxDue", payAmount - payAmount); 
                req.getRequestDispatcher("taxation.jsp").forward(req, resp);
            } 
            else 
            {
                req.setAttribute("errorMessage", "Tax payment failed. Please try again.");
                req.getRequestDispatcher("taxation.jsp").forward(req, resp);
            }
        } 
        else 
        {
            req.setAttribute("errorMessage", "Insufficient balance to make the tax payment.");
            req.getRequestDispatcher("taxation.jsp").forward(req, resp);
        }
    }
}
