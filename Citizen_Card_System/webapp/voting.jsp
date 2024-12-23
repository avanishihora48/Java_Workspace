<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voting Module</title>
 <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 600px;
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
    select, input[type="radio"], input[type="text"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-top: 5px;
    }
    input[type="radio"] {
      width: auto;
      margin-right: 10px;
    }
    button {
      width: 100%;
      padding: 12px;
      background-color: #28a745;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      margin-top: 20px;
    }
    button:hover {
      background-color: #218838;
    }
    .voting-summary {
      margin-top: 20px;
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }
    .voting-summary h3 {
      margin-top: 0;
      color: #555;
    }
    .voting-summary p {
      margin: 5px 0;
    }
    .form-section {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
    }
    .form-section .form-group {
      width: 48%;
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
    <h2>Voting Module</h2>
    <form action="VoteServlet" method="post">
      <div class="form-section">
         <div class="form-group">
      <%
           String citizenId = (String) session.getAttribute("citizenId");
       %>
        <label for="citizen-id">Citizen Id:</label>
        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId !=null ? citizenId : "Citizen Id not found" %>">
      </div>

        <div class="form-group">
          <label for="area">Select Voting Area:</label>
          <select id="area" name="area">
            <option value="Rajkot">Rajkot</option>
            <option value="Ahemdabad">Ahemdabad</option>
            <option value="Vadodra">Vadodra</option>
            <option value="Surat">Surat</option>
            <option value="Junagadh">Junagadh</option>
            <option value="Mumbai">Mumbai</option>
          </select>
        </div>
      </div>

      <div class="form-group">
        <label for="candidate">Choose Your Candidate:</label><br><br>
        
        <label for="Narendra Modi(BJP)">Narendra Modi(BJP)</label>
       <input type="radio" value="Narendra Modi" name="candidate" id="candidate-1"><br>
		<label for="Rahul Gandhi(Congress)">Rahul Gandhi(Congress)</label>
		<input type="radio" value="Rahul Gandhi" name="candidate" id="candidate-2"><br>
		<label for="Arvind Kejriwal(AAP)">Arvind Kejriwal(AAP)</label>
		<input type="radio" value="Arvind Kejriwal" name="candidate" id="candidate-3"><br>
		<label for="Uddhav Thackeray (Shiv Sena)">Uddhav Thackeray (Shiv Sena)</label>
        <input type="radio" value="Uddhav Thackeray" name="candidate" id="candidate-4"><br>
		<label for="Mamata Banerjee (TMC)">Mamata Banerjee (TMC)</label>
		<input type="radio" value="Mamata Banerjee " name="candidate" id="candidate-5"><br>
		<label for="Mayawati (BSP)">Mayawati (BSP)</label>
		<input type="radio" value="Mayawati" name="candidate" id="candidate-6"><br>
		<label for="Lalu Prasad Yadav (RJD)<">Lalu Prasad Yadav (RJD)</label>
		<input type="radio" value="Lalu Prasad Yadav" name="candidate" id="candidate-7"><br>
		
      </div>

      <button type="submit">Submit Vote</button>
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
	    <%
	         if (request.getAttribute("citizenId") != null && request.getAttribute("area") != null && request.getAttribute("candidate") != null) {
	    %>
	      <div class="voting-summary">
	        <h3>Your Voting Summary</h3>
	        <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
	        <p><strong>Voting Area:</strong> <%=  request.getAttribute("area")  %></p>
	        <p><strong>Chosen Candidate:</strong> <%=  request.getAttribute("candidate")  %></p>
	      </div>
	    <% 
	      } 
	    %>
  </div>
</body>
</html>
