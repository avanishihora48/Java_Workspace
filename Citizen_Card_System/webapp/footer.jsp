<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="main.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="./css/solution.css">

  <!-- Inline CSS -->
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      overflow-x: hidden;
      scroll-behavior: smooth;
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      color: #333;
      line-height: 1.6;
      padding: 0;
      margin-left: 30px;
      margin-right: 30px;
      border: black 3px solid;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: black;
      position: sticky;
      top: 0;
      height: 60px;
      color: white;
      padding: 14px;
      font-size: 18px;
      z-index: 1000;
      /* Ensure header stays on top */
    }

    h1 {
      font-size: 16px;
      margin: 0;
      text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
    }

    nav a {
      color: white;
      text-decoration: none;
      padding: 1px 5px;
      /* Minimal padding */
      margin: 1 3px;
      /* Reduced margin */
      font-size: 15px;
      /* Smaller font size */
      border-radius: 2px;
      /* Slight rounding */
      transition: color 0.3s;
    }

    nav a:hover {
      color: rgb(90, 90, 243);
    }

    @media (max-width: 768px) {

      /* Further reduce size on small screens */
      nav a {
        font-size: 8px;
        padding: 1px 2px;
        margin: 0 2px;
      }

      h3 {
        font-size: 20px;
      }

      #citizen p,
      marquee li {
        font-size: 14px;
      }

      #citizen .btn {
        padding: 6px 10px;
      }
    }

    footer {
      background-color: black;
      color: white;
      border-top: 1px solid #444;
      display: flex;
      justify-content: space-between;
      padding: 10px;
      text-align: center;
      font-size: 18px;
      margin-top: 10px;
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

    .footer-center a {
      color: white;
      text-decoration: none;
    }

    .footer-right .fa {
      color: white;
      margin-right: 8px;
      transition: color 0.3s;
    }

    .footer-right .fa:hover {
      color: rgb(90, 90, 243);
    }

    img {
      max-width: 100%;
      height: auto;
      margin: 5px;
    }

    /* Custom small carousel styling */
    .small-carousel {
      max-width: 600px;
      max-height: 400px;
      margin: auto;
    }

    .small-carousel .carousel-inner img {
      height: 400px;
      object-fit: cover;
    }

    h3 {
      text-align: center;
      background-color: black;
      color: white;
      margin-top: 5px;
    }

    #citizen {
      width: 80%;
      /* Adjusted for responsiveness */
      max-width: 700px;
      margin: 20px auto;
      /* Centered with auto margins */
      padding: 20px;
      text-align: justify;
      /* Ensures even text alignment */
      border: 2px dotted #333;
      /* Subtle border for better appearance */
      background-color: #fff;
      /* Added background for contrast */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      /* Soft shadow for depth */
      border-radius: 8px;
      /* Rounded corners for a modern look */
    }

    #citizen h3 {
      text-align: center;
      color: #333;
      /* Neutral color for heading */
      font-size: 18px;
      margin-bottom: 10px;
    }

    #citizen a {
      color: #007bff;
      /* Bootstrap link color */
      text-decoration: none;
      font-weight: bold;
    }

    #citizen a:hover {
      text-decoration: underline;
      /* Clear indication of interaction */
    }

    .btn {
      background-color: orangered;
      color: white;
      border-radius: 4px;
    }

    .btn:hover {
      background-color: red;
      color: white;
      border-radius: 4px;
    }



    #orders ul li {
      padding: 10px;
      gap: 2px;

    }

    #services {
      width: 80%;
      /* Adjusted for responsiveness */
      max-width: 700px;
      margin: 20px auto;
      /* Centered with auto margins */
      padding: 20px;
      text-align: justify;
      /* Ensures even text alignment */
      border: 2px dotted #333;
      /* Subtle border for better appearance */
      background-color: #fff;
      /* Added background for contrast */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      /* Soft shadow for depth */
      border-radius: 8px;
      /* Rounded corners for a modern look */
    }

    #services h5 {
      text-align: center;
      color: black;
      /* Neutral color for heading */
      font-size: 18px;
      margin-bottom: 10px;
    }

    #services a {
      color: #007bff;
      /* Bootstrap link color */
      text-decoration: none;
      font-weight: bold;
    }
  </style>
</head>
<body>
<footer>
    <div class="footer-left">
      <h5>Address</h5>
      <p>Phone: 123-456-7890</p>
      <p>Email: info@organization.com</p>
      <p>Address: 123 Main St, City, State</p>
    </div>
    <div class="footer-center">
      <h5>Quick Links</h5>
      <ul>
        <li><a href="">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">FAQs</a></li>
        <li><a href="#">Contact Us</a></li>
        <li><a href="#">Privacy Policy</a></li>
        <li><a href="#">Terms of Service</a></li>
      </ul>
    </div>
    <div class="footer-right">
      <h5>Follow Us</h5>
      <div>
        <i class="fa fa-facebook" aria-label="Facebook"></i>
        <i class="fa fa-instagram" aria-label="Instagram"></i>
        <i class="fa fa-twitter" aria-label="Twitter"></i>
      </div>
      <p>&copy; 2024 Your Organization. All rights reserved.</p>
    </div>
  </footer>
</body>
</html>