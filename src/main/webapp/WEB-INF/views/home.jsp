<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>ICD10 F</title>
<%--    <link rel="stylesheet" type="text/css" href="/css/style.css">--%>
</head>
<body>
    <div class="container">
        <h1>Welcome to ICD10!</h1>
        <div class="sub-container">
            <p><a href="<c:url value='/main'/>" class="button">Login</a></p>
        </div>
        <div class="sub-container">
            <p><a href="<c:url value='/register'/>" class="button">Register</a></p>
        </div>
    </div>
</body>
</html>