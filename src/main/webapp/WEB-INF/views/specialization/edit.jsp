<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update specialization</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container-2">
        <div class="sub-container" id="title-container">
            <h3>Update existing Specialization Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="specialization">
                <div><p>Name:</p> <form:input path="name"/><form:errors path="name" cssClass="error"/></div>
                <input type="submit" value="Update specialization" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container">
            <a href="<c:url value='/hello'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/specialization/add'/>" class="button">Add new specialization</a>
            <a href="<c:url value='/specialization/search'/>" class="button">Search specialization</a>
            <a href="<c:url value='/specialization/list'/>" class="button">List of all specializations</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>