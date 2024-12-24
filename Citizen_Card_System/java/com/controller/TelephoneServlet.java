package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.dao.Dao;
import com.model.TelephoneModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TelephoneServlet")
public class TelephoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        try 
        {
            String citizenId = req.getParameter("citizenId");
            String callType = req.getParameter("callType");
            String callStartTimeStr = req.getParameter("callStartTime");
            String callDurationStr = req.getParameter("callDuration");
            String callRateStr = req.getParameter("callRate");

            if (citizenId == null || callType == null || callStartTimeStr == null || 
                callDurationStr == null || callRateStr == null) 
            {
                req.setAttribute("errorMessage", "All fields are required!");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }

            int callDuration = Integer.parseInt(callDurationStr);
            int callRate = Integer.parseInt(callRateStr);

            LocalTime callStartTime = LocalTime.parse(callStartTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime callStartDateTime = LocalDateTime.of(LocalDate.now(), callStartTime);
            Timestamp callStartTimestamp = Timestamp.valueOf(callStartDateTime);

            int callCharges = callDuration * callRate;

            TelephoneModel tm = new TelephoneModel();
            tm.setCitizenId(citizenId);
            tm.setCallType(callType);
            tm.setCallStartTime(callStartTimestamp);
            tm.setCallDuration(callDuration);
            tm.setCallRate(callRate);
            tm.setCallCharges(callCharges);

            if (req.getParameter("calculate") != null) 
            {
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("callType", callType);
                req.setAttribute("callDuration", callDuration);
                req.setAttribute("callRate", callRate);
                req.setAttribute("callCharges", callCharges);
                req.getRequestDispatcher("telephone.jsp").forward(req, resp);
             } 
            else if (req.getParameter("pay") != null) 
            {
                boolean callStatus = Dao.saveCallDetails(tm);
                if (callStatus) 
                {
                    boolean updateStatus = Dao.updateUserCallAccount(citizenId, callCharges);
                    if (updateStatus) 
                    {
                        req.setAttribute("successMessage", "Payment Successful!");
                    } 
                    else 
                    {
                        req.setAttribute("errorMessage", "Insufficient balance!");
                    }
                } else {
                    req.setAttribute("errorMessage", "Failed to save call details!");
                }
          
                req.setAttribute("citizenId", citizenId);
                req.setAttribute("callType", callType);
                req.setAttribute("callDuration", callDuration);
                req.setAttribute("callRate", callRate);
                req.setAttribute("callCharges", callCharges);
                req.getRequestDispatcher("telephone.jsp").forward(req, resp);
            }
        } 
        catch (NumberFormatException e) 
        {
            req.setAttribute("errorMessage", "Invalid number format: " + e.getMessage());
            req.getRequestDispatcher("telephone.jsp").forward(req, resp);
        } 
        catch (Exception e) 
        {
            req.setAttribute("errorMessage", "Error processing the request: " + e.getMessage());
            req.getRequestDispatcher("telephone.jsp").forward(req, resp);
        }
    }
}
