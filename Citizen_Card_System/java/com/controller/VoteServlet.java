package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import com.dao.Dao;
import com.model.VoteModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String citizenId = req.getParameter("citizenId");
        String area = req.getParameter("area");
        String candidate = req.getParameter("candidate");

        if (citizenId != null && area != null && candidate != null) {
            if (Dao.hasVoted(citizenId)) {
  
                req.setAttribute("errorMessage", "You have already voted.");
                req.getRequestDispatcher("voting.jsp").forward(req, resp);
            } else {
               
                VoteModel vm = new VoteModel();
                vm.setCitizenId(citizenId);
                vm.setArea(area);
                vm.setCandidate(candidate);
                vm.setVotingDate(Timestamp.from(Instant.now()));

                boolean success = Dao.saveVote(vm);

                if (success) {
                    req.setAttribute("successMessage", "Voted Successfully");
                    req.setAttribute("citizenId", citizenId);
                    req.setAttribute("area", area);
                    req.setAttribute("candidate", candidate);
                    req.getRequestDispatcher("voting.jsp").forward(req, resp);
                } else {
                    req.setAttribute("errorMessage", "Voting Fail. Please try again.");
                    req.getRequestDispatcher("voting.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("errorMessage", "Error: Invalid form data. Please fill all the fields correctly.");
            req.getRequestDispatcher("voting.jsp").forward(req, resp);
        }
    }
}
