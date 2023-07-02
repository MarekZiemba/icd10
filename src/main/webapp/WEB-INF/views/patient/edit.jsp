<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update patient</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container">
            <h3>Update existing Patient Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="patient">
                <div class="form-group">
                    <label for="firstName"><p>First Name:</p></label>
                    <form:input path="firstName" id="firstName"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="lastName"><p>Last Name:</p></label>
                    <form:input path="lastName" id="lastName"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="dateOfBirth"><p>Date Of Birth:</p></label>
                    <form:input path="dateOfBirth" id="dateOfBirth"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="pesel"><p>PESEL:</p></label>
                    <form:input path="pesel" id="pesel"/>
                    <form:errors path="pesel" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="insurance"><p>Insurance:</p></label>
                    <form:input path="insurance" id="insurance"/>
                    <form:errors path="insurance" cssClass="error"/>
                </div>
                <div><p>Diagnoses (ICD 10):</p>
                    <form:select path="diagnoses" items="${diagnoses}" itemLabel="name" itemValue="id" multiple="true"/>
                    <form:errors path="diagnoses" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="specialists"><p>Specialists:</p></label>
                    <form:select path="specialists" items="${specialists}" itemLabel="fullName" itemValue="id" multiple="true"/>
                    <form:errors path="specialists" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update patient" class="button" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/patient/add'/>" class="button">Add new patient</a>
            <a href="<c:url value='/patient/search'/>" class="button">Search in patients</a>
            <a href="<c:url value='/patient/list'/>" class="button">Patients List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
