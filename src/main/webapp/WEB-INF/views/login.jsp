<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="pl">
<head>
    <title>Login form</title>
<%--    <link rel="stylesheet" type="text/css" href="/css/style.css">--%>
</head>
<body>
    <div class="sub-container">
        <p>Login form</p>
        <form method="post">
            Username: <input type="text" name="username">
            Password: <input type="password" name="password">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
            <sec:csrfInput/>
            <input type="submit" value="Zaloguj" class="button">
        </form>
    </div>
</body>
</html>