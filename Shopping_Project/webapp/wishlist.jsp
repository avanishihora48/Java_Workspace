<%@page import="com.model.WishlistModel"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wishlist</title>
    <style>
        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            grid-gap: 20px;
            padding: 20px;
        }
        .product {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        .product img {
            max-width: 100px;
            max-height: 100px;
        }
        .swd-button {
            background: #f2db18;
            border: 1px solid white;
            border-radius: 5px;
            color: white;
            display: inline-block;
            font: bold 12px Arial, Helvetica, sans-serif;
            padding: 10px 15px;
            text-decoration: none;
            text-transform: uppercase;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<%
    String email = (String) session.getAttribute("email");
    if (session.getAttribute("project") != null && email != null) {
%>
    <div class="product-grid">
        <%
            List<WishlistModel> list = Dao.wishlistbyemail(email);
            for (WishlistModel m : list) {
        %>
            <div class="product">
                 <img src="data:image/jpeg;base64,<%=m.getP_image()%>" width="150px" height="200px" />
                <h3><%= m.getP_name() %></h3>
                <p>Price: <%= m.getP_price() %></p>
                
                <form action="addtocart2.jsp">
                    <input type="hidden" name="id" value="<%= m.getId() %>">
                    <input type="submit" class="swd-button" value="Cart">
                </form>
            </div>
        <% } %>
    </div>
<%
    } else {
%>
    <br>
    <center>
        <b><p style="color:red;font-family: sans-serif; font-size: 25px;">Please Login First!!</p></b>
    </center>
    <br><br>
<% } %>

<jsp:include page="footer.jsp"/>

</body>
</html>
