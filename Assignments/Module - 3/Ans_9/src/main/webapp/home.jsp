<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page - User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        .profile-info {
            margin: 20px 0;
        }
        .profile-info p {
            font-size: 16px;
            color: #555;
        }
        .profile-info strong {
            color: #000;
        }
        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<% 
    // Get the logged-in user's details from the session
    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");
    String mobile = (String) session.getAttribute("mobile");

    // Check if the user is logged in (session attributes should not be null)
    if (name == null || email == null || mobile == null) {
        // Redirect to login page if user is not logged in
        response.sendRedirect("login.jsp");
    } else {
%>

    <div class="container">
        <h1>Welcome, <%= name %>!</h1>
        
        <div class="profile-info">
            <p><strong>Name:</strong> <%= name %></p>
            <p><strong>Email:</strong> <%= email %></p>
            <p><strong>Mobile:</strong> <%= mobile %></p>
        </div>

        <a href="editprofile.jsp" class="btn">Edit Profile</a>
        <a href="sendmessage.jsp" class="btn">Send Message</a><br><br>
        
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout" class="btn" />
        </form>
    </div>

<% 
    }
%>

</body>
</html>
