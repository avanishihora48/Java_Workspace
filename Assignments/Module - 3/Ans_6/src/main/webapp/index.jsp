<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Validation</title>

<script type="text/javascript">

function validateForm() 
{
    var fname = document.getElementById('fname');
    var lname = document.getElementById('lname');
    var email = document.getElementById('email');
    var mobile = document.getElementById('mobile');
    var pass = document.getElementById('pass');

    if (checkFName(fname, "Please enter only letters for your name")) 
    {
    	if (checkLName(lname, "Please enter only letters for your name")) 
        {
	        if (checkEmail(email, "Please enter a valid email address")) 
	        {
	            if (checkMobile(mobile, "Please enter a valid 10-digit mobile number")) 
	            {
	                if (checkPass(pass, "Password must contain at least one uppercase letter, one special character, one digit, and be at least 8 characters long")) 
	                {
	                    return true;
	                }
	            }
	        }
	    }
    }
    return false; 
}

function checkFName(elem, msg) 
{
    var nm = /^[a-zA-Z]+$/;
    if (elem.value.match(nm)) {
        return true;
    } else {
        alert(msg);
        elem.focus();
        return false;
    }
}

function checkLName(elem, msg) 
{
    var nm = /^[a-zA-Z]+$/;
    if (elem.value.match(nm)) {
        return true;
    } else {
        alert(msg);
        elem.focus();
        return false;
    }
}


function checkEmail(elem, msg) 
{
    var em = /^[\w\-\.\+]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z0-9]{2,4}$/;
    if (elem.value.match(em)) {
        return true;
    } else {
        alert(msg);
        elem.focus();
        return false;
    }
}

function checkMobile(elem, msg) 
{
    var mob = /^[0-9]{10}$/; 
    if (elem.value.match(mob)) 
    {
        return true;
    } 
    else 
    {
        alert(msg);
        elem.focus();
        return false;
    }
}

function checkPass(elem, msg) 
{
    var pass = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\[\]:;<>,.?/~_+\-=|\\]).{8,}$/;
    if (elem.value.match(pass)) 
    {
        return true;
    }
    else 
    {
        alert(msg);
        elem.focus();
        return false;
    }
}
</script>
</head>
<body>

<form onsubmit="return validateForm();" method="post" action="StudentForm">
    <fieldset>
    
        <legend>Information</legend>

        <p>Enter your Firstname: <input type="text" id="name" name="fname"></p>
        <p>Enter your Lastname: <input type="text" id="name" name="lname"></p>
        <p>Enter your Email: <input type="text" id="email" name="email"></p>
        <p>Enter your Mobile: <input type="text" id="mobile" name="mobile"></p> 
        <p>Enter your password: <input type="text" id="pass" name="pass"></p>
        <p><input type="submit" value="Check Form" /></p>
        
    </fieldset>
</form>

</body>
</html>
