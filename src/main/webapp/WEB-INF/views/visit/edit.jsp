<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update visit</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Update existing Visit Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="visit">
                <div class="form-group">
                    <label for="dateOfVisit"><p>Date Of Visit:</p></label>
                    <form:input path="dateOfVisit" id="dateOfVisit"/>
                    <form:errors path="dateOfVisit" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="timeOfVisit"><p>Time Of Visit:</p></label>
                    <form:input path="timeOfVisit" id="timeOfVisit"/>
                    <form:errors path="timeOfVisit" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="patient.id"><p>Patient:</p></label>
                    <form:select path="patient.id" items="${patients}" itemLabel="fullName" itemValue="id"/>
                    <form:errors path="patient" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="treatment.id"><p>Treatment:</p></label>
                    <form:select path="treatment.id" items="${treatments}" itemLabel="name" itemValue="id"/>
                    <form:errors path="treatment" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="specialist.id"><p>Specialist:</p></label>
                    <form:select path="specialist.id" items="${specialists}" itemLabel="fullName" itemValue="id"/>
                    <form:errors path="specialist" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="description"><p>Description:</p></label>
                    <form:textarea path="description" id="description" rows="4" cols="50"/>
                    <form:errors path="description" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update visit" class="button" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/visit/add'/>" class="button">Add new visit</a>
            <a href="<c:url value='/visit/search'/>" class="button">Search visit</a>
            <a href="<c:url value='/visit/list'/>" class="button">List of all visits</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
