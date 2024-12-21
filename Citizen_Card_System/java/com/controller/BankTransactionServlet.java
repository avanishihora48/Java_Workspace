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
        String errorMessage = null;

        if (transactionType == null || transactionType.trim().isEmpty()) 
        {
            errorMessage = "Transaction type is required.";
        }

        if (errorMessage == null) 
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
            errorMessage = "Invalid amount format.";
        }

        if (errorMessage == null && amount <= 0) 
        {
            errorMessage = "Amount should be greater than zero.";
        }

        if (errorMessage != null) 
        {
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("banking.jsp").forward(req, resp);
            return;
        }

        TransactionModel transaction = new TransactionModel();
        transaction.setCitizenId(citizenId);
        transaction.setBank(bank);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);

        boolean isSuccess = false;
        switch (transactionType.toLowerCase()) 
        {
            case "deposit":
                isSuccess = Dao.saveDeposit(transaction);
                break;
                
            case "withdrawal":
                isSuccess = Dao.saveWithdraw(transaction);
                break;
                
            case "transfer":
                String recipientCitizenId = req.getParameter("recipientCitizenId");
                String recipientBank = req.getParameter("recipientBank");
                isSuccess = Dao.saveTransfer(transaction, recipientCitizenId, recipientBank);
                break;
                
            default:
                errorMessage = "Invalid transaction type.";
                break;
        }

        if (isSuccess)
        {
            req.setAttribute("successMessage", transactionType + " completed successfully!");
            req.setAttribute("transactionType", transactionType);
            req.setAttribute("citizenId", citizenId);
            req.setAttribute("bank", bank);
            req.setAttribute("amount", amount);
        }
        else 
        {
            req.setAttribute("errorMessage", "Transaction failed. Please try again.");
        }

        req.getRequestDispatcher("banking.jsp").forward(req, resp);
    }
}
