<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="m" class="com.model.Model"/>
<jsp:setProperty property="*" name="m"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Profile</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <style>
    body {
      background-color: #f8f9fa; /* Light background for the page */
    }

    .profile-card {
      max-width: 400px;
      margin: 50px auto;
      background: white;
      box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
      border-radius: 10px;
      overflow: hidden;
    }

    .profile-card img {
      width: 100%;
      border-bottom: 2px solid #00bcd4;
    }

    .profile-card .card-body {
      padding: 20px;
      text-align: center;
    }

    .profile-card .card-body h4 {
      font-size: 22px;
      margin-bottom: 10px;
      color: #333;
    }

    .profile-card .card-body p {
      color: #777;
      margin-bottom: 20px;
    }

    .profile-card .card-body .btn-primary {
      background-color: #00bcd4;
      border: none;
    }

    .profile-card .card-body .btn-primary:hover {
      background-color: #0097a7;
    }

    .social-links {
      display: flex;
      justify-content: center;
      gap: 15px;
      margin-top: 20px;
    }

    .social-links a {
      font-size: 20px;
      color: #333;
      transition: color 0.3s;
    }

    .social-links a:hover {
      color: #00bcd4;
    }
  </style>
</head>
<body>

  <% 
    if (session.getAttribute("fname") != null) { 
  %>
  
  <div class="profile-card">
    <div class="card-body">
      <h4><%= session.getAttribute("fname") %>&nbsp;<%= session.getAttribute("lname") %></h4>
      <p>Email: <%= session.getAttribute("email") %></p>
      <p>Phone: <%= session.getAttribute("phone") %></p>
      <p>Gender: <%= session.getAttribute("gender") %></p>
      <p>City: <%= session.getAttribute("city") %></p>
      <p>Citizen ID: <%= session.getAttribute("citizenId") %></p>
      
      <button class="btn btn-primary">Edit Profile</button>

      <div class="social-links">
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-linkedin"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
  </div>
  
  <% 
    } 
    else {
      out.print("<h3>You need to log in first</h3>");
    }
  %>
  
</body>
</html>
