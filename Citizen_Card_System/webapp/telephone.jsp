<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Telephone Bill Payment Module</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 20px;
    }
    .container {
     max-width: 650px !important;
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
<jsp:include page="header.jsp"/>
  <div class="container">
    <h2>Telephone Bill Payment Module</h2>
    <form action="TelephoneServlet" method="post">
       <div class="form-group">
		      <%
		           String citizenId = (String) session.getAttribute("citizenId");
		      %>
	        <label for="citizen-id">Citizen Id:</label>
	        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId !=null ? citizenId : "Citizen Id not found" %>">
       </div>

      <div class="form-group">
        <label for="call-type">Select Call Type:</label>
        <select id="call-type" name="callType">
          <option value="std">STD Calls</option>
          <option value="isd">ISD Calls</option>
        </select>
      </div>

	<% 
	    
	    LocalTime callStartTime = LocalTime.now();
	    String formattedCallStartTime = callStartTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	
	    int defaultRatePerMin = 2;
	%>

     <div class="form-group">
     <label for="callStartTime">Call Start Time:</label>
        <input type="time" id="callStartTime" name="callStartTime" required value="<%= formattedCallStartTime %>">

      </div>
      
      <div class="form-group">
        <label for="call-duration">Enter Call Duration (in minutes):</label>
        <input type="number" id="call-duration" name="callDuration" required  placeholder="Enter Rate Per Minute"  value="<%= request.getAttribute("callDuration") != null ? request.getAttribute("callDuration") : ""  %>">
      </div>

      <div class="form-group">
        <label for="call-rate">Enter Rate Per Minute:</label>
        <input type="number" id="call-rate" name="callRate" value="<%= defaultRatePerMin %>">
      </div>

	<button type="submit" name="calculate">Calculate Bill</button><br><br>
	
	<div class="form-group">
	    <label for="call-charges">Calculated Call Charges:</label>
	    <input type="number" id="call-charges" name="callCharges" readonly
	        value="<%= request.getAttribute("callCharges") != null ? request.getAttribute("callCharges") : "" %>">
	 </div>
	 
	 <button type="submit" name="pay">Pay Bill</button>
    </form>

      
	
       <% if (request.getAttribute("successMessage") != null) 
       { 
       %>
            <div class="message success">
                <%= request.getAttribute("successMessage") %>
            </div>
        <% } %>
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="message error">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% 
        } 
        %>

<% if (request.getAttribute("callCharges") != null) 
{ 
%>
    <div class="bill-summary">
        <h3>Bill Summary</h3>
        <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
        <p><strong>Call Type:</strong> <%= request.getAttribute("callType") %></p>
        <p><strong>Call Duration:</strong> <%= request.getAttribute("callDuration") %> minutes</p>
        <p><strong>Rate Per Minute:</strong> <%= request.getAttribute("callRate") %></p>
        <p><strong>Total Bill:</strong> <%= request.getAttribute("callCharges") %></p>
    </div>
<% 
} 
%>

  </div>
<jsp:include page="footer.jsp"/>
</body> 
</html>