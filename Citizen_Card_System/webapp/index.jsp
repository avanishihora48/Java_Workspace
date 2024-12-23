<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

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
      padding: 10px;
      font-size: 40px;
      z-index: 1000;
      margin: auto;
      /* Ensure header stays on top */
    }

    h1 {
      font-size: 16px;
      margin: 0;
      text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
    }
    
    nav {
  display: flex; /* Arrange links in a row */
  justify-content: center; /* Center links horizontally */
  align-items: center; /* Align links vertically */
  padding: 10px 20px;
}

  nav a {
  color: white; /* Text and icon color */
  text-decoration: none; /* Remove underline */
  margin: 0 10px; /* Space between links */
  font-size: 16px; /* Adjust font size */
  display: flex; /* Use flexbox for the link container */
  align-items: center; /* Align text and icon vertically */
  gap: 5px; /* Space between icon and text */
  transition: color 0.3s ease;
}

    nav a:hover {
      color: rgb(90, 90, 243);
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
      
      .navbar {
         flex-direction: column;
         align-items: center;
       }

	  .nav-link {
	    margin: 10px 0;
	  }
    }

    
  </style>
</head>

<body>
  <!-- Header -->
  <header>
    <h1><img src="image/satyamev_jayate.png" style="height: 50px; width: 40px;">Citizen Card System</h1>
    <nav>
      <a href="home.html">Home</a>
      <a href="aboutus.html">About Us</a>
      <a href="signup.jsp">Sign Up</a>
      <a href="signin.jsp">Sign In</a>
      
    </nav>
  </header>

  <!-- Carousel with Custom Size -->
  <div id="carouselExample" class="carousel slide small-carousel" data-bs-ride="carousel" data-bs-interval="3000">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="image/4.jpg" class="d-block w-100">
      </div>
      <div class="carousel-item">
        <img src="image/3.webp" class="d-block w-100">
      </div>
      <div class="carousel-item">
        <img src="image/1.jpg" class="d-block w-100">
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>

  <!--About Citizenship -->

  <div>
    <h3>About Citizenship</h3>
  </div>

  <div id="citizen">
    <p>Indian citizenship can be acquired by birth, descent, registration and naturalization.</p>

    <p>The conditions and procedure for acquisition of Indian citizenship as per the provision</p>

    <p>of the Citizenship Act, 1955 can be read at the Link : <button class="btn">ACQUISITION</button></p>

  </div>
  <!--About Citizenship end -->

  <!-- Orders And Circulars -->
  <div>
    <h3>Orders And Circulars</h3>
  </div>
  <div id="orders">
    <marquee onmouseover="stop(this.value)" onmouseout="start(this.value)" direction="up" behaviour="scroll"
      scrollamount="4" height="100vh">
      <ul>
        <li>Extension of Delegation of powers to the District Collectors of North and South Goa</li>
        <li>Clarification on documents to be submitted by the applicants for grant of Indian Citizenship under Section
          6B
          and
          Schedule-1A of the Citizenship Act, 1955</li>
        <li>Order - The Citizenship (Amendment) Rules, 2024 under the Citizenship (Amendment) Act, 2019(CAA, 2019) new
          Delegation of power to the District Collectors of North and South Goa-reg.</li>
        <li>Delegation of powers of the Central Government for registration as a citizen of India Under Section 5 or for
          grant of
          certificate of Naturalisation Under Section 6 of the Citizenship Act, 1955 in respect of any person belonging
          to
          specified minority community in Afghanistan, Bangladesh or Pakistan, to Collectors of 13 Districts and Home
          Secretaries
          of 2 States
          Clarification sought by DM, Jodhpur regarding granting citizenship to minority migrants from Pakistan.
          Delegation of powers to grant citizenship to collectors of 16 districts and Secretary(Home) of 7 states till
          further
          orders.</li>
        <li>Reduction in fees and delegation of power to sign the application and taking oath of allegiance to SDMS with
          respect to
          person belonging to minority community in Afghanistan, Bangladesh and Pakistan namely (s, Sikhs, Buddhists,
          Jains,
          Parsis and Christians).
          Delegation of power exercisable by Central Government Under sub-Section (2) of section 9 of the Citizenship
          Act,1955 to
          District Collectors of North Goa and South Goa.</li>
        <li>Gazette Notification of the Citizenship Act, 1955(57 of 1955) for delegation of powers to District
          Collectors in
          7
          States.</li>
        <li>Suggestions on draft amendment to the Citizenship Act, 1955.</li>
        <li>Whereas, India has acquired certain Bangladeshi Enclaves pursuant to ratification of the agreement between
          the
          Government of Republic of India and People's Republic of Bangladesh.</li>
        <li>Delegation of Power to the Heads of Indian Mission abroad for registering the birth of Children even after
          expiry of one
          year of its occurrence Under Section 4 of the Citizenship Act, 1955.</li>
        <li>Delegation of Power to District Magistrate, Cooch Behar, West Bengal.</li>
        <li>The Citizenship(Amendment) Act, 2015
          Merger of PIO and OCI
          Permission/exemption for manual acceptance of application for grant of Indian Citizenship to Minority
          Community
          migrated
          from Pakistan/Afghanistan.</li>
      </ul>
    </marquee>
  </div>
  <!-- Orders And Circulars end -->

  <!-- services -->
  <div>
    <h3>Online Services - Citizenship Amendment Act (CAA)</h3>
  </div>

  <div id="services">
    <h5>Acquisition of Indian citizenship</h5>
    <p>
      A special provision exists for the submission of applications for Indian Citizenship under the Citizenship
      Amendment
      Act
      of 2019. It is specifically for individuals who entered India on or before 31st December, 2014, and belonging to
      Hindu
      or Sikh or Buddhist or Jain or Parsi or Christian community from Pakistan or Afghanistan or Bangladesh.

      For more detailed information, individuals may refer to the provisions outlined in the Citizenship Act of 1955.

      Individuals who wish to submit an application must have their own unique email ID and mobile number.

      Applicant may click on button "click to submit application for Indian Citizenship under CAA 2019" and log in using
      your
      personal email ID and mobile number.
    </p>
  </div>
  <!-- services end -->
  <!-- Footer -->
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
  <!-- footer end -->
  <!-- JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>

</body>

</html>