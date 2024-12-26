package com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.Dao;
import com.model.ElectricityModel;

@WebServlet("/ElectricityServlet")
public class ElectricityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try 
        {
            String citizenId = req.getParameter("citizenId");
            String previousUnitsStr = req.getParameter("previousUnits");
            String currentUnitsStr = req.getParameter("currentUnits");
            String ratePerUnitStr = req.getParameter("ratePerUnit");

            if (citizenId == null || citizenId.trim().isEmpty()) {
                req.setAttribute("errorMessage", "Citizen ID is required.");
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                return;
            }

            int previousUnits, currentUnits;
            double ratePerUnit;

            try {
                if (previousUnitsStr != null && !previousUnitsStr.trim().isEmpty()) {
                    previousUnits = Integer.parseInt(previousUnitsStr);
                } else {
                    req.setAttribute("errorMessage", "Previous units are required.");
                    req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                    return;
                }

                if (currentUnitsStr != null && !currentUnitsStr.trim().isEmpty()) {
                    currentUnits = Integer.parseInt(currentUnitsStr);
                } else {
                    req.setAttribute("errorMessage", "Current units are required.");
                    req.getRequestDispatcher("electricity.jsp").forward(req, resp);
                    return;
                }

                if (ratePerUnitStr != null && !ratePerUnitStr.trim().isEmpty()) {
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

            ElectricityModel em = new ElectricityModel();
            em.setCitizenId(citizenId);
            em.setPreviousUnits(previousUnits);
            em.setCurrentUnits(currentUnits);
            em.setRatePerUnit(ratePerUnit);
            em.setTotalCharges(totalCharges);
            
            if (req.getParameter("calculate") != null) {
  
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("previousUnits", previousUnits);
                req.setAttribute("currentUnits", currentUnits);
                req.setAttribute("ratePerUnit", ratePerUnit);
                req.setAttribute("totalCharges", totalCharges);
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
            } 
            else if (req.getParameter("pay") != null) 
            {
           
                boolean isInserted = Dao.insertUserCharges(em);

                if (isInserted) 
                {
                    boolean isUpdated = Dao.updateUserCharges(citizenId, totalCharges);

                    if (isUpdated) {
                        req.setAttribute("successMessage", "Payment successful!");
                    } else {
                        req.setAttribute("errorMessage", "Failed to update charges.");
                    }
                } 
                else 
                {
                    req.setAttribute("errorMessage", "Failed to insert charges.");
                }

                req.setAttribute("citizenId", citizenId);
                req.setAttribute("previousUnits", previousUnits);
                req.setAttribute("currentUnits", currentUnits);
                req.setAttribute("ratePerUnit", ratePerUnit);
                req.setAttribute("totalCharges", totalCharges);
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
            } 
            else 
            {
                req.setAttribute("errorMessage", "Invalid action specified.");
                req.getRequestDispatcher("electricity.jsp").forward(req, resp);
            }
        } 
        catch (Exception e) 
        {
            req.setAttribute("errorMessage", "Error processing the request: " + e.getMessage());
            req.getRequestDispatcher("electricity.jsp").forward(req, resp);
        }
    }
}
