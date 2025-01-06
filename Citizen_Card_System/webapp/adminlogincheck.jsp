
<%@page import="com.model.AdminModel"%>
<%@page import="com.dao.Dao" %>
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
				String username = request.getParameter("username");
				String password = request.getParameter("password");
					
				AdminModel m = new AdminModel();
				m.setUsername(username);
				m.setPassword(password);
				
				AdminModel m2 =	Dao.adminlogin(m);
				
				if(m2!=null)
				{
					session.setAttribute("citizenadmin", true);
					session.setAttribute("username", username);
					response.sendRedirect("admindashboard.jsp");
				}
				else
				{
					
				
			%>
			<br>
				<center>
						
						<b><p style="color:red;font-family: sans-serif; font-size: 25px;">Login Failed!! Please Try Again</p></b>
					</center>

					<br>
					<br>
				<%@ include file="adminlogin.jsp"%>
				<%
				}
				%>
				
	
					
	
		

</body>
</html>