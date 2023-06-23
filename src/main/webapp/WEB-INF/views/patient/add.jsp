<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add patient</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h3>Add new patient</h3>

<form:form method="post" modelAttribute="patient">

    <div>First Name: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
    <div>Last Name: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
    <div>Date Of Birth: <form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"/></div>
    <div>PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/></div>
    <div>Insurance: <form:input path="insurance"/><form:errors path="insurance" cssClass="error"/></div>
<%--    <div>Categories: <form:select path="category.id" items="${patients.categories}" itemLabel="name" itemValue="id"--%>
<%--                               multiple="true"/><form:errors path="category.id" cssClass="error"/></div>--%>
    <div>Categories:
        <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/>
        <form:errors path="categories" cssClass="error"/>
    </div>
<%--    <div>Specialists: <form:select path="specialist.id" items="${patient.specialists}" itemLabel="fullName" itemValue="id"--%>
<%--                               multiple="true"/><form:errors path="specialist.id" cssClass="error"/></div>--%>
    <div>Specialists:
        <form:select path="specialists" items="${specialists}" itemLabel="fullName" itemValue="id" multiple="true"/>
        <form:errors path="specialists" cssClass="error"/>
    </div>
    <input type="submit" value="Add patient">
</form:form>

</body>
</html>
