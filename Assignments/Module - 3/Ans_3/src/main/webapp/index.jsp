<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Submit Student Information</h2>
    <form action="submitStudent" method="post">
        First Name: <input type="text" name="fname" required><br><br>
        Last Name: <input type="text" name="lname" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Mobile: <input type="tel" name="mobile" required><br><br>
        Gender:
        <select name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>