<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Message Passing System</title>
</head>
<body>
<h2>User Registration</h2>
<form action="MessageController" method="post">
    <input type="hidden" name="action" value="addUser"/>
    First Name: <input type="text" name="fname" required/><br/><br/>
    Last Name: <input type="text" name="lname" required/><br/><br/>
    Email: <input type="email" name="email" required/><br/><br/>
    Mobile: <input type="text" name="mobile" required/><br/><br/>
    <input type="submit" value="Register User"/>
</form>

<h2>Send Message</h2>
<form action="MessageController" method="post">
    <input type="hidden" name="action" value="sendMessage"/>
    User ID: <input type="number" name="uid" required/><br/><br/>
    From: <input type="text" name="from" required/><br/><br/>
    To: <input type="text" name="to" required/><br/><br/>
    Message: <textarea name="msg" required></textarea><br/><br/>
    <input type="submit" value="Send Message"/>
</form>
</body>
</html>