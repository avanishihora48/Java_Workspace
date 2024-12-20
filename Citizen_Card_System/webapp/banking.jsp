<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking Module</title>
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
      width: 100%;
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
    .transaction-summary {
      margin-top: 20px;
      background-color: #f9f9f9;
      padding: 15px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }
    .transaction-summary h3 {
      margin-top: 0;
      color: #555;
    }
    .transaction-summary p {
      margin: 5px 0;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Banking Module</h2>
    <form action="BankTransactionServlet" method="POST">
      <div class="form-group">
        <label for="citizen-id">Citizen ID:</label>
        <input type="text" id="citizen-id" name="citizenId" placeholder="Enter Citizen ID">
      </div>
      
      <div class="form-group">
        <label for="bank">Select Bank:</label>
        <select id="bank" name="bank">
          <option value="sbi">SBI</option>
          <option value="icici">ICICI</option>
          <option value="andhra-bank">Andhra Bank</option>
        </select>
      </div>

      <div class="form-group">
        <label for="transaction-type">Transaction Type:</label>
        <select id="transaction-type" name="transactionType">
          <option value="deposit">Deposit</option>
          <option value="withdrawal">Withdrawal</option>
          <option value="transfer">Transfer</option>
        </select>
      </div>

      <div class="form-group">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter Amount">
      </div>

      <button type="submit">Complete Transaction</button>
    </form>

	<% if (request.getAttribute("error") != null) { %>
	    <div style="color: red;"><%= request.getAttribute("error") %></div>
	<% } %>
	
	<% if (request.getAttribute("success") != null) { %>
	    <div style="color: green;"><%= request.getAttribute("success") %></div>
	<% } %>

    <div class="transaction-summary">
      <h3>Transaction Summary</h3>
      <p><strong>Citizen ID:</strong> [Citizen ID]</p>
      <p><strong>Selected Bank:</strong> [Bank Name]</p>
      <p><strong>Transaction Type:</strong> [Deposit/Withdrawal/Transfer]</p>
      <p><strong>Amount:</strong> [Amount]</p>
    </div>
  </div>
</body>
</html>
