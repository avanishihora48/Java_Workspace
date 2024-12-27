<%@ page import="com.model.ProductModel"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dao.Dao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<h2>Product Dashboard</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Image</th>
       
    </tr>
	<%
	    List<ProductModel> products = Dao.viewproducts();
	    if (products.isEmpty()) {
	%>
	    <tr>
	        <td colspan="5">No products available.</td>
	    </tr>
	<%
	    } else {
	        for (ProductModel product : products) {
	%>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getP_name() %></td>
        <td><%= product.getP_price() %></td>
        <td><%= product.getP_des() %></td>
        <td><img src="data:image/jpeg;base64,<%= product.getP_image() %>" alt="Product Image" width="50" /></td>
        <td>
            <a href="EditServlet?id=<%= product.getId() %>">Edit</a>
            <a href="DeleteServlet?id=<%= product.getId() %>" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
        </td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>
