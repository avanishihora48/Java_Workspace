<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Model" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
</head>
<body>

<h2>Edit Student</h2>

<%
    Model student = (Model) request.getAttribute("student");
%>

<form action="UpdateServlet" method="post">
    <input type="hidden" name="id" value="<%= student.getId() %>">
    First Name: <input type="text" name="fname" value="<%= student.getFname() %>" required><br><br>
    Last Name: <input type="text" name="lname" value="<%= student.getLname() %>" required><br><br>
    Email: <input type="email" name="email" value="<%= student.getEmail() %>" required><br><br>
    Mobile: <input type="text" name="mobile" value="<%= student.getMobile() %>" required><br><br>
    Password: <input type="text" name="pass" value="<%= student.getPass() %>" required><br><br>
    <input type="submit" value="Update">
</form>

</body>
</html>
