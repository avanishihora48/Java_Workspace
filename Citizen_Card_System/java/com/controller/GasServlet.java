package com.controller;

import java.io.IOException;
import java.util.UUID;

import com.dao.Dao;
import com.model.GasModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GasServlet")
public class GasServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String citizenId = req.getParameter("citizenId");
        String bank = req.getParameter("bank");
        String gasType = req.getParameter("gasType");
        String gasAmountStr = req.getParameter("gasAmount");

        if (citizenId == null || citizenId.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Citizen ID is required.");
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
            return;
        }
        if (bank == null || bank.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Bank information is required.");
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
            return;
        }
        if (gasType == null || gasType.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Gas Type is required.");
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
            return;
        }
        if (gasAmountStr == null || gasAmountStr.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Gas amount is required.");
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
            return;
        }

 
        Double gasAmount;
        try {
            gasAmount = Double.parseDouble(gasAmountStr);
            if (gasAmount <= 0) {
                throw new IllegalArgumentException("Gas amount must be greater than zero.");
            }
        } catch (IllegalArgumentException e) {
            req.setAttribute("errorMessage", "Invalid gas amount: " + e.getMessage());
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
            return;
        }

        String gasNumber = UUID.randomUUID().toString();

        double currentBalance = Dao.getUserBalance(citizenId, bank);

        if (currentBalance >= gasAmount) {
            GasModel gs = new GasModel();
            gs.setCitizenId(citizenId);
            gs.setGasNumber(gasNumber);
            gs.setBank(bank);
            gs.setGasAmount(gasAmount);
            gs.setGasType(gasType);

            boolean gasInserted = Dao.insertGasPayment(gs);
            boolean balanceUpdated = Dao.updateGasUserAccountBalance(gs);

            if (gasInserted && balanceUpdated) {
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("gasNumber", gasNumber);
                req.setAttribute("gasType", gasType);
                req.setAttribute("gasAmount", gasAmount);
                req.getRequestDispatcher("gas.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Gas payment failed. Please try again.");
                req.getRequestDispatcher("gas.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Insufficient balance to make the gas payment.");
            req.getRequestDispatcher("gas.jsp").forward(req, resp);
        }
    }
}

