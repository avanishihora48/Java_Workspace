<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Light background for contrast */
        }
        .hero {
            background-color: #007bff; /* Primary color for hero section */
            color: white;
            padding: 50px 0;
            text-align: center;
        }
        .card {
            margin: 20px 0;
        }
        .footer {
            background-color: #343a40; /* Dark footer */
            color: white;
            padding: 20px 0;
            text-align: center;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="hero">
    <h1>Welcome to Our Website!</h1>
    <p>Your go-to platform for amazing services.</p>
    <a href="signup.jsp" class="btn btn-light btn-lg">Get Started</a>
</div>

<div class="container content">
    <h2 class="text-center my-4">Our Services</h2>
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Service 1</h5>
                    <p class="card-text">Description of Service 1. Offering great value and quality.</p>
                    <a href="#" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Service 2</h5>
                    <p class="card-text">Description of Service 2. Tailored to meet your needs.</p>
                    <a href="#" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Service 3</h5>
                    <p class="card-text">Description of Service 3. Ensuring customer satisfaction.</p>
                    <a href="#" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
    </div>

    <h2 class="text-center my-4">Contact Us</h2>
    <form>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="Enter your name" required>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="message">Message</label>
            <textarea class="form-control" id="message" rows="3" placeholder="Your message" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<div class="footer">
    <p>&copy; 2024 Your Company. All rights reserved.</p>
</div>

</body>
</html>
