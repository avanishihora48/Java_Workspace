<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
   <!-- basic -->
   <meta charset="UTF-8">

   <!-- mobile metas -->
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="viewport" content="initial-scale=1, maximum-scale=1">
   <!-- site metas -->
   <title>webwing</title>
   <meta name="keywords" content="">
   <meta name="description" content="">
   <meta name="author" content="">
   <!-- bootstrap css -->
   <link rel="stylesheet" href="css/bootstrap.min.css">
   <!-- style css -->
   <link rel="stylesheet" href="css/style.css">
   <!-- Responsive-->
   <link rel="stylesheet" href="css/responsive.css">
   <link rel="stylesheet" href="css/owl.carousel.min.css">
   <!-- fevicon -->
   <link rel="icon" href="images/fevicon.png" type="image/gif" />
   <!-- Scrollbar Custom CSS -->
   <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
   <!-- Tweaks for older IEs-->
   <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
   <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

   <style type="text/css">
   
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
<!-- body -->

<body class="main-layout">
   <!-- loader  -->
   <div class="loader_bg">
      <div class="loader"><img src="images/loading.gif" alt="#" /></div>
   </div>
   <!-- end loader -->
   <!-- header -->
   <header>
      <!-- header inner -->
      <div class="header">
         <div class="header_to d_none">
            <div class="container">
               <div class="row">
                  <ul class="social_icon1">
                     <li> Follow Us
                     </li>
                     <li> <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i>
                        </a>
                     </li>
                     <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                     <li> <a href="#"> <i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                     <li> <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i>
                        </a>
                     </li>
                  </ul>
               </div>

               <div>
                  <%
                     if (session.getAttribute("project") != null) {
                  %>
                  <h3 style="margin-left: 900px; color: white;">Welcome:<br>Your Name:<%= session.getAttribute("name") %></h3>
                  <h3 style="margin-left: 900px; color: white;">Your Email:<%= session.getAttribute("email") %></h3>
                  <h3 style="margin-left: 900px; color: white;">Your Number:<%= session.getAttribute("phone") %></h3>
                  <%
                     }
                     %>
               </div>

            </div>
         </div>
         <div class="header_midil">
            <div class="container">
               <div class="row d_flex">
                  <div class="col-md-4 col-sm-4 d_none">
                     <ul class="conta_icon">
                        <li><a href="#"><i class="fa fa-phone" aria-hidden="true"></i> Call Us : +01 1234567890</a> </li>
                     </ul>
                  </div>
                  <div class="col-md-4 col-sm-4 ">
                     <a class="logo" href="#"><img src="images/logo.png" alt="#" /></a>
                  </div>
                  <div class="col-md-4 col-sm-4 d_none">
                     <ul class="conta_icon ">
                        <li><a href="#"><i class="fa fa-envelope" aria-hidden="true"></i> demo@gmail.com</a> </li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
         <div class="header_bo">
            <div class="container">
               <div class="row">
                  <div class="col-md-9 col-sm-7">
                     <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                           <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                           <ul class="navbar-nav mr-auto">
                              <%
                                 if (session.getAttribute("project") != null) {
                              %>
                              <li class="nav-item">
                                 <a class="nav-link" href="index.jsp"> Home </a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="about.jsp">About</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="product.jsp">Products</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="contact.jsp">Contact</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="wishlist.jsp">Wishlist</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="cart.jsp"> Cart </a>
                              </li>
                              <%
                                 } else {
                              %>
                              <li class="nav-item">
                                 <a class="nav-link" href="index.jsp"> Home </a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="about.jsp">About</a>
                              </li>
                              <%
                                 }
                                 %>
                           </ul>
                        </div>
                     </nav>
                  </div>
                  <div class="col-md-3 col-sm-5 d_none">
                     <%
                        if (session.getAttribute("project") != null) {
                     %>
                     <a class="swd-button" href="logout.jsp">Logout</a>
                     <%
                        } else {
                     %>
                     <a class="swd-button" href="signup.jsp">Sign Up</a>
                     <a class="swd-button" href="signin.jsp">Sign In</a>
                     <%
                        }
                     %>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </header>
   <!-- end header inner -->
   <!-- end header -->

</body>
</html>
