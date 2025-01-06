<%@ page import="java.sql.SQLException"%>
<%@ page import="com.dao.Dao"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voting Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            margin: auto;
            max-width: 1200px;
        }
        header {
            background-color: #333;
            color: white;
            padding: 15px 0;
            text-align: center;
            font-size: 24px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #333;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <header>
        Voting Management
    </header>

    <div class="container">
        <h2>Voting</h2>

        <table>
            <thead>
                <tr>
                    <th>Citizen ID</th>
                    <th>Bank</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Transaction Date</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    try 
                {
                        ResultSet rs = Dao.fetchBankDetails(); 
                        while (rs.next()) {
                            String citizenId = rs.getString("citizenId");
                            String bank = rs.getString("bank");
                            String transactionType = rs.getString("transactionType");
                            String amount = rs.getString("amount");
                            String transaction_date = rs.getString("transaction_date");
              
                %>

                <tr>
                    <td><%= citizenId %></td>
                    <td><%= bank %></td>
                    <td><%= transactionType %></td>
                    <td><%= amount %></td>
                    <td><%= transaction_date %></td>
                </tr>

                <% 
                     }
                    } 
                     catch (SQLException e)
                    {
                        out.println("<p>Error retrieving insurance details. Please try again later.</p>");
                        e.printStackTrace();  
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- FontAwesome icons -->
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
