package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.Dao;
import com.model.CreditRatingModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CreditRatingServlet")
public class CreditRatingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String name = req.getParameter("name");
        String behavior = req.getParameter("behavior");
        String rating = req.getParameter("rating");

        CreditRatingModel cr = new CreditRatingModel();
        cr.setName(name);
        cr.setBehavior(behavior);
        cr.setRating(rating);

        boolean isSaved = Dao.saveCreditRating(cr);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Credit Rating Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #eef2f3; padding: 20px; }");
        out.println(".result-container { max-width: 700px; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); margin: auto; }");
        out.println("h2 { text-align: center; color: #444; }");
        out.println(".result { margin: 15px 0; padding: 10px; background-color: #f8f9fa; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result-container'>");
        out.println("<h2>Credit Rating Result</h2>");

        if (isSaved) {
            out.println("<div class='result'>Data successfully saved!</div>");
        } else {
            out.println("<div class='result'>Failed to save data. Please try again.</div>");
        }

        out.println("<div class='result'><strong>Citizen Name:</strong> " + name + "</div>");
        out.println("<div class='result'><strong>Behavior Summary:</strong> " + behavior + "</div>");
        out.println("<div class='result'><strong>Credit Rating:</strong> " + rating + "</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
