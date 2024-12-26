<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>OTP Verification</title>
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
      background-color: #f4f6f9;
    }
    .container {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
      padding: 40px 50px;
      width: 350px;
      text-align: center;
    }
    .container header {
      font-size: 48px;
      color: #4caf50;
      margin-bottom: 20px;
    }
    .container h4 {
      font-size: 22px;
      color: #333;
      margin-bottom: 20px;
    }
    .otp-input-field {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
    }
    .otp-input-field input {
      width: 60px;
      height: 60px;
      text-align: center;
      font-size: 24px;
      border: 2px solid #ddd;
      border-radius: 8px;
      transition: all 0.3s ease;
    }
    .otp-input-field input:focus {
      border-color: #4caf50;
      box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
    }
    .otp-input-field input[type="number"] {
      -moz-appearance: textfield;
    }
    .verify-button {
      background-color: #4caf50;
      color: #fff;
      font-size: 18px;
      padding: 12px 0;
      width: 100%;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .verify-button:hover {
      background-color: #45a049;
    }
    .otp-message {
      font-size: 16px;
      color: #333;
      margin-top: 10px;
    }
    .otp-message a {
      color: #4caf50;
      text-decoration: none;
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
      <div class="otp-input-field">
        <input type="number" name="otp1" maxlength="1" oninput="moveFocus(this, 'otp2')" onkeydown="moveFocusBack(event, this, 'otp1')" required />
        <input type="number" name="otp2" maxlength="1" oninput="moveFocus(this, 'otp3')" onkeydown="moveFocusBack(event, this, 'otp1')" required />
        <input type="number" name="otp3" maxlength="1" oninput="moveFocus(this, 'otp4')" onkeydown="moveFocusBack(event, this, 'otp2')" required />
        <input type="number" name="otp4" maxlength="1" onkeydown="moveFocusBack(event, this, 'otp3')" required />
      </div>
      <button type="submit" class="verify-button">Verify OTP</button>
    </form>
    <p class="otp-message">Didn't receive OTP? <a href="#">Resend OTP</a></p>
  </div>

  <script>

    function moveFocus(currentInput, nextInputName) {
      if (currentInput.value.length === 1) {
        const nextInput = document.getElementsByName(nextInputName)[0];
        if (nextInput) {
          nextInput.focus();
        }
      }
    }

    function moveFocusBack(event, currentInput, prevInputName) {
      if (event.key === "Backspace" && currentInput.value === "") {
        const prevInput = document.getElementsByName(prevInputName)[0];
        if (prevInput) {
          prevInput.focus();
        }
      }
    }
  </script>
</body>
</html>
