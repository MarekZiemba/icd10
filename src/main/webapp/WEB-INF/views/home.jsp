<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <title>Spring Security Example</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to ICD10!</h1>
        <div class="sub-container">
            <p><a href="<c:url value='/hello'/>" class="button">Click to start.</a></p>
        </div>
    </div>
</body>
</html>