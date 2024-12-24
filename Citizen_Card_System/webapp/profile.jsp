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
      background-color: #f1f3f5; /* Light background for the page */
      font-family: 'Arial', sans-serif;
    }

    .profile-card {
      max-width: 450px;
      margin: 50px auto;
      background: #fff;
      box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
      border-radius: 15px;
      overflow: hidden;
      padding: 20px;
    }

    .profile-card img {
      width: 100%;
      border-radius: 10px;
      object-fit: cover;
    }

    .profile-card .card-body {
      padding: 20px;
      text-align: center;
    }

    .profile-card .card-body h4 {
      font-size: 30px;
      margin-bottom: 15px;
      color: #333;
      font-weight: bold;
    }

    .profile-card .card-body p {
      color: #555;
      font-size: 16px;
      margin-bottom: 10px;
    }

    .profile-card .card-body p span {
      font-weight: 600;
      color: #333;
    }

    .profile-card .card-body .btn-primary {
      background-color: #007bff;
      border: none;
      border-radius: 50px;
      padding: 12px 25px;
      font-size: 16px;
      margin-top: 20px;
      transition: background-color 0.3s ease;
    }

    .profile-card .card-body .btn-primary:hover {
      background-color: #0056b3;
    }

    .social-links {
      display: flex;
      justify-content: center;
      gap: 20px;
      margin-top: 25px;
    }

    .social-links a {
      font-size: 25px;
      color: #333;
      transition: color 0.3s ease;
    }

    .social-links a:hover {
      color: #007bff;
    }

    /* For mobile responsiveness */
    @media (max-width: 600px) {
      .profile-card {
        margin: 20px;
        padding: 15px;
      }

      .profile-card .card-body h4 {
        font-size: 26px;
      }

      .profile-card .card-body p {
        font-size: 14px;
      }

      .profile-card .card-body .btn-primary {
        font-size: 14px;
        padding: 10px 20px;
      }
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
      <p><span>Email:</span> <%= session.getAttribute("email") %></p>
      <p><span>Phone:</span> <%= session.getAttribute("phone") %></p>
      <p><span>Gender:</span> <%= session.getAttribute("gender") %></p>
      <p><span>City:</span> <%= session.getAttribute("city") %></p>
      <p><span>Citizen ID:</span> <%= session.getAttribute("citizenId") %></p>
      <p><span>Gas Number:</span> <%=session.getAttribute("gasNumber") %></p>
      <p><span>Vehicle Registration Number:</span> <%=session.getAttribute("vehicleRegistrationNo") %></p>
      <p><span>Engine Number:</span> <%=session.getAttribute("engineNumber") %></p>
      <p><span>Electricity Number:</span> <%=session.getAttribute("electricityNumber") %></p>
      <p><span>Passport Number:</span> <%=session.getAttribute("passportNumber") %></p>
      <button class="btn btn-primary">Edit Profile</button>

      <div class="social-links">
        <a href="#" title="Facebook"><i class="fab fa-facebook"></i></a>
        <a href="#" title="Twitter"><i class="fab fa-twitter"></i></a>
        <a href="#" title="LinkedIn"><i class="fab fa-linkedin"></i></a>
        <a href="#" title="Instagram"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
  </div>

  <% 
    } 
    else {
      out.print("<h3 style='text-align: center; color: #007bff;'>You need to log in first</h3>");
    }
  %>

</body>
</html>
