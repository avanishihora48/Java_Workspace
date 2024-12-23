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
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: #000;
      position: sticky;
      top: 0;
      height: 60px;
      color: white;
      padding: 10px 20px;
      font-size: 18px;
      z-index: 1000;
    }

    h1 {
      font-size: 16px;
      margin: 0;
      text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
    }

    nav {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 20px;
    }

    nav a {
      color: white;
      text-decoration: none;
      font-size: 16px;
      padding: 5px 10px;
      transition: color 0.3s ease;
      display: flex;
      align-items: center;
    }

    nav a:hover {
      color: rgb(90, 90, 243);
      
    }

    nav a i {
      margin-right: 8px;
    }

    .btn {
      background-color: orangered;
      color: white;
      border-radius: 4px;
      padding: 8px 12px;
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
      padding: 20px;
      text-align: justify;
      border: 2px dotted #333;
      background-color: #fff;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
    }

    #citizen h3, #services h5 {
      text-align: center;
      font-size: 18px;
      color: #333;
      margin-bottom: 10px;
    }

    #citizen p, #services p {
      font-size: 16px;
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
	  border: 2px solid white;  /* White border */
	  color: white;  /* White text */
	  border-radius: 10px;  /* Increase the border-radius for rounded corners */
	  padding: 7px 20px;  /* Increase padding to make the button bigger */
	  font-size: 16px;  /* Optionally adjust font size for better readability */
	  transition: all 0.3s ease;  /* Smooth transition for hover effect */
	}
	
	.logout:hover {
	  background-color: white;  /* Background turns white on hover */
	  color: black;  /* Text turns black on hover */
	  border-radius: 10px;  /* Keep the same rounded corners on hover */
	  padding: 7px 20px; /* Keep the padding the same on hover */
	  font-size: 16px;  /* Keep the font size consistent on hover */
	}


    @media (max-width: 768px) {
      header {
        flex-direction: column;
        text-align: center;
        height: auto;
        padding: 10px;
      }

      nav {
        flex-direction: column;
        align-items: center;
      }

      nav a {
        font-size: 14px;
        margin: 8px 0;
      }

      #citizen, #services {
        width: 90%;
        margin-top: 10px;
      }

      h3, h5 {
        font-size: 20px;
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
        <a href="contactus.html">Contact Us</a>
        <a href="ratings.html">Rate Us</a>
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
