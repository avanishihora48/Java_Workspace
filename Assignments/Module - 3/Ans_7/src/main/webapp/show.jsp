<%@page import="java.util.List"%>
<%@page import="dao.Dao" %>
<%@page import="model.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        a {
            margin-right: 10px;
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>

<h2>Student Dashboard</h2>

<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Gender</th>
        <th>Actions</th>
    </tr>
    <%
        List<Model> students = Dao.viewdata();
        for (Model student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getFname() %></td>
        <td><%= student.getLname() %></td>
        <td><%= student.getEmail() %></td>
        <td><%= student.getMobile() %></td>
        <td><%=student.getGender() %></td>
        <td>
            <a href="EditServlet?id=<%= student.getId() %>">Edit</a>
            <a href="DeleteServlet?id=<%= student.getId() %>" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
        </td>
    </tr>
    <%
  
        }
       
    %>
</table>

</body>
</html>