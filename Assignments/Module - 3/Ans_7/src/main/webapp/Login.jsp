
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>User Login</h2>
<form action="LoginServlet" method="post">
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="text" name="pass" required><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>