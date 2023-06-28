<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <title>ICD10</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    <h1>ICD10</h1>
        <div class="sub-container">
            For specialist:
            <a href="<c:url value='/patient/list'/>" class="button">Patients</a>
            <a href="<c:url value='/specialist/list'/>" class="button">Specialists</a>
            <a href="<c:url value='/treatment/list'/>" class="button">Treatments</a>
            <a href="<c:url value='/visit/list'/>" class="button">Visits</a>
        </div>
        <div class="sub-container">
            For administrator:
            <a href="<c:url value='/category/list'/>" class="button-admin">Categories</a>
            <a href="<c:url value='/specialization/list'/>" class="button-admin">Specializations</a>
            <a href="<c:url value='/role/list'/>" class="button-admin">Roles</a>
        </div>
        <form action="/logout" method="post">
            <sec:csrfInput/>
            <input type="submit" value="Logout" class="button" id="red-logout"/>
        </form>
    </div>
</body>
</html>