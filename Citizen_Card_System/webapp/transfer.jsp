<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Transfer</title>
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
    @media (max-width: 600px) {
        .container {
            padding: 10px;
        }
        input, select, button {
            font-size: 14px;
        }
    }
</style>
<script>
    document.querySelector("form").addEventListener("submit", function (e) {
        const amount = document.getElementById("transfer-amount").value;
        if (amount <= 0) {
            alert("Amount must be greater than zero.");
            e.preventDefault();
        }
    });
</script>
</head>
<body>
 <div class="container"><button class="back-arrow" onclick="history.back()" style="width: 50px">←</button>
    <h2>Bank Transfer</h2>
    <form action="BankTransactionServlet" method="POST">
    
      <div class="form-group">
        <label for="sender-citizen-id">Sender Citizen ID:</label>
        <input type="text" id="sender-citizen-id" name="citizenId" value="${citizenId}" readonly>
      </div>

      <div class="form-group">
        <label for="sender-bank">Sender Bank:</label>
        <input type="hidden" name="bank" value="${bank}">
        <select id="sender-bank" name="bank" disabled>
          <option value="sbi" ${bank == 'sbi' ? 'selected' : ''}>SBI</option>
          <option value="icici" ${bank == 'icici' ? 'selected' : ''}>ICICI</option>
          <option value="andhra-bank" ${bank == 'andhra-bank' ? 'selected' : ''}>Andhra Bank</option>
        </select>
      </div>

      <div class="form-group">
        <label for="recipient-citizen-id">Recipient Citizen ID:</label>
        <input type="text" id="recipient-citizen-id" name="recipientCitizenId" placeholder="Enter Recipient Citizen ID" required>
      </div>

      <div class="form-group">
        <label for="recipient-bank">Recipient Bank:</label>
        <select id="recipient-bank" name="recipientBank" required>
          <option value="sbi">SBI</option>
          <option value="icici">ICICI</option>
          <option value="andhra-bank">Andhra Bank</option>
        </select>
      </div>

      <div class="form-group">
        <label for="transfer-amount">Amount:</label>
        <input type="number" id="transfer-amount" name="amount" placeholder="Enter Transfer Amount" required>
      </div>

      <button type="submit">Complete Transfer</button>
    </form>
</div>
</body>
</html>
