<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RTO Module</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f4f8;
      margin: 0;
      padding: 20px;
    }
    .container {
     max-width: 500px !important;
     background-color: #ffffff;
     padding: 30px;
     border-radius: 8px;
     box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
     margin: auto;
     margin-top: 40px;
     margin-bottom: 100px !important;
    }
    h2 {
      text-align: center;
      color: #333;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      font-weight: bold;
      display: block;
      margin-bottom: 5px;
    }
    input {
      width: 90%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }
    button:hover {
      background-color: #0056b3;
    }
    .vehicle-details {
      margin-top: 20px;
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }
    .vehicle-details h3 {
      margin-top: 0;
      color: #555;
    }
    .vehicle-details p {
      margin: 5px 0;
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
<jsp:include page="header.jsp"/>
  <div class="container">
    <h2>RTO Module</h2>
    <form action="RtoServlet" method="post">
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
       <%
           String vehicleRegistrationNo = (String) session.getAttribute("vehicleRegistrationNo");
       %>
      <div class="form-group">
        <label for="reg-number">Vehicle Registration Number:</label>
        <input type="text" id="reg-number" name="vehicleRegistrationNo"  value="<%= vehicleRegistrationNo != null ? vehicleRegistrationNo : "Registration Number Not Found" %>">
      </div>
       <%
           String engineNumber = (String) session.getAttribute("engineNumber");
       %>
      <div class="form-group">
        <label for="engine-number">Engine Number:</label>
        <input type="text" id="engine-number" name="engineNumber" value="<%= engineNumber!=null ? engineNumber : "Engine Number not found"%>">
      </div>
      <div class="form-group">
        <label for="pay-amount">Pay Amount:</label>
        <input type="text" id="pay-amount" name="payAmount" value="<%= 1000 + (int)(Math.random() * 9000) %>">
      </div>
      <button type="submit" >Proceed to Payment</button>
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

        <% if (request.getAttribute("payAmount") != null ) { %>
            <div class="transaction-summary">
                <h3>RTO Details</h3>
                <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
                <p><strong>Vehicle Registration Number:</strong> <%= request.getAttribute("vehicleRegistrationNo") %></p>
                <p><strong>Engine Number:</strong> <%= request.getAttribute("engineNumber") %></p>
                <p><strong>Rto Amount:</strong> <%= request.getAttribute("payAmount") %></p>
            </div>
        <% } %>
    </div>
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
