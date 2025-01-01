<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Citizen Card System</title>

  <!-- CSS Stylesheets -->
  <link rel="stylesheet" href="main.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
    integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
    integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
    crossorigin="anonymous"></script>
  <link rel="stylesheet" href="./css/solution.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

  <!-- Inline CSS -->
  <style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    color: #333;
    line-height: 1.6;
    padding: 0;
    margin: 0;
    overflow-x: hidden;
    scroll-behavior: smooth;
    border: black 3px solid;
    font-size: 18px; /* Increased font size for body text */
  }

  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #000;
    position: sticky;
    top: 0;
    height: 80px; /* Increased header height */
    color: white;
    padding: 15px 30px; /* Increased padding for header */
    font-size: 24px; /* Increased font size for header */
    z-index: 1000;
  }

  h1 {
    font-size: 30px; /* Increased font size for header text */
    margin: 0;
    text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
  }

  nav {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 30px; /* Increased gap between nav items */
  }

  nav a {
    color: white;
    text-decoration: none;
    font-size: 22x; /* Increased font size for nav links */
    padding: 10px 15px; /* Increased padding for nav links */
    transition: color 0.3s ease;
    display: flex;
    align-items: center;
  }

  nav a:hover {
    color: rgb(90, 90, 243);
  }

  nav a i {
    margin-right: 10px; /* Increased space between icon and text */
  }

  .btn {
    background-color: orangered;
    color: white;
    border-radius: 4px;
    padding: 10px 15px; /* Increased padding for buttons */
    font-size: 18px; /* Increased font size for buttons */
  }

  .btn:hover {
    background-color: red;
    border-radius: 4px;
  }

  /* Main Section Styles */
  #citizen, #services {
    width: 80%;
    max-width: 700px;
    margin: 20px auto;
    padding: 25px; /* Increased padding for main sections */
    text-align: justify;
    border: 2px dotted #333;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
  }

  #citizen h3, #services h5 {
    text-align: center;
    font-size: 22px; /* Increased font size for section headings */
    color: #333;
    margin-bottom: 15px;
  }

  #citizen p, #services p {
    font-size: 18px; /* Increased font size for paragraph text */
    color: #444;
  }

  .footer-left,
  .footer-center,
  .footer-right {
    flex: 1;
    padding: 0 10px;
  }

  .footer-center ul {
    list-style: none;
    padding: 0;
  }

  .footer-center li {
    margin: 5px 0;
  }

  .logout {
    background-color: transparent;
    border: 2px solid white;
    color: white;
    border-radius: 10px;
    padding: 5px 20px; /* Increased padding for logout button */
    font-size: 18px; /* Increased font size for logout button */
    transition: all 0.3s ease;
  }

  .logout:hover {
    background-color: white;
    color: black;
    border-radius: 10px;
    padding: 5px 20px; 
    font-size: 18px;
  }

  @media (max-width: 768px) {
    header {
      flex-direction: column;
      text-align: center;
      height: auto;
      padding: 15px;
    }

    nav {
      flex-direction: column;
      align-items: center;
    }

    nav a {
      font-size: 18px; /* Increased font size for mobile nav links */
      margin: 10px 0;
    }

    #citizen, #services {
      width: 90%;
      margin-top: 15px;
    }

    h3, h5 {
      font-size: 24px; /* Increased font size for mobile headings */
    }
  }
</style>

</head>

<body>
  <!-- Header -->
  <header>
  <h1><img src="image/satyamev_jayate.png" style="height: 50px; width: 40px;"> Citizen Card System</h1>
  <nav>
    <% if (session.getAttribute("project") != null) 
   { 
    %>
      <a href="aboutus.html">About Us</a>
      <a href="contactus.jsp">Contact Us</a>
      <a href="ratings.jsp">Rate Us</a>
      <a href="profile.jsp" class="nav-link" aria-label="Profile"><i class="bi bi-person-circle fs-3"></i></a>
      <a href="logout.jsp" class="logout">Logout</a>
    <% 
   } 
    else 
   { 
    %>
    
      <a href="home.html">Home</a>
      <a href="signup.jsp">Sign Up</a>
      <a href="signin.jsp">Sign In</a>
    <%
   } 
    %>
  </nav>
</header>


</body>
</html>
