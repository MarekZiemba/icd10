<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search Diagnosis (ICD 10) in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container-2">
            <h3>Search Diagnosis (ICD 10) in Registry</h3>
        </div>
        <div class="sub-container">
            <p>Find by Name</p>
            <form>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input id="name" name="name" type="text">
                </div>
<%--                <div><p>Diagnosis Name (ICD 10):</p>--%>
<%--                    <form:select path="diagnoses" items="${diagnoses}" itemLabel="name" itemValue="id" multiple="true"/>--%>
<%--                    <form:errors path="diagnoses" cssClass="error"/>--%>
<%--                </div>--%>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

    <div class="sub-container-bottom">
        <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
        <a href="<c:url value='/admin/diagnosis/add'/>" class="button-admin">Add new diagnosis</a>
        <a href="<c:url value='/user/diagnosis/search'/>" class="button">Search in diagnosis</a>
        <a href="<c:url value='/user/diagnosis/list'/>" class="button">Diagnosis List</a>
        <form action="/logout" method="post">
            <sec:csrfInput/>
            <input type="submit" value="Logout" class="button" id="red-logout"/>
        </form>
    </div>
</div>
</body>
</html>
