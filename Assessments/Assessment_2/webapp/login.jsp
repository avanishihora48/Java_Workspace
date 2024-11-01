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
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: #f0f2f5;
            font-family: 'Arial', sans-serif;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            padding: 40px 30px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            text-align: left;
            color: #555;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
        .error-message {
            color: #e74c3c;
            margin: 15px 0;
        }
        .footer {
            margin-top: 20px;
            font-size: 14px;
        }
        .footer a {
            color: #5cb85c;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
        .forgot-password {
            margin-top: 10px;
            font-size: 14px;
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
                    session.setAttribute("fname", m2.getFname());
                    session.setAttribute("lname", m2.getLname());
                    session.setAttribute("email", m2.getEmail());
                    session.setAttribute("mobile", m2.getMobile());
                    session.setAttribute("address", m2.getAddress());
                    session.setAttribute("gender", m2.getGender());
                    response.sendRedirect("dashboard.jsp");
                    return; // Ensure no further processing occurs
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
        <div class="forgotpassword">
            <a href="forgotpassword.jsp">Forgot Password?</a>
        </div>
        <div class="footer">
            <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
        </div>
    </div>
</body>
</html>
