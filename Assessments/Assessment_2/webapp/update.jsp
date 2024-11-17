<%@ page import="com.dao.Dao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.model.Model" />
<jsp:setProperty property="*" name="m" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Update</title>
</head>
<body>

<%
    
    String currentPassword = request.getParameter("currentPassword");
    String newPassword = request.getParameter("newPassword");
    String email = request.getParameter("email");

    if (newPassword != null && !newPassword.trim().isEmpty()) 
    {
       
        m.setPassword(newPassword);  
        m.setEmail(email);          

       
        int result = Dao.updatedata(m);

        if (result > 0) 
        {
            response.sendRedirect("login.jsp");  
        } 
        else 
        {
            out.print("Password update failed. Please try again.");
        }
    } 
    else 
    {
        out.print("New password cannot be empty.");
    }
%>

</body>
</html>
