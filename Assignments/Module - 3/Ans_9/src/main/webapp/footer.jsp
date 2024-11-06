<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Website Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .footer {
            background-color: #007bff; /* Primary color for footer */
            color: white; /* White text color */
            padding: 20px 0;
            text-align: center;
        }
    </style>
</head>
<body>

<footer class="footer">
    <div class="container">
        <p>&copy; <span id="year"></span> Your Company Name. All rights reserved.</p>
        <p>
            <a href="privacy.jsp" class="text-white">Privacy Policy</a> | 
            <a href="terms.jsp" class="text-white">Terms of Service</a>
        </p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    // Update the year in the footer dynamically
    document.getElementById('year').textContent = new Date().getFullYear();
</script>

</body>
</html>
