<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Device Management</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.option-btn {
	display: block;
	width: 100%;
	padding: 15px;
	margin: 10px 0;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.option-btn:hover {
	background-color: #e0e0e0;
}

@media ( max-width : 600px) {
	.container {
		margin: 20px;
	}
}
</style>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center;">Device Management</h2>
		<button class="option-btn"
			onclick="location.href='/Spring_Project_03/search'">Search
			Devices</button>
		<button class="option-btn"
			onclick="location.href='/Spring_Project_03/insert'">Create
			Device</button>
		<button class="option-btn"
			onclick="location.href='/Spring_Project_03/delete'">Delete
			Device</button>
		<button class="option-btn"
			onclick="location.href='/Spring_Project_03/update'">Update
			Device</button>
	</div>
</body>
</html>
