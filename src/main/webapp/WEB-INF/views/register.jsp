<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Login form</title>
<%--        <link rel="stylesheet" type="text/css" href="/css/style.css">--%>
</head>
<body>
<div class="sub-container">
    <p>Registration form</p>
<form:form method="post" action="/register" modelAttribute="user">
    <label for="username">Username:</label>
    <form:input type="text" path="username" id="username" placeholder="Enter username"/>
    <form:errors path="username" cssClass="error"/>

    <label for="password">Password:</label>
    <form:input type="password" path="password" id="password" placeholder="Enter password"/>
    <form:errors path="password" cssClass="error"/>

    <label for="confirmPassword">Confirm Password:</label>
    <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Confirm password"/>
    <form:errors path="confirmPassword" cssClass="error"/>

<%--        Confirm Password: <input type="password" name="matchingPassword" placeholder="Confirm password">--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--        <sec:csrfInput/>--%>
    <input type="submit" value="Zarejestruj" class="button">
</form:form>
</div>
</body>
</html>
