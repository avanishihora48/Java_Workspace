<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Registration Form</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
    <script type="text/javascript">
	
	function validateForm()
	{
		 var fname = document.forms["registrationForm"]["fname"].value;
		 var lname = document.forms["registrationForm"]["lname"].value
		 var gender = document.forms["registrationForm"]["gender"].value
		 var email = document.forms["registrationForm"]["email"].value;
		 var phone= document.forms["registrationForm"]["phone"].value;
		 var city = document.forms["registrationForm"]["city"].value;
		 var password = document.forms["registrationForm"]["password"].value;
		 var repassword = document.forms["registrationForm"]["repassword"].value;
	
		 if(fname =="" || lname=="" || gender=="" || email =="" || phone =="" || city=="" || password =="" || repassword =="")
		 {
		    alert('All Fields are mandatory!!');
		    return false;
		 }
		 if(password!=repassword)
		 {
		    alert('Password and Repassword mismatched!!')
		    return false;
		 }
		 else
		 {
			    return true;
		 }
	
	}
	
	 function isNumeric(elem, helperMsg)
	 {
	 	var numericExpression = /^[0-9]+$/;
	 	if(elem.value.match(numericExpression))
	     {
	 		return true;
	 	}
	 	else
	 	{
	 		alert(helperMsg);
	 		elem.focus();
	 		return false;
	 	}
	 }
	 
	 // Validating password and confirmPassword
	 function isEquals(elem, helperMsg)
	 {
		 if(repassword.equals(password))
			 {
			    return true;
			 }
		 else
			 {
			    alert(helperMsg);
			    elem.focus();
			    return false;
			 }
	 }
	 
	 // Validating Name Field
	 function isAlphabet(elem, helperMsg)
	 {
		 var alphaExp = /^[a-zA-Z]+$/;
		  if(elem.value.match(alphaExp))
			  {
			     return true;
			  }
		  else 
			  {
			     alert(helperMsg);
			     elem.focus();
			     return false;
			  }
	 }
	 
	 // Length Restriction
	 function lengthRestriction(elem, min, max)
	 {
		 var uInput = elem.value;
		 if(uInput.length >= min && uInput.length <= max)
			 {
			    return true;
			 }
		 else
			 {
			    alert("Please enter between " + min+ " and " +max+ "characters");
			    elem.focus();
			    return false;
			 }
	 }
	 // Email validator
	  function emailValidator(elem, helperMsg)
	 {
	  var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	   if(elem.value.match(emailExp)){
	  	return true;
	    }
	    else
	    {
	       alert(helperMsg);
	       elem.focus();
	        return false;
	    }
	  }
	  function verifyEmail()
	  {
	 	 var email = document.forms["registrationForm"]["email"].value;
	 	 $.ajax({
	 		 type: 'POST', url: 'validatorAjax.jsp', data: {email: email},
	 		 success: function (response) 
	 		 {
	 			 if(response === "available")
	 				 {
	 				    alert("Email is available.");
	 				 }
	 			 else if(response === "unavailable")
	 				 {
	 				    alert("Email already exists, try entering another Email.")
	 				 }
	 		 }
	 	 });
	  }

</script>
</head>
<body>
<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Event Registration Form</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="registration.jsp">
                        <!-- Name Input -->
                        <div class="form-row m-b-55">
                            <div class="name">Name</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="fname" required>
                                            <label class="label--desc">First Name</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="lname" required>
                                            <label class="label--desc">Last Name</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Gender Input -->
                        <div class="form-row m-b-55">
                            <div class="name">Gender</div>
                            <div class="value">
                                <label class="radio-container">Male
                                    <input type="radio" name="gender" value="Male" required>
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Female
                                    <input type="radio" name="gender" value="Female" required>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>

                        <!-- Email Input -->
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email" required>
                                    <label class="label--desc">Email</label>
                                </div>
                            </div>
                        </div>

                        <!-- Phone Number Input -->
                        <div class="form-row">
                            <div class="name">Phone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="phone" name="phone" required>
                                    <label class="label--desc">Phone</label>
                                </div>
                            </div>
                        </div>

                        <!-- City Input -->
                        <div class="form-row">
                            <div class="name">City</div>
                            <div class="value">
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="city" required>
                                        <option disabled="disabled" selected="selected">Choose City</option>
                                        <option>New York</option>
                                        <option>Los Angeles</option>
                                        <option>Chicago</option>
                                        <option>Miami</option>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>

                        <!-- Password Input -->
                        <div class="form-row m-b-55">
                            <div class="name">Password</div>
                            <div class="value">
                                <div class="input-group-desc">
                                    <input class="input--style-5" type="password" name="password" required>
                                    <label class="label--desc">Password</label>
                                </div>
                            </div>
                        </div>

                        <!-- Confirm Password Input -->
                        <div class="form-row m-b-55">
                            <div class="name">Confirm Password</div>
                            <div class="value">
                                <div class="input-group-desc">
                                    <input class="input--style-5" type="password" name="repassword" required>
                                    <label class="label--desc">Confirm Password</label>
                                </div>
                            </div>
                        </div>

                       
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This template was made by Colorlib (https://colorlib.com) -->

</html>