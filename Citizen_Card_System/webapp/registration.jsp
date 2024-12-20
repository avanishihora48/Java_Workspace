<%@page import="com.dao.Dao"%>
<%@page import="com.model.*" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty  property="*" name="m" />
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String city = request.getParameter("city");
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");
    
    if(email==null||email.trim().equals(""))
	{  
		out.print("<p>Please enter Email!</p>");  
	}
	if(phone==null||phone.trim().equals(""))
	{
		out.print("<p>Please enter Phone!</p>");  
	}
	
	if(password==null||password.trim().equals(""))
	{
		out.print("<p>Please enter Password!</p>");  
	}
	if(repassword==null||fname.trim().equals(""))
	{
		out.print("<p>Please enter Repassword!</p>");  
	} 
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_card_system","root","");
		PreparedStatement ps=con.prepareStatement("select * from registration where email=?");  
		
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) 
		{      	
			out.println("<h1>Email Id Already exits, try entering new Email Address.</h1>");   	
		}
		else
		{
			int data = Dao.signupdata(m);
			
			if(data>0)
			{
				response.sendRedirect("signin.jsp");
			}
			else
			{
				out.print("fail");
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 
%>
</body>
</html>