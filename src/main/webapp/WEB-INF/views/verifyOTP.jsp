<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify OTP</title>
</head>
<body>
	<h1>Verify OTP</h1>
	<form action="verifyOTP" method="post">
		<label for="otp">Enter OTP:</label> <input type="text" id="otp"
			name="otp" required> <input type="hidden" name="EMailId"
			value="${param.EMailId}"> <input type="submit" value="Verify">
	</form>

</body>
</html>
