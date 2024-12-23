package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import com.dao.Dao;
import com.model.RtoModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RtoServlet")
public class RtoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String citizenId = req.getParameter("citizenId");
        String bank = req.getParameter("bank");
        String vehicleRegistrationNo = req.getParameter("vehicleRegistrationNo");
        String engineNumber = req.getParameter("engineNumber");
        String payAmountString = req.getParameter("payAmount");

        HttpSession session = req.getSession();
        session.setAttribute("vehicleRegistrationNo", vehicleRegistrationNo);
        session.setAttribute("citizenId", citizenId);
        session.setAttribute("engineNumber", engineNumber);
        
        if (citizenId == null || citizenId.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Citizen ID is required.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }
        if (bank == null || bank.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Bank information is required.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }
        if (vehicleRegistrationNo == null || vehicleRegistrationNo.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Vehicle registration number is required.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }
        if (engineNumber == null || engineNumber.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Engine number is required.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }
        if (payAmountString == null || payAmountString.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Payment amount is required.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }

        double payRtoAmount;
        try {
            payRtoAmount = Double.parseDouble(payAmountString);
            if (payRtoAmount <= 0) {
                throw new IllegalArgumentException("Payment amount must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid payment amount.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        } catch (IllegalArgumentException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
            return;
        }

        double currentBalance = Dao.getUserBalance(citizenId, bank);

        if (currentBalance >= payRtoAmount) {
            RtoModel rto = new RtoModel();
            rto.setCitizenId(citizenId);
            rto.setBank(bank);
            rto.setVehicleRegistrationNo(vehicleRegistrationNo);
            rto.setEngineNumber(engineNumber);
            rto.setPayAmount(payRtoAmount);
            rto.setTransactionDate(Timestamp.from(Instant.now())); 

            boolean transactionInserted = Dao.insertRtoPayment(rto);
            boolean balanceUpdated = Dao.updateRtoUserAccountBalance(rto);

            if (transactionInserted && balanceUpdated) {
                req.setAttribute("successMessage", "Payment processed successfully.");
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("vehicleRegistrationNo", vehicleRegistrationNo);
                req.setAttribute("engineNumber", engineNumber);
                req.setAttribute("payAmount", payRtoAmount);
                req.getRequestDispatcher("rto.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "RTO payment failed. Please try again.");
                req.getRequestDispatcher("rto.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Insufficient balance to make the payment.");
            req.getRequestDispatcher("rto.jsp").forward(req, resp);
        }
    }
}
