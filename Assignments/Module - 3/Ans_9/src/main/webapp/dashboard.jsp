<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <style>
        img {
            display: block;
            margin: 0 auto;
            height: auto;
            max-width: 100%;
        }
    </style>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("name") %>!</h1>
    <p><a href="editprofile.jsp">Edit Profile</a></p>
    <a href="sendmessage.jsp">Send Message</a><br><br>

    <form action="LogoutServlet" method="post">
        <input type="submit" name="logout" value="Logout" />
    </form>
</body>
</html>
