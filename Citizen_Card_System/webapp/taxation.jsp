<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Taxation Module</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f7fa;
      padding: 20px;
    }

    .container {
      max-width: 500px;
      margin: 0 auto;
      background: white;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      font-weight: bold;
      margin-bottom: 8px;
      display: block;
    }

    input {
      width: 90%;
      padding: 12px;
      font-size: 14px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 10px;
      background-color: #f9f9f9;
    }

    button {
      width: 95%;
      padding: 12px;
      background-color: #4299e1;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #3182ce;
    }

    .message {
      padding: 10px;
      margin-top: 20px;
      border-radius: 5px;
      font-weight: bold;
    }

     .message {
      text-align: center;
      margin-top: 10px;
      font-weight: bold;
    }
    .message.success {
      color: green;
    }
    .message.error {
      color: red;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Taxation Module</h2>
    <form id="tax-form" action="TaxServlet" method="post">
       <div class="form-group">
      <%
           String citizenId = (String) session.getAttribute("citizenId");
       %>
        <label for="citizen-id">Citizen Id:</label>
        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId !=null ? citizenId : "Citizen Id not found" %>">
      </div>
      
      <div class="form-group">
        <label for="bank">Bank Name:</label>
        <input type="text" id="bank" name="bank" required>
      </div>
      
      <div class="form-group">
        <label for="pay-amount">Pay Amount:</label>
        <input type="number" id="pay-amount" name="payAmount" placeholder="Enter Amount" required value="<%= 1000 + (int)(Math.random() * 9000) %>">
      </div>
      
      <button type="submit">Check Tax Status</button>
    </form>
    
    <% if (request.getAttribute("successMessage") != null) { %>
      <div class="message success">
        <%= request.getAttribute("successMessage") %>
      </div>
    <% } %>
    
    <% if (request.getAttribute("errorMessage") != null) { %>
      <div class="message error">
        <%= request.getAttribute("errorMessage") %>
      </div>
    <% } %>
    
   <% if (request.getAttribute("taxPaid") != null && request.getAttribute("taxDue") != null) { %>
  <div class="transaction-summary">
    <h3>Tax Details</h3>
    <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
    <p><strong>Amount Paid:</strong> <%= request.getAttribute("taxPaid") %></p>
    <p><strong>Amount Due:</strong> <%= request.getAttribute("taxDue") %></p>
  </div>
<% } %>

  </div>
</body>
</html>
