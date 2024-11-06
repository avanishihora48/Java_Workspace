<%@page import="dao.Dao" %>
<%@ page import="model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Delete Student</h2>

<body>

	<%
		String id = request.getParameter("id");
		int id2 = Integer.parseInt(id);
		Dao.deletedata(id2);
		response.sendRedirect("dashboard.jsp");
	%>


</body>
</body>
</html>