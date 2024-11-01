<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light background for contrast */
        }
        .signup-container {
            margin: 50px auto;
            max-width: 600px; /* Set max width for the form */
            padding: 20px;
            background-color: white; /* White background for the form */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Soft shadow */
        }
    </style>
    
    <script type="text/javascript">
	
	function validateForm()
	{
		 var name = document.forms["registrationForm"]["name"].value;
		 var email = document.forms["registrationForm"]["email"].value;
		 var phone= document.forms["registrationForm"]["phone"].value;
		 var password = document.forms["registrationForm"]["password"].value;
		 var repassword = document.forms["registrationForm"]["repassword"].value;
	
		 if(name =="" || email =="" || phone =="" || password =="" || repassword =="")
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

<jsp:include page="header.jsp"/>

<div class="signup-container">
    <h2 class="text-center">Sign Up</h2>
    <form action="register.jsp">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName"  name="fname" placeholder="Enter your first name" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName"  name="lname" placeholder="Enter your last name" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email"  name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="mobile">Mobile</label>
            <input type="tel" class="form-control" id="mobile"  name="mobile" placeholder="Enter your mobile number" required>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <textarea class="form-control" id="address" rows="3"  name="address" placeholder="Enter your address" required></textarea>
        </div>
        <div class="form-group">
            <label>Gender</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="male" value="male" required>
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" value="female" required>
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <div class="form-group">
            <label >Password</label>
            <input type="text" class="form-control" id="password"  name="password" placeholder="Create a password" required>
        </div>
        <div class="form-group">
            <label >Confirm Password</label>
            <input type="text" class="form-control" id="confirmPassword"  name="repass" placeholder="Confirm your password" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Submit</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
