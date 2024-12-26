<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Passport Information Module</title>
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
       margin-top: 60px;
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
      width: 95%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-top: 5px;
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
    .passport-summary {
      margin-top: 20px;
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }
    .passport-summary h3 {
      margin-top: 0;
      color: #555;
    }
    .passport-summary p {
      margin: 5px 0;
    }
  </style>
</head>
<body>
<jsp:include page="header.jsp"/>

  <div class="container"><button class="back-arrow" onclick="history.back()" style="width: 50px">←</button>
    <h2>Passport Information Module</h2>
    <form method="post" action="PassportServlet">
       <%
           String citizenId = (String) session.getAttribute("citizenId");
       %>
      <div class="form-group">
        <label for="citizen-id">Citizen Id:</label>
        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId != null ? citizenId : "Citizen Id not found" %>" readonly>
      </div>

      <div class="form-group">
        <label for="full-name">Full Name:</label>
        <input type="text" id="full-name" name="fullName" placeholder="Enter Full Name" required>
      </div>

      <%
           String passportNumber = (String) session.getAttribute("passportNumber");
       %>
      <div class="form-group">
        <label for="passport-number">Passport Number:</label>
        <input type="text" id="passport-number" name="passportNumber" required value="<%= passportNumber != null ? passportNumber : "Passport Number not found" %>" readonly>
      </div>

      <div class="form-group">
        <label for="date-issued">Date Issued:</label>
        <input type="date" id="date-issued" name="dateIssued" required>
      </div>
      
      <button type="submit">View Passport Information</button><br><br>
      
    </form>

<%
   String validUntil = (String) session.getAttribute("validDate");
   if (validUntil == null) {
       validUntil = "Date not available"; 
   }
%>
    <div class="passport-summary">
      <h3>Passport Information</h3>
      <p><strong>Citizen ID:</strong> <%= session.getAttribute("citizenId") != null ? session.getAttribute("citizenId") : "Not available" %></p>
      <p><strong>Full Name:</strong> <%= session.getAttribute("fullName") != null ? session.getAttribute("fullName") : "Not available" %></p>
      <p><strong>Passport Number:</strong> <%= session.getAttribute("passportNumber") != null ? session.getAttribute("passportNumber") : "Not available" %></p>
      <p><strong>Date Issued:</strong> <%= session.getAttribute("dateIssued") != null ? session.getAttribute("dateIssued") : "Not available" %></p>
      <p><strong>Valid Until:</strong> <%= session.getAttribute("validDate") != null ? session.getAttribute("validDate") : "Not available" %></p>
    </div>
    
  </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
