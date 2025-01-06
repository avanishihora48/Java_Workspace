<%@ page import="java.sql.SQLException"%>
<%@ page import="com.dao.Dao"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Telephone Management</title>
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
        Telephone Management
    </header>

    <div class="container">
        <h2>Telephone</h2>

        <table>
            <thead>
                <tr>
                    <th>Citizen ID</th>
                    <th>Call Type</th>
                    <th>Call Start Time</th>
                    <th>Call Duration</th>
                    <th>Call Rate</th>
                    <th>Call Charges</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    try 
                {
                        ResultSet rs = Dao.fetchCallDetails(); 
                        while (rs.next()) {
                            String citizenId = rs.getString("citizenId");
                            String callType = rs.getString("callType");
                            String callStartTime = rs.getString("callStartTime");
                            String callDuration = rs.getString("callDuration");
                            String callRate = rs.getString("callRate");
                            String callCharges = rs.getString("callCharges");
              
                %>

                <tr>
                    <td><%= citizenId %></td>
                    <td><%= callType %></td>
                    <td><%= callStartTime %></td>
                    <td><%= callDuration %></td>
                    <td><%= callRate %></td>
                    <td><%= callCharges %></td>
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
