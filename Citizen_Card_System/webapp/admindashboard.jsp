<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator Dashboard</title>
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
        .dashboard {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
        }
        .dashboard-item {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .dashboard-item:hover {
            background-color: #007bff;
            color: white;
            transform: translateY(-5px);
        }
        .dashboard-item i {
            font-size: 40px;
            margin-bottom: 10px;
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
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        @media (max-width: 768px) {
            .dashboard {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
    <header>
        Administrator Dashboard
    </header>
    <div class="container">
        <div class="dashboard">
            <div class="dashboard-item" onclick="window.location.href='insurance1.jsp';">
                <i class="fas fa-heartbeat"></i>
                <h3>Insurance</h3>
                <p>Manage insurance services and details.</p>
            </div>
            
            <div class="dashboard-item" onclick="window.location.href='taxation1.jsp';">
                <i class="fas fa-file-invoice-dollar"></i>
                <h3>Taxation</h3>
                <p>View and manage taxation details.</p>
            </div>

            <div class="dashboard-item" onclick="window.location.href='gas1.jsp';">
                <i class="fas fa-gas-pump"></i>
                <h3>Gas</h3>
                <p>View and manage gas delivery details.</p>
            </div>

            <div class="dashboard-item" onclick="window.location.href='rto1.jsp';">
                <i class="fas fa-car"></i>
                <h3>RTO</h3>
                <p>Manage RTO services and records.</p>
            </div>

            <div class="dashboard-item" onclick="window.location.href='voting1.jsp';">
                <i class="fas fa-vote-yea"></i>
                <h3>Voting</h3>
                <p>Access and manage voting services.</p>
            </div>
            
            <div class="dashboard-item" onclick="window.location.href='banking1.jsp';">
                <i class="fas fa-piggy-bank"></i>
                <h3>Banking</h3>
                <p>Manage banking transactions and records.</p>
            </div>
            
            <div class="dashboard-item" onclick="window.location.href='telephone1.jsp';">
                <i class="fas fa-phone"></i>
                <h3>Telephone</h3>
                <p>Manage telephone service details.</p>
            </div>

            <div class="dashboard-item" onclick="window.location.href='electricity1.jsp';">
                <i class="fas fa-bolt"></i>
                <h3>Electricity</h3>
                <p>Manage electricity services and payments.</p>
            </div>
            
            <div class="dashboard-item" onclick="window.location.href='passport1.jsp';">
                <i class="fas fa-passport"></i>
                <h3>Passport</h3>
                <p>View and manage passport information.</p>
            </div>
        </div>
    </div>

    <!-- FontAwesome icons -->
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
