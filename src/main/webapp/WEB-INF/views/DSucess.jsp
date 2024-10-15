<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Device Successfully Found</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0; /* Light gray background */
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #FFF8DC; /* White background */
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Shadow effect */
}

h1 {
	color: #333333; /* Dark text color */
}

p {
	color: #666666; /* Medium text color */
}
</style>
</head>
<body>
	<div class="container">
		<h1>Device Name: ${device.name}</h1>
		<h1>Device Count: ${device.count}</h1>
		<%-- Display message if available --%>
		<c:if test="${not empty message}">
			<h1>Message: ${message}</h1>
		</c:if>

	</div>
</body>
</html>
