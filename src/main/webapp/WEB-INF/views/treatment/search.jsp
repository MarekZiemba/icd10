<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search treatments in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container">
            <h3>Search Treatments in Registry</h3>
        </div>
        <div class="sub-container">
            <p>Find by Name</p>
            <form>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input id="name" name="name" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>
        <div class="sub-container">
            <p>Find by Specialist</p>
            <form action="<c:url value='/treatment/search/specialist'/>">
                <div class="form-group">
                    <label for="sfirstName">Specialist first name:</label>
                    <input id="sfirstName" name="firstName" type="text">
                </div>
                <div class="form-group">
                    <label for="slastName">Specialist last name:</label>
                    <input id="slastName" name="lastName" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/treatment/add'/>" class="button-admin">Add new treatment</a>
            <a href="<c:url value='/treatment/search'/>" class="button">Search in treatments</a>
            <a href="<c:url value='/treatment/list'/>" class="button">Treatments List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
