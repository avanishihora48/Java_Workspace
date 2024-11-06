<%@ page import="com.dao.Dao" %>
<%@ page import="com.model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    
    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");
    String mobile = (String) session.getAttribute("mobile");

    if (name == null) {
        response.sendRedirect("login.jsp"); 
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
</head>
<body>
    <h2>Edit Profile</h2>
    <form method="post" action="EditProfileServlet">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="<%= name %>" required />
        <br><br>

        <label for="email">Email</label>
        <input type="text" id="email" name="email" value="<%= email %>" required />
        <br><br>

        <label for="mobile">Mobile</label>
        <input type="text" id="mobile" name="mobile" value="<%= mobile %>" required />
        <br><br>

        <input type="submit" value="Save Changes" />
    </form>
</body>
</html>
