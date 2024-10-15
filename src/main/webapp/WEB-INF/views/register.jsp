<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="password"], input[type="email"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration</h1>
        <form:form action="Reprocess" method="post" modelAttribute="register">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" id="name" />
                <form:errors path="name" cssClass="error-message" />
            </div>
            <div class="form-group">
                <label for="pass">Password:</label>
                <form:input path="pass" id="pass" type="password" />
                <form:errors path="pass" cssClass="error-message" />
            </div>
            <div class="form-group">
                <label for="EMailId">Email:</label>
                <form:input path="EMailId" id="EMailId" type="email" /> <!-- Change 'type' to 'email' -->
                <form:errors path="EMailId" cssClass="error-message" />
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <form:input path="phone" id="phone" />
                <form:errors path="phone" cssClass="error-message" />
            </div>
            <input type="submit" value="Register">
        </form:form>
        <div style="color: red;">
            <c:if test="${not empty error}">
                <p>${error}</p>
            </c:if>
        </div>
    </div>
</body>
</html>
