<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add specialist</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Add new Specialist to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="specialist">
                <div><p>First Name:</p> <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
                <div><p>Last Name:</p> <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
                <div><p>Date Of Birth:</p> <form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"/></div>
                <div><p>PESEL:</p> <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
                <div><p>Specialization:</p> <form:select path="specialization.id" items="${specializations}" itemLabel="name" itemValue="id"/><form:errors
                        path="specialization" cssClass="error"/></div>
                <input type="submit" value="Add specialist" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/specialist/add'/>" class="button">Add new specialist</a>
            <a href="<c:url value='/specialist/search'/>" class="button">Search specialist</a>
            <a href="<c:url value='/specialist/list'/>" class="button">List of all specialists</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
