<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add patient</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container-top-small">
        <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
    </div>
        <div class="sub-container" id="title-container">
            <h3>Add new Patient to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="patient">
                <div><p>First Name:</p> <form:input path="firstName" placeholder="Enter First Name" title="Enter first name"/><form:errors path="firstName" cssClass="error"/></div>
                <div><p>Last Name:</p> <form:input path="lastName" placeholder="Enter Last Name" title="Enter last name"/><form:errors path="lastName" cssClass="error"/></div>
                <div><p>Date Of Birth:</p> <form:input path="dateOfBirth" placeholder="[yyyy-MM-dd]" pattern="\d{4}-\d{2}-\d{2}" title="Please enter a date in the format yyyy-MM-DD"/><form:errors path="dateOfBirth" cssClass="error"/></div>
                <div><p>PESEL:</p> <form:input path="pesel" placeholder="Enter PESEL" title="Enter PESEL"/><form:errors path="pesel" cssClass="error"/></div>
                <div><p>Insurance:</p> <form:input path="insurance" placeholder="Enter Insurance Number" title="Enter Insurance numer (numbers only)"/><form:errors path="insurance" cssClass="error"/></div>
                <div><p>Diagnoses (ICD 10):</p>
                    <form:select path="diagnoses" items="${diagnoses}" itemLabel="name" itemValue="id" multiple="true"/>
                    <form:errors path="diagnoses" cssClass="error"/>
                </div>
                <form:hidden path="specialists" value="${loggedInSpecialistId}"/><form:errors path="diagnoses" cssClass="error"/>
                <input type="submit" value="Add patient" class="button" id="yellow-button">
            </form:form>
            <span class="span-bold">You are adding a new patient to </span>${loggedInUserFullName}<span>'s List of Patients</span>
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
