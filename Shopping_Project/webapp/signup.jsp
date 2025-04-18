<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
	
	<jsp:include page="header.jsp"/>
		<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
		<h4 class="card-title mt-3 text-center">Create Account</h4>
		<p class="text-center">Get started with your free account</p>
		
		
		<form action="register.jsp">
			
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-user"></i>
					</span>
				</div>
				<input name="name" class="form-control" placeholder="Full name"
					type="text" id="name">
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-envelope"></i>
					</span>
				</div>
				<input name="email" class="form-control" placeholder="Email address"
					type="email" id="email" onblur="verifyEmail()">
					
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-phone"></i>
					</span>
				</div>
				<select class="custom-select" style="max-width: 120px;">
					<option selected="">+91</option>
					<option value="1">+1</option>

				</select> <input name="phone" class="form-control"
					placeholder="Phone number" type="text" id="phone">
			</div>
			<!-- form-group// -->
			<!-- <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected=""> Select job type</option>
			<option>Designer</option>
			<option>Manager</option>
			<option>Accaunting</option>
		</select>
	</div> form-group end.// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i>
					</span>
				</div>
				<input class="form-control" placeholder="Create password"
					type="password" name="password" id="password">
			</div>
			<!-- form-group// -->
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-lock"></i>
					</span>
				</div>
				<input name="repassword" class="form-control"
					placeholder="Repeat password" type="password" id="repassword">
			</div>
			<!-- form-group// -->
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">
					Create Account</button>
			</div>
			<!-- form-group// -->
			<p class="text-center">
				Have an account? <a href="signin.jsp">Log In</a>
			</p>
		</form>
		<span id="tops"></span>
		</article>
	</div>
	<!-- card.// -->
		
	
	
	<jsp:include page="footer.jsp"/>

</body>
</html>