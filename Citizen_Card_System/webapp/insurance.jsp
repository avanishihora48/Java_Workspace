<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insurance Module</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin: auto;
        }
        h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .message {
            font-weight: bold;
            margin-top: 15px;
        }
        .success {
            color: green;
        }
        .error {
            color: red;
        }
        .details {
            margin-top: 20px;
            background: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Insurance Policy Form</h2>

        <!-- Form -->
        <form action="InsuranceServlet" method="post">
        <div class="form-group">
		      <%
		           String citizenId = (String) session.getAttribute("citizenId");
		      %>
	        <label for="citizen-id">Citizen Id:</label>
	        <input type="text" id="citizen-id" name="citizenId" value="<%= citizenId !=null ? citizenId : "Citizen Id not found" %>">
       </div>
            <div class="form-group">
                <label for="insuredAmount">Insured Amount:</label>
                <input type="number" id="insuredAmount" name="insuredAmount" placeholder="Enter insured amount (must be 2000 or more)"
                    value="<%= request.getAttribute("insuredAmount") != null ? request.getAttribute("insuredAmount") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="installments">Installments:</label>
                <select id="installments" name="installments" required>
                    <option value="Monthly" <%= "Monthly".equals(request.getAttribute("installments")) ? "selected" : "" %>>Monthly</option>
                    <option value="Quarterly" <%= "Quarterly".equals(request.getAttribute("installments")) ? "selected" : "" %>>Quarterly</option>
                    <option value="Yearly" <%= "Yearly".equals(request.getAttribute("installments")) ? "selected" : "" %>>Yearly</option>
                </select>
            </div>
            <button type="submit">Submit Policy</button>
        </form>

        <%
            if (request.getAttribute("error") != null) {
        %>
            <p class="message error"><%= request.getAttribute("error") %></p>
        <%
            } else if (request.getAttribute("success") != null) {
        %>
            <p class="message success"><%= request.getAttribute("success") %></p>
            <div class="details">
                <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
                <p><strong>Policy Name:</strong> <%= request.getAttribute("policyName") %></p>
                <p><strong>Insured Amount:</strong> ₹<%= request.getAttribute("insuredAmount") %></p>
                <p><strong>Premium Amount:</strong> ₹<%= request.getAttribute("premiumAmount") %></p>
                <p><strong>Installment Plan:</strong> <%= request.getAttribute("installments") %></p>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
