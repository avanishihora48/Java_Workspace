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
    background-color: #f4f4f9;
    margin: 0;
    padding: 20px;
  }

.container {
    max-width: 500px !important;  /* Reduced width */
    background: #fff;
    padding: 15px;     /* Reduced padding */
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    margin: auto;
    margin-top: 20px;  /* Adjust top margin to avoid header overlap */
    margin-bottom: 100px !important;
}

h2 {
    text-align: center;
    font-size: 18px;   /* Reduce font size for h2 */
}

.form-group {
    margin-bottom: 12px;  /* Reduced margin */
}

label {
    display: block;
    font-weight: bold;
    font-size: 14px;   /* Reduced font size for label */
}

input, select, button {
    width: 100%;
    padding: 8px;      /* Reduced padding */
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;    /* Reduced font size for inputs */
}

 button {
    width: 100%;
     padding: 12px;
     background-color: #007bff;
     color: #fff;
     border: none;
     border-radius: 5px;
     cursor: pointer;
     font-size: 18px;
     margin-top: 10px;
}

button:hover {
    background-color: #218838;
}

.message {
    font-weight: bold;
    margin-top: 15px;
    padding: 10px;
    text-align: center;
    font-size: 14px;   /* Reduced font size */
}

.message.success {
    color: green;
}

.message.error {
    color: red;
}

.transaction-summary {
    margin-top: 15px;
    background: #f9f9f9;
    padding: 12px;     /* Reduced padding */
    border-radius: 5px;
    font-size: 14px;    /* Reduced font size */
}

body, html {
    margin: 0;
    padding: 0;
}

header, footer {
    width: 100%;
    background-color: #fff;
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
    
body, html {
	  margin: 0;
	  padding: 0;
}

header, footer {
  width: 100%;
  background-color: #fff; 
}

 
  </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<br>
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
<jsp:include page="footer.jsp"/>
</body>
</html>
