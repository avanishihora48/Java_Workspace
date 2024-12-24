<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Electricity Bill Payment Module</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 800px;
      background-color: #ffffff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin: auto;
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
    input, select {
      width: 95%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-top: 5px;
    }
    button {
      width: 98%;
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
    .bill-summary {
      margin-top: 20px;
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }
    .bill-summary h3 {
      margin-top: 0;
      color: #555;
    }
    .bill-summary p {
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
  <div class="container">
    <h2>Electricity Bill Payment Module</h2>
    <form method="post" action="ElectricityServlet">
     <div class="form-group">
      <%
           String citizenId = (String) session.getAttribute("citizenId");
       %>
        <label for="citizen-id">Citizen Id:</label>
        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId !=null ? citizenId : "Citizen Id not found" %>">
      </div>

      <div class="form-group">
        <label for="previous-units">Previous Units:</label>
        <input type="number" id="previous-units" name="previousUnits" placeholder="Enter Previous Units" required>
      </div>

      <div class="form-group">
        <label for="current-units">Current Units:</label>
        <input type="number" id="current-units" name="currentUnits" placeholder="Enter Current Units" required>
      </div>

     <%
          int ratePerUnit = 5;
          
      %>
      <div class="form-group">
        <label for="rate-per-unit">Rate Per Unit:</label>
        <input type="number" id="rate-per-unit" name="ratePerUnit" value="<%= ratePerUnit %>" readonly>
      </div>

      <button type="submit" name="calculate">Calculate Bill</button><br><br>
      
 
      <div class="form-group">
        <label for="call-charges">Calculated Charges:</label>
        <input type="number" id="call-charges" name="totalCharges" value="<%= request.getAttribute("totalCharges") != null ? request.getAttribute("totalCharges") : "" %>" readonly>
      </div>

      <% if(request.getAttribute("totalCharges") != null) 
    { 
      %>
        <button type="submit" name="pay">Pay Bill</button>
      <% 
    } 
      %>

    </form>

    <% if (request.getAttribute("successMessage") != null) 
   { 
    %>
      <div class="message success">
          <%= request.getAttribute("successMessage") %>
      </div>
    <% 
   } 
    %>

    <% if (request.getAttribute("errorMessage") != null) 
   { 
    %>
      <div class="message error">
          <%= request.getAttribute("errorMessage") %>
      </div>
    <% 
   } 
    %>

    <div class="bill-summary">
      <h3>Bill Summary</h3>
      <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId")%></p>
      <p><strong>Previous Units:</strong> <%= request.getAttribute("previousUnits") %></p>
      <p><strong>Current Units:</strong> <%= request.getAttribute("currentUnits") %></p>
      <p><strong>Rate Per Unit:</strong> <%= request.getAttribute("ratePerUnit") %></p>
      <p><strong>Total Bill:</strong> <%= request.getAttribute("totalCharges") %></p>
    </div>
  </div>
</body>
</html>