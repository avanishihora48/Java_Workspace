<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Send Message</title>
</head>
<body>
    <h2>Send Message</h2>
    <form action="SendMessageServlet" method="post">
        <label for="receiverEmail">Recipient Email:</label>
        <input type="email" id="receiverEmail" name="receiverEmail" required>
        <br><br>
        
        <label for="messageText">Message:</label>
        <textarea id="messageText" name="messageText" required></textarea>
        <br><br>
        
        <input type="submit" value="Send Message">
    </form>
</body>
</html>
