<%@page import="java.util.UUID"%>
<%@page import="com.dao.Dao"%>
<%@page import="com.model.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty property="*" name="m"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

  Model m2 = Dao.signindata(m);

  if(m2!=null)
  {
	  String citizenID = "CIT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	  session.setAttribute("project", true);
	  session.setAttribute("fname",m2.getFname());
	  session.setAttribute("lname", m2.getLname());
	  session.setAttribute("gender", m2.getGender());
	  session.setAttribute("email", m2.getEmail());
	  session.setAttribute("phone", m2.getCity());
	  session.setAttribute("city", m2.getCity());
	  session.setAttribute("password", m2.getPassword());
	  session.setAttribute("repassword", m2.getRepassword());
	  session.setAttribute("citizenId", m2.getCitizenId());
	  response.sendRedirect("dashboard.jsp");
  }
  else
  {
	  out.print("Login Fail");
  }
%>
</body>
</html>