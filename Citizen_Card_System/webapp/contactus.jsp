<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }
        header {
            background-color: black;
            color: white;
            padding: 20px 0;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 2.5em;
        }
        .container {
            width: 80%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #0056b3;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 20px;
        }
        label {
            font-weight: bold;
        }
        input, textarea {
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        textarea {
            resize: vertical;
        }
        button {
            background-color: #0056b3;
            color: white;
            border: none;
            padding: 10px;
            font-size: 1em;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #004494;
        }
        .info {
            margin-top: 30px;
        }
        .info div {
            margin-bottom: 10px;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<header>
    <h1>Citizen Card System</h1>
</header>

<div class="container">
    <h2>Contact Us</h2>
    <p>
        If you have any questions, concerns, or feedback, feel free to reach out to us using the contact form below.
        We’re here to assist you!
    </p>

    <form action="contactinsert.jsp" method="post">
    
    <label for="email">Your Email:</label>
    <input type="email" id="email" name="email" placeholder="Enter your email" 
           value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>" required>

    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" placeholder="Enter subject" required>

    <label for="message">Your Message:</label>
    <textarea id="message" name="message" rows="5" placeholder="Type your message here" required></textarea>

    <button type="submit">Send</button>
</form>

    <div class="info">
        <h3>Contact Information</h3>
        <div><strong>Phone:</strong> +1-800-123-4567</div>
        <div><strong>Email:</strong> support@citizencardsystem.com</div>
        <div><strong>Address:</strong> 123 Citizen Lane, Metropolis, Mumbai</div>
    </div>
</div>

<footer>
    <p>&copy; 2024 Citizen Card System. All rights reserved.</p>
</footer>

</body>
</html>