<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>OTP Verification Form</title>
  <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: Arial, sans-serif;
    }
    body {
      display: flex;
      align-items: center;
      justify-content: center;
      min-height: 100vh;
      background-color: #f0f2f5;
    }
    .container {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
      padding: 30px 40px;
      width: 320px;
      text-align: center;
    }
    .container header {
      font-size: 48px;
      color: #4caf50;
      margin-bottom: 10px;
    }
    .container h4 {
      font-size: 20px;
      color: #333;
      margin-bottom: 20px;
    }
    .otp-input-field {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
    }
    .otp-input-field input[type="text"] {
      width: 60px;
      height: 60px;
      text-align: center;
      font-size: 24px;
      border: 1px solid #ddd;
      border-radius: 8px;
      transition: all 0.2s ease;
    }
    .otp-input-field input[type="text"]:focus {
      border-color: #4caf50;
      box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
    }
    .verify-button {
      background-color: #4caf50;
      color: #fff;
      font-size: 18px;
      padding: 10px;
      width: 100%;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .verify-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <header>
      <i class="bx bxs-check-shield"></i>
    </header>
    <h4>Enter OTP Code</h4>
    <form action="otpcheck.jsp">
      
        <div class="input-field">
         
          <input type="number" name="otp" />
           <input type="number" name="otp2" />
            <input type="number" name="otp3" />
             <input type="number" name="otp4" />
          
        </div>
        
        <input type="submit">Verify OTP</button>
      
      </form>
  
 
</body>
</html>
