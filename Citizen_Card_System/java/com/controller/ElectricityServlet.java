package com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.Dao;

@WebServlet("/ElectricityServlet")
public class ElectricityServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String citizenId = req.getParameter("citizenId");
        String previousUnitsStr = req.getParameter("previousUnits");
        String currentUnitsStr = req.getParameter("currentUnits");
        String ratePerUnitStr = req.getParameter("ratePerUnit");

        HttpSession session = req.getSession();

        if (citizenId == null || citizenId.trim().isEmpty()) {
            req.setAttribute("errorMessage", "Citizen ID is required.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        int previousUnits = 0;
        int currentUnits = 0;
        double ratePerUnit = 0.0;

        try {
            if (previousUnitsStr != null && !previousUnitsStr.isEmpty()) {
                previousUnits = Integer.parseInt(previousUnitsStr);
            } else {
                req.setAttribute("errorMessage", "Previous units are required.");
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                return;
            }

            if (currentUnitsStr != null && !currentUnitsStr.isEmpty()) {
                currentUnits = Integer.parseInt(currentUnitsStr);
            } else {
                req.setAttribute("errorMessage", "Current units are required.");
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                return;
            }

            if (ratePerUnitStr != null && !ratePerUnitStr.isEmpty()) {
                ratePerUnit = Double.parseDouble(ratePerUnitStr);
            } else {
                req.setAttribute("errorMessage", "Rate per unit is required.");
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                return;
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid number format: " + e.getMessage());
            req.getRequestDispatcher("electricity.jsp").forward(req, resp);
            return;
        }

        int unitsConsumed = currentUnits - previousUnits;
        if (unitsConsumed < 0) {
            req.setAttribute("errorMessage", "Current units cannot be less than previous units.");
            req.getRequestDispatcher("electricity.jsp").forward(req, resp);
            return;
        }

        double totalCharges = unitsConsumed * ratePerUnit;

        req.setAttribute("citizenId", citizenId);
        req.setAttribute("previousUnits", previousUnits);
        req.setAttribute("currentUnits", currentUnits);
        req.setAttribute("ratePerUnit", ratePerUnit);
        req.setAttribute("totalCharges", totalCharges);

        boolean isInserted = Dao.insertUserCharges(citizenId, previousUnits, currentUnits, ratePerUnit, totalCharges);

        if (isInserted) {
            req.setAttribute("successMessage", "Charges have been successfully inserted.");
        } else {
            req.setAttribute("errorMessage", "Failed to insert charges.");
        }

        boolean isUpdated = Dao.updateUserCharges(citizenId, previousUnits, currentUnits, ratePerUnit, totalCharges);

        if (isUpdated) {
            req.setAttribute("successMessage", "Payed Successfully! ");
        } else {
            req.setAttribute("errorMessage", "Failed to update charges.");
        }

        req.getRequestDispatcher("electricity.jsp").forward(req, resp);
    }
}
