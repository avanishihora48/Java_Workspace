<%@page import="com.dao.Dao" %>
<%@page import="com.model.Model" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

     String otp1 = request.getParameter("otp1");
     String otp2 = request.getParameter("otp2");
     String otp3 = request.getParameter("otp3");
     String otp4 = request.getParameter("otp4");
     
        int otp11 = Integer.parseInt(otp1);
		int otp22 = Integer.parseInt(otp2);
		int otp33 = Integer.parseInt(otp3);
		int otp44 = Integer.parseInt(otp4);
	
		int n1 = (int) session.getAttribute("n1");
		int n2 = (int) session.getAttribute("n2");
		int n3 = (int) session.getAttribute("n3");
		int n4 = (int) session.getAttribute("n4");
		
		if(otp11==n1)
		{
			if(otp22==n2)
			{
				if(otp33==n3)
				{
					if(otp44==n4)
					{
						String fname = (String) session.getAttribute("fname");
						String lname = (String) session.getAttribute("lname");
						String gender =(String) session.getAttribute("gender");
						String email = (String) session.getAttribute("email");
						String phone = (String) session.getAttribute("phone");
						String city = (String) session.getAttribute("city");
						String password = (String) session.getAttribute("password");
						String repassword = (String)session.getAttribute("repassword");
						
						Model m = new Model();
						m.setFname(fname);
						m.setLname(lname);
						m.setGender(gender);
						m.setEmail(email);
						m.setPhone(phone);
						m.setCity(city);
						m.setPassword(password);
						m.setRepassword(repassword);
						
						int data = Dao.signupdata(m);
		    			
		    			if(data>0)
		    			{
		    				response.sendRedirect("signin.jsp");
		    			}
		    			else
						{ 
								
						%>
						 <br>
						<center>
								
								<b><p style="color:red;font-family: sans-serif; font-size: 25px;">Signup Failed!! Please Try Again</p></b>
							</center>

						<br>
						<br> 
						
						<%@ 
							include file="signup.jsp"%>
					
						<%
						}
						
						
						
						
					}
				}
			}	
		}
		
		
	
	%>

</body>
</html>