package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.dao.Dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PassportServlet")
public class PassportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String citizenId = req.getParameter("citizenId");
        String fullName = req.getParameter("fullName");
        String passportNumber = req.getParameter("passportNumber");
        String dateIssued = req.getParameter("dateIssued");

        if (fullName == null || fullName.trim().isEmpty()) {
            resp.getWriter().write("Full name cannot be empty.");
            return;
        }

        
        HttpSession session = req.getSession();
    
        session.setAttribute("citizenId", citizenId);
        session.setAttribute("passportNumber", passportNumber);
        session.setAttribute("fullName", fullName);
        session.setAttribute("dateIssued", dateIssued);
      
        try 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate issuedDate = LocalDate.parse(dateIssued, formatter);

            LocalDate validUntilDate = issuedDate.plusYears(10);

            LocalDateTime validUntilDateTime = validUntilDate.atStartOfDay();

            Timestamp validUntilTimestamp = Timestamp.valueOf(validUntilDateTime);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedValidUntil = sdf.format(validUntilTimestamp);

            Dao.savePassportInfo(citizenId, fullName, passportNumber, dateIssued, validUntilTimestamp);

            session.setAttribute("validDate", formattedValidUntil);  

            resp.sendRedirect("passport.jsp");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            resp.getWriter().write("Error: " + e.getMessage());
        }
    }
}
