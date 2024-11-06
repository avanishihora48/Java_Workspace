<%@page import="com.dao.Dao" %>
<%@page import="com.model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTP Verification</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        color: #333;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background-color: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
        text-align: center;
    }
    h2 {
        color: #4a90e2;
        font-size: 24px;
    }
    .success-message {
        color: #28a745;
        font-size: 18px;
    }
    .error-message {
        color: #e74c3c;
        font-size: 18px;
        margin: 20px 0;
    }
    .retry-link {
        color: #4a90e2;
        text-decoration: none;
        font-weight: bold;
        font-size: 16px;
    }
    .retry-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <%
        String otp = request.getParameter("otp");
        String otp2 = request.getParameter("otp2");
        String otp3 = request.getParameter("otp3");
        String otp4 = request.getParameter("otp4");

        int otp11 = Integer.parseInt(otp);
        int otp22 = Integer.parseInt(otp2);
        int otp33 = Integer.parseInt(otp3);
        int otp44 = Integer.parseInt(otp4);

        int n1 = (int) session.getAttribute("n1");
        int n2 = (int) session.getAttribute("n2");
        int n3 = (int) session.getAttribute("n3");
        int n4 = (int) session.getAttribute("n4");

        if (otp11 == n1 && otp22 == n2 && otp33 == n3 && otp44 == n4) {
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            String mobile = (String) session.getAttribute("mobile");
            String password = (String) session.getAttribute("password");

            Model m = new Model();
            m.setName(name);
            m.setEmail(email);
            m.setMobile(mobile);
            m.setPassword(password);

            int data = Dao.signupdata(m);

            if (data > 0) {
                response.sendRedirect("login.jsp");
            } else {
    %>
                <div class="error-message">
                    <p>Signup Failed! Please Try Again</p>
                </div>
                <a href="signup.jsp" class="retry-link">Go back to Signup</a>
    <%
            }
        } 
        else 
        {
    %>
        <h2>OTP Verification Failed</h2>
        <div class="error-message">
            <p>Invalid OTP entered. Please check and try again.</p>
        </div>
        <a href="signup.jsp" class="retry-link">Go back to Signup</a>
    <%
        }
    %>
</div>
</body>
</html>
