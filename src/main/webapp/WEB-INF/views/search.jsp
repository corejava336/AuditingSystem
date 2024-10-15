<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search Device</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #FFE4E1;
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

.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title">Search Device</h2>
						<form:form action="${pageContext.request.contextPath}/search"
							method="post" modelAttribute="device">
							<div class="form-group">
								<label for="name">Name:</label>
								<form:input path="name" id="name" class="form-control"
									required="true" />
								<!-- Display validation errors -->
								<form:errors path="name" cssClass="error" />
							</div>
							<button type="submit" class="btn btn-primary">Search</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
