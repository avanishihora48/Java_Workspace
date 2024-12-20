package com.controller;

import java.io.IOException;

import com.dao.Dao;
import com.model.InsuranceModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsuranceServlet")
public class InsuranceServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String citizenId = req.getParameter("citizenId");
		String insuredAmount = req.getParameter("insuredAmount");
	    String installments = req.getParameter("installments");
	    
	    if(citizenId == null || insuredAmount == null || installments == null)
	    {
	    	resp.getWriter().println("All fields are required!");
            return;
	    }
	    
	    double insuredAmnt = Double.parseDouble(insuredAmount);
	    double premiunAmount = calculatePremium(insuredAmnt,installments);
	    
	    InsuranceModel im = new InsuranceModel();
	    
	    im.setCitizenId(citizenId);
        im.setPolicyname("Generated Insurance Policy");
        im.setCoverageAmount(String.valueOf(insuredAmnt));
        im.setPremiumAmount(String.valueOf(premiunAmount));
        
        int status = Dao.setInsuranceDetails(im);

        if (status > 0) 
        {
        	 req.setAttribute("success", "Insurance Policy Saved Successfully!");
             req.setAttribute("citizenId", citizenId);
             req.setAttribute("policyName", "Generated Insurance Policy");
             req.setAttribute("insuredAmount", insuredAmnt);
             req.setAttribute("premiumAmount", premiunAmount);
             req.setAttribute("installments", installments);
        } 
        else 
        {
            resp.getWriter().println("Failed to Save Insurance Policy.");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("insurance.jsp");
        rd.forward(req, resp);
	}

	private double calculatePremium(double insuredAmount, String installments) 
	{
		// TODO Auto-generated method stub
		
		double premiumRate = 0.0;
		
		switch(installments)
		{
		   case "Monthly":
			   premiumRate = 0.02;
			   break;
			   
		   case "Quarterly":
			   premiumRate = 0.05;
			   break;
			   
		   case "Yearly":
			   premiumRate = 0.10;
			   break;
			   
		   default:
               premiumRate = 0.0;
		}
		   return insuredAmount * premiumRate;
		   
		   
	}
	
	
}