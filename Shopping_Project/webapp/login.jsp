<%@page import="com.dao.Dao" %>
<%@page import="com.model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty property="*" name="m"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Model m2 = Dao.signindata(m);
		
		if(m2!=null)
		{
			session.setAttribute("project",true);
			session.setAttribute("name",m2.getName());
			session.setAttribute("email",m2.getEmail());
			session.setAttribute("phone",m2.getPhone());
			session.setAttribute("pass",m2.getPassword());
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			out.print("fail");
		}
		
	%>

</body>
</html>