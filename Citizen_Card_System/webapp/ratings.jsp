<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #eef2f3;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 700px;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin: auto;
    }
    h2 {
      text-align: center;
      color: #444;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    input, textarea, select, button {
      width: 95%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button {
      background-color: #007bff;
      color: #fff;
      border: none;
      cursor: pointer;
    }
    button:hover {
      background-color: #218838;
    }
    .rating-output {
      background-color: #f8f9fa;
      padding: 10px;
      border-radius: 5px;
      margin-top: 15px;
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="container">
    <h2>Credit Rating Module</h2>
    <form action="CreditRatingServlet" method="post">
      <div class="form-group">
        <label for="name">Citizen Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter citizen's name" required>
      </div>
       <%
           String citizenId = (String) session.getAttribute("citizenId");
       %>
      <div class="form-group">
        <label for="citizen-id">Citizen Id:</label>
        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId != null ? citizenId : "Citizen Id not found" %>" readonly>

      </div>
      <div class="form-group">
        <label for="behavior">Behavior Summary:</label>
        <textarea id="behavior" name="behavior" rows="3" placeholder="Provide a summary of behavior" required></textarea>
      </div>
      <div class="form-group">
        <label for="rating">Credit Rating:</label>
        <select id="rating" name="rating" required>
          <option value="Excellent">Excellent</option>
          <option value="Good">Good</option>
          <option value="Average">Average</option>
          <option value="Poor">Poor</option>
        </select>
      </div>
      <button type="submit">Submit Rating</button>
    </form>
    
    <div class="rating-output" id="output">
      <!-- Output will appear here -->
    </div>
  </div>

</body>
</html>