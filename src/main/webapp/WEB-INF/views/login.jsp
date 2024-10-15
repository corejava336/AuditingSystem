<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        /* Same styling as the registration page */
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form:form action="process" method="post" modelAttribute="login">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" id="name" />
                <form:errors path="name" cssClass="error-message" />
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <form:input path="pass" id="password" type="password" />
                <form:errors path="pass" cssClass="error-message" />
            </div>
            <input type="submit" value="Submit">
        </form:form>
        <div style="text-align: center; margin-top: 20px;">
            <a href="register" class="register-btn">Register</a>
        </div>
        <div style="color: red;">
            <c:if test="${not empty error}">
                <p>${error}</p>
            </c:if>
        </div>
    </div>
</body>
</html>
