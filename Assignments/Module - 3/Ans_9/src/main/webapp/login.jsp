<%@ page import="com.dao.Dao" %>
<%@ page import="com.model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="m" class="com.model.Model" />
<jsp:setProperty property="*" name="m" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
            font-size: 24px;
        }

        label {
            font-size: 14px;
            color: #555;
            margin-bottom: 8px;
            display: block;
            text-align: left;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: #fafafa;
            color: #333;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: #e74c3c;
            font-size: 14px;
            margin-top: 20px;
            text-align: center;
        }

        .forgot-password {
            margin-top: 10px;
            font-size: 14px;
            color: #555;
        }

        .forgot-password a {
            text-decoration: none;
            color: #4CAF50;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }

        .footer {
            margin-top: 20px;
            font-size: 14px;
        }

        .footer a {
            color: #4CAF50;
            text-decoration: none;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>



<div class="container">
    <h2>Login</h2>

    <%
        String errorMessage = "";
        if (request.getParameter("login") != null) {
            Model m2 = Dao.logindata(m);

            if (m2 != null) {
                session.setAttribute("project", true);
                session.setAttribute("userId", m2.getId());
                session.setAttribute("name", m2.getName());
                session.setAttribute("email", m2.getEmail());
                session.setAttribute("mobile", m2.getMobile());
                response.sendRedirect("dashboard.jsp");
                return;
            } else {
                errorMessage = "Login failed. Please check your credentials and try again.";
            }
        }
    %>

    <form method="post" action="">
        <label for="email">Email</label>
        <input type="text" name="email" id="email" placeholder="Enter your email" required />

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="Enter your password" required />

        <input type="submit" name="login" value="Login" />
    </form>

    <%
        if (!errorMessage.isEmpty()) {
    %>
        <div class="error-message">
            <p><%= errorMessage %></p>
        </div>
    <%
        }
    %>

    <div class="forgot-password">
        <a href="forgotpassword.jsp">Forgot Password?</a>
    </div>

    <div class="footer">
        <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
    </div>
</div>



</body>

</html>
