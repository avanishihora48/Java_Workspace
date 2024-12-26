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
<script>
  function validateAmount(input) {
    if (input.value <= 0) {
      alert("Amount must be greater than zero.");
      input.value = "";
    }
  }

  document.querySelector('select[name="transactionType"]').addEventListener('change', function () {
      document.getElementById('transferDetails').style.display = this.value === 'transfer' ? 'block' : 'none';
  });
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
  <div class="container">
    <h2>Banking Module</h2>
   
    <form action="BankTransactionServlet" method="POST" accept-charset="UTF-8">
      <div class="form-group">
        <label for="citizen-id">Citizen ID:</label>
        <input type="text" id="citizen-id" name="citizenId" placeholder="Enter Citizen ID" required>
      </div>
      
      <div class="form-group">
        <label for="bank">Select Bank:</label>
        <select id="bank" name="bank" required>
          <% 
            String[] banks = {"SBI", "ICICI", "Andhra Bank"};
            for (String bank : banks) {
          %>
          <option value="<%= bank.toLowerCase() %>"><%= bank %></option>
          <% } %>
        </select>
      </div>

      <div class="form-group">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter Amount" oninput="validateAmount(this)" required>
      </div>

      <button type="submit" name="transactionType" value="deposit">Deposit</button><br><br>
      <button type="submit" name="transactionType" value="withdrawal">Withdraw</button>
    </form>
    <br><br>
    <h2>Transfer Funds</h2>
    <form action="BankTransactionServlet" method="POST" accept-charset="UTF-8">
      <div class="form-group">
        <label for="sender-id">Sender Citizen ID:</label>
        <input type="text" id="sender-id" name="citizenId" placeholder="Enter Sender Citizen ID" required>
      </div>
      
      <div class="form-group">
        <label for="sender-bank">Sender Bank:</label>
        <select id="sender-bank" name="bank" required>
          <% 
            for (String bank : banks) {
          %>
          <option value="<%= bank.toLowerCase() %>"><%= bank %></option>
          <% } %>
        </select>
      </div>

      <div class="form-group">
        <label for="recipient-id">Recipient Citizen ID:</label>
        <input type="text" id="recipient-id" name="recipientCitizenId" placeholder="Enter Recipient Citizen ID" required>
      </div>

      <div class="form-group">
        <label for="recipient-bank">Recipient Bank:</label>
        <select id="recipient-bank" name="recipientBank" required>
          <% 
            for (String bank : banks) {
          %>
          <option value="<%= bank.toLowerCase() %>"><%= bank %></option>
          <% } %>
        </select>
      </div>

      <div class="form-group">
        <label for="transfer-amount">Amount:</label>
        <input type="number" id="transfer-amount" name="amount" placeholder="Enter Transfer Amount" oninput="validateAmount(this)" required>
      </div>

      <button type="submit" name="transactionType" value="transfer">Transfer</button>
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
    
    <% if (request.getAttribute("transactionType") != null) 
    { 
    %>
      <div class="transaction-summary">
        <h3>Transaction Details</h3>
        <p><strong>Transaction Type:</strong> <%= request.getAttribute("transactionType") %></p>
        <p><strong>Citizen ID:</strong> <%= request.getAttribute("citizenId") %></p>
        <p><strong>Bank:</strong> <%= request.getAttribute("bank") %></p>
        <p><strong>Amount:</strong> <%= request.getAttribute("amount") %></p>
      </div>
    <% 
    } 
    %>
  </div>
 <jsp:include page="footer.jsp"/>
</body>
</html>
