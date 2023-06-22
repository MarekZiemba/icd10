<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1>Welcome to ICD10!</h1>

<p><a href="<c:url value='/hello'/>">Click to see a greeting.</a></p>
</body>
</html>