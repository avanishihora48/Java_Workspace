<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.model.Model" %>

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

<jsp:include page="header.jsp"/>

<h1 align="center">Welcome</h1>

<img src="img/welcome.png" alt="Welcome Image">
</body>
</html>
