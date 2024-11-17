<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <style>
        /* CSS styles as before */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="password"], input[type="email"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4cae4c;
        }

        .error-message, .success-message {
            text-align: center;
            color: red;
            font-size: 0.9em;
            margin-top: 10px;
        }

        .success-message {
            color: green;
        }
    </style>
    
    <script>
        function validateForm() {
            var currentPassword = document.getElementById('currentPassword').value;
            var newPassword = document.getElementById('newPassword').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
            var email = document.getElementById('email').value;

            // Check if current password is correct
            if (!currentPassword || currentPassword.trim() === "") {
                alert("Current password is required.");
                return false;
            }

            // Check if new password is valid
            if (newPassword.length < 6) {
                alert("New password must be at least 6 characters long.");
                return false;
            }

            // Check if new password matches confirm password
            if (newPassword !== confirmPassword) {
                alert("New password and confirm password do not match.");
                return false;
            }

            // If all validations pass
            return true;
        }
    </script>
</head>
<body>

<div class="form-container">
    <h2>Change Password</h2>
    
    <form action="update.jsp" method="post" onsubmit="return validateForm()">
    
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter email" required>
        
        <label for="currentPassword">Current Password:</label>
        <input type="password" id="currentPassword" name="currentPassword" placeholder="Enter current password" required>
        
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" placeholder="Enter new password" required>
        
        <label for="confirmPassword">Confirm New Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm new password" required>
        
        <input type="submit" value="Update Password">
    </form>

    <div id="message" class="error-message"></div>
</div>

</body>
</html>
