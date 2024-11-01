<%@page import="com.dao.Dao" %>
<%@page import="com.model.Model" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty property="*" name="m"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<%
    
    String fname = request.getParameter("fname");  
    String lname = request.getParameter("lname"); 
    String email = request.getParameter("email");  
    String mobile = request.getParameter("mobile");  
    String address = request.getParameter("address");  
    String gender = request.getParameter("gender");  
    String pass = request.getParameter("password");
    String repass = request.getParameter("repass");

    boolean hasError = false;

    if (fname == null || fname.trim().isEmpty()) {
        out.print("<p>Please enter First Name!</p>");
        hasError = true;
    }
    if (email == null || email.trim().isEmpty()) {  
        out.print("<p>Please enter Email!</p>");  
        hasError = true;
    }
    if (mobile == null || mobile.trim().isEmpty()) {
        out.print("<p>Please enter Phone!</p>");  
        hasError = true;
    }
    if (pass == null || pass.trim().isEmpty()) {
        out.print("<p>Please enter Password!</p>");  
        hasError = true;
    }
    if (repass == null || repass.trim().isEmpty()) {
        out.print("<p>Please enter Repassword!</p>");  
        hasError = true;
    } else if (!pass.equals(repass)) {
        out.print("<p>Passwords do not match!</p>");
        hasError = true;
    }
    
    if (!hasError) 
    {
        try 
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg", "root", "");  
            PreparedStatement ps = con.prepareStatement("select * from user where email=?");  
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {       
                out.println("<h1>Email Id Already exists, try entering new Email Address.</h1>");       
            } 
            else 
            {
             
                int n1 = 1 + (int)(9 * Math.random());
                int n2 = 1 + (int)(9 * Math.random());
                int n3 = 1 + (int)(9 * Math.random());
                int n4 = 1 + (int)(9 * Math.random());
            
                System.out.print("Generated OTP: " + n1 + n2 + n3 + n4);

                request.setAttribute("e1", email);
                session.setAttribute("n1", n1);
                session.setAttribute("n2", n2);
                session.setAttribute("n3", n3);
                session.setAttribute("n4", n4);
                session.setAttribute("fname", fname);
                session.setAttribute("lname", lname);
                session.setAttribute("email", email);
                session.setAttribute("mobile", mobile);
                session.setAttribute("address", address);
                session.setAttribute("gender", gender);
                session.setAttribute("password", pass);
                session.setAttribute("repass", repass);

                RequestDispatcher rd = request.getRequestDispatcher("EmailSendingServlet");
                rd.forward(request, response);

                /*int data = Dao.signupdata(m); 
                if (data > 0) {
                    out.print("Registration successful!");
                } else {
                    out.print("Registration failed!");
                }*/
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            out.print("<p>Internal error, please try again later.</p>");
        }
    }
%>
</body>
</html>
