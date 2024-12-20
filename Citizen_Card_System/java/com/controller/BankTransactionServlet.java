package com.controller;
import com.dao.Dao;
import com.model.TransactionModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/BankTransactionServlet")
public class BankTransactionServlet extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String citizenId = req.getParameter("citizenId");
        String bank = req.getParameter("bank");
        String transactionType = req.getParameter("transactionType");
       
        
        if (transactionType != null) 
        {
            transactionType = transactionType.substring(0, 1).toUpperCase() + transactionType.substring(1).toLowerCase();
        }
        
        double amount = 0.0;
        try 
        {
            amount = Double.parseDouble(req.getParameter("amount"));
        } 
        catch (NumberFormatException e) 
        {
            req.setAttribute("error", "Invalid amount format.");
            req.getRequestDispatcher("banking.jsp").forward(req, resp);
            return;
        }

        if (amount <= 0) 
        {
            req.setAttribute("error", "Amount should be greater than zero.");
            req.getRequestDispatcher("banking.jsp").forward(req, resp);
            return;
        }

        if (!transactionType.equals("Deposit") && !transactionType.equals("Withdrawal")) 
        {
            req.setAttribute("error", "Invalid transaction type.");
            req.getRequestDispatcher("banking.jsp").forward(req, resp);
            return;
        }

        TransactionModel transaction = new TransactionModel();
        transaction.setCitizenId(citizenId);
        transaction.setBank(bank);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);

        boolean isSuccess = false;

        switch (transactionType) 
        {
            case "Deposit":
            	System.out.println("Transaction in Servlet: " + transaction);
            	isSuccess = Dao.saveDeposit(transaction);
                 break;

            case "Withdrawal":
                isSuccess = Dao.saveWithdraw(transaction);
                break;

      
            default:
                req.setAttribute("error", "Invalid transaction type.");
                req.getRequestDispatcher("banking.jsp").forward(req, resp);
                return;
        }

        if (isSuccess) 
        {
            req.setAttribute("success", transactionType + " Successful!");
        } 
        else 
        {
            req.setAttribute("error", transactionType + " Failed! Insufficient funds.");
        }

        req.setAttribute("citizenId", citizenId);
        req.setAttribute("bank", bank);
        req.setAttribute("transactionType", transactionType);
        req.setAttribute("amount", amount);
        req.getRequestDispatcher("banking.jsp").forward(req, resp);
    }
}


