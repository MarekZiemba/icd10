<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Login form</title>
<%--    <link rel="stylesheet" type="text/css" href="/css/style.css">--%>
</head>
<body>
    <div class="sub-container">
        <p>Login form</p>
        <sec:authorize access="${param.error == 'disabled'}">
            <p>${errorMessage}</p>
        </sec:authorize>
        <form method="post" action="login">
            Username: <label>
            <input type="text" name="username" placeholder="Enter username">
        </label>
            Password: <label>
            <input type="password" name="password" placeholder="Enter password">
        </label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <sec:csrfInput/>
            <input type="submit" value="Zaloguj" class="button">
        </form>
        <a href="<c:url value='/register'/>" class="button">Register</a>
    </div>
</body>
</html>
