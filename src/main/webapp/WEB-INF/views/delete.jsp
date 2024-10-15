<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete Device</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #8B008B;
	margin: 0;
	padding: 0;
}

.container {
	margin-top: 50px;
}

.card {
	border-radius: 15px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title">Delete Device</h2>
						<form:form action="${pageContext.request.contextPath}/delete" method="post" modelAttribute="device">
							<div class="form-group">
								<label for="name">Name:</label>
								<form:input path="name" id="name" class="form-control"
									required="true" />
							</div>
							<button type="submit" class="btn btn-danger">Delete</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
