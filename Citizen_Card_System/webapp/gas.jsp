<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gas Module</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            margin: auto;
            margin-top: 40px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input:focus, select:focus {
            border-color: #007bff;
            outline: none;
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
            background-color: #0056b3;
        }

        .message {
            margin-top: 20px;
            padding: 10px;
            border-radius: 5px;
        }

        .success {
            background-color: #d4edda;
            color: #155724;
        }

        .error {
            background-color: #f8d7da;
            color: #721c24;
        }

        .transaction-summary {
            margin-top: 30px;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }

        .transaction-summary h3 {
            margin-top: 0;
            color: #555;
        }

        .transaction-summary p {
            margin: 10px 0;
            font-size: 16px;
        }

        .transaction-summary strong {
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Gas Module</h2>
        <form action="GasServlet" method="post">
            <div class="form-group">
                <label for="citizen-id">Citizen Id:</label>
                <input type="text" id="citizen-id" name="citizenId" placeholder="Enter Citizen Id Number" required>
            </div>
            <div class="form-group">
                <label for="bank">Bank Name:</label>
                <input type="text" id="bank" name="bank" required>
            </div>
            <div class="form-group">
                <label for="gas-no">Gas Number:</label>
                <input type="text" id="gas-no" name="gasNumber" readonly value="${gasNumber}">
            </div>

            <div class="form-group">
                <label for="gas-type">Gas Type:</label>
                <select id="gas-type" name="gasType" required>
                    <option value="" disabled selected>Select Gas Type</option>
                    <option value="LPG">LPG</option>
                    <option value="PNG">PNG</option>
                    <option value="CNG">CNG</option>
                    <option value="Natural Gas">Natural Gas</option>
                </select>
            </div>
            <div class="form-group">
                <label for="gasAmount">Gas Amount:</label>
                <input type="text" id="gasAmount" name="gasAmount" required value="<%= 1000 + (int)(Math.random() * 9000) %>">
            </div>
            <button type="submit">Check Delivery Status</button>
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

        <% if (request.getAttribute("gasAmount") != null ) { %>
            <div class="transaction-summary">
                <h3>Tax Details</h3>
                <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
                <p><strong>Gas Number:</strong> <%= request.getAttribute("gasNumber") %></p>
                <p><strong>Gas Type:</strong> <%= request.getAttribute("gasType") %></p>
                <p><strong>Gas Amount:</strong> <%= request.getAttribute("gasAmount") %></p>
            </div>
        <% } %>
    </div>
</body>
</html>