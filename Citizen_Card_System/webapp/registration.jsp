<%@page import="com.dao.Dao"%>
<%@page import="com.model.*" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty  property="*" name="m" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String city = request.getParameter("city");
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");

    if (email == null || email.trim().equals("")) {
        out.print("<p>Please enter Email!</p>");
    }
    if (phone == null || phone.trim().equals("")) {
        out.print("<p>Please enter Phone!</p>");
    }
    if (password == null || password.trim().equals("")) {
        out.print("<p>Please enter Password!</p>");
    }
    if (repassword == null || repassword.trim().equals("")) {
        out.print("<p>Please enter Repassword!</p>");
    }

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_card_system", "root", "");
        PreparedStatement ps = con.prepareStatement("select * from registration where email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            out.println("<h1>Email Id Already exists, try entering a new Email Address.</h1>");
        } else {
            int n1 = 1 + (int) (9 * Math.random());
            int n2 = 1 + (int) (9 * Math.random());
            int n3 = 1 + (int) (9 * Math.random());
            int n4 = 1 + (int) (9 * Math.random());
            
          
            System.out.print(n1 + " " + n2 + " " + n3 + " " + n4);

            RequestDispatcher rd = request.getRequestDispatcher("EmailSendingServlet");
            request.setAttribute("e1", email);
            session.setAttribute("n1", n1);
            session.setAttribute("n2", n2);
            session.setAttribute("n3", n3);
            session.setAttribute("n4", n4);
            session.setAttribute("fname", fname);
            session.setAttribute("lname", lname);
            session.setAttribute("gender", gender);
            session.setAttribute("email", email);
            session.setAttribute("phone", phone);
            session.setAttribute("city", city);
            session.setAttribute("password", password);
            session.setAttribute("repassword", repassword);
            rd.forward(request, response);
        }
    } catch (Exception e) {
        out.println("<h1>An error occurred. Please try again later.</h1>");
        e.printStackTrace();
    }
%>
</body>
</html>
