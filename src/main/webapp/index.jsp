<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #FFE4E1; /* Light pink background */
}

.container {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #DB7093; /* Pink background */
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Shadow effect */
	overflow: hidden;
	border: 5px solid black; /* Light peach border */
	/* Clearfix */
}

.header, .footer {
	background-color: #DB7093; /* Pink background */
	color: #fff; /* White text color */
	padding: 10px;
	text-align: center;
	border-radius: 10px;
	margin-bottom: 20px; /* Spacing between sections */
	border: 2px solid #FFDAB9; /* Light peach border */
}

.content {
	text-align: center;
}

.button-container {
	text-align: center;
	margin-top: 20px;
}

.button-container a {
	display: inline-block;
	padding: 15px 30px;
	background-color: #20B2AA; /* Light sea green background */
	color: #fff; /* White text color */
	text-decoration: none; /* Remove underline */
	border-radius: 5px; /* Rounded corners */
	margin-right: 10px;
	transition: background-color 0.3s ease; /* Smooth color transition */
}

.button-container a:last-child {
	margin-right: 0; /* Remove margin from the last button */
}

.button-container a:hover {
	background-color: #008B8B; /* Darker sea green color on hover */
}

.footer {
	background-color: #20B2AA; /* Light sea green background for footer */
	border: 2px solid #FFDAB9; /* Light peach border */
	margin-top: 20px; /* Space between buttons and footer */
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Welcome to GMS Team</h1>
		</div>
		<div class="content">
			<div class="welcome">
				<p>Welcome to the GMS Team's Home Page!</p>
				<!-- Add any additional content here -->
			</div>
		</div>
		<div class="button-container">
			<a href="login">Login</a> <a href="register">Register</a>
		</div>
		<div class="footer">
			<p>© 2024 GMS Team. All rights reserved.</p>
		</div>
	</div>
</body>
</html>
