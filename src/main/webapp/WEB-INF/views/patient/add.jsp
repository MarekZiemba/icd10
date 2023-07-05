<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add patient</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container">
            <h3>Add new Patient to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="patient">
                <div><p>First Name:</p> <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
                <div><p>Last Name:</p> <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
                <div><p>Date Of Birth:</p> <form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"/></div>
                <div><p>PESEL:</p> <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
                <div><p>Insurance:</p> <form:input path="insurance"/><form:errors path="insurance" cssClass="error"/></div>
                <div><p>Diagnoses (ICD 10):</p>
                    <form:select path="diagnoses" items="${diagnoses}" itemLabel="name" itemValue="id" multiple="true"/>
                    <form:errors path="diagnoses" cssClass="error"/>
                </div>
                <div><p>Specialists:</p>
                    <form:select path="specialists" items="${specialists}" itemLabel="fullName" itemValue="id" multiple="true"/>
                    <form:errors path="specialists" cssClass="error"/>
                </div>
                <input type="submit" value="Add patient" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/user/patient/add'/>" class="button">Add new patient</a>
            <a href="<c:url value='/user/patient/search'/>" class="button">Search in patients</a>
            <a href="<c:url value='/user/patient/list'/>" class="button">Patients List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
