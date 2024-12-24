<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citizen Card System</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- CSS Stylesheets -->
  <link rel="stylesheet" href="main.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
    integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
    integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
    crossorigin="anonymous"></script>
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
      margin-left: 30px;
      margin-right: 30px;
      padding: 0;
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
      font-size: 19px;
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
      margin: 0 3px;
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

    .logo {
      display: inline-block;
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
      font-size: 19px;
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
    
   /* Logo Section Styling */
#logos {
  text-align: center;
  margin: 20px 0;
}

/* Logo Container */
.logo-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}

/* Logo Card */
.logo-card {
  background-color: white;
  padding: 16px;
  width: 25%;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  text-align: center;
  transition: transform 0.3s ease;
}

/* Hover Effect */
.logo-card:hover {
  transform: translateY(-5px);
}

/* Logo Image */
.logo-img {
  height: 80px;
  width: auto;
}

/* Logo Title */
.logo-title {
  margin-top: 20px;
  letter-spacing: 3px;
  font-weight: bold;
  color: black;
}

    
  </style>
</head>

<body>
<jsp:include page="header.jsp"/>

 <section id="logos" style="text-align: center; margin: 20px 0;">
  <div class="logo-container">
    <!-- RTO Card -->
    <div class="logo-card" onclick="window.location='insurance.jsp';" style="cursor: pointer;">
      <img src="image/insurance3.png" alt="RTO Logo" class="logo-img">
      <p class="logo-title">INSURANCE</p>
    </div>

    <!-- Voting Card -->
    <div class="logo-card" onclick="window.location='taxation.jsp';" style="cursor: pointer;">
      <img src="image/tax.jpg" alt="Voting Logo" class="logo-img">
      <p class="logo-title">TAXATION</p>
    </div>

    <!-- Banking Card -->
    <div class="logo-card" onclick="window.location='gas.jsp';" style="cursor: pointer;">
      <img src="image/gas.png" alt="Banking Logo" class="logo-img">
      <p class="logo-title">GAS</p>
    </div>
  </div>
</section>

<section id="logos" style="text-align: center; margin: 20px 0;">
  <div class="logo-container">
    <!-- RTO Card -->
    <div class="logo-card" onclick="window.location='rto.jsp';" style="cursor: pointer;">
      <img src="image/rto.png" alt="RTO Logo" class="logo-img">
      <p class="logo-title">RTO</p>
    </div>

    <!-- Voting Card -->
    <div class="logo-card" onclick="window.location='voting.jsp';" style="cursor: pointer;">
      <img src="image/voting.png" alt="Voting Logo" class="logo-img">
      <p class="logo-title">VOTING</p>
    </div>

    <!-- Banking Card -->
    <div class="logo-card" onclick="window.location='banking.jsp';" style="cursor: pointer;">
      <img src="image/banking.jpg" alt="Banking Logo" class="logo-img">
      <p class="logo-title">BANKING</p>
    </div>
  </div>
</section>

<section id="logos" style="text-align: center; margin: 20px 0;">
  <div class="logo-container">
    <!-- Telephone Card -->
    <div class="logo-card" onclick="window.location='telephone.jsp';" style="cursor: pointer;">
      <img src="image/telephone.jpg" alt="RTO Logo" class="logo-img">
      <p class="logo-title">TELEPHONE</p>
    </div>

    <!-- Electricity Card -->
    <div class="logo-card" onclick="window.location='electricity.jsp';" style="cursor: pointer;">
      <img src="image/electricity.png" alt="Voting Logo" class="logo-img">
      <p class="logo-title">ELECTRICITY</p>
    </div>

    <!-- Passport Card -->
    <div class="logo-card" onclick="window.location='passport.html';" style="cursor: pointer;">
      <img src="image/passport.jpg" alt="Banking Logo" class="logo-img">
      <p class="logo-title">PASSPORT</p>
    </div>
  </div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>