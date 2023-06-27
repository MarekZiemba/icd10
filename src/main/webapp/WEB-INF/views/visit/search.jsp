<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search visits in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container">
            <h3>Search Visit in Registry</h3>
        </div>
        <div class="sub-container">
            <p>Find by Date Of Visit</p>
            <form>
                <div class="form-group">
                    <label for="dateOfVisitOnly">Date of visit:</label>
                    <input id="dateOfVisitOnly" name="dateOfVisit" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

    <div class="sub-container">
        <p>Find by Date and Time Of Visit</p>
        <form>
            <div class="form-group">
                <label for="dateOfVisit">Date of visit:</label>
                <input id="dateOfVisit" name="dateOfVisit" type="text">
            </div>
            <div class="form-group">
                <label for="timeOfVisit">Time of visit:</label>
                <input id="timeOfVisit" name="timeOfVisit" type="text">
            </div>
            <input type="submit" value="Search" class="button">
        </form>
    </div>

        <div class="sub-container">
            <p>Find by Patient</p>
            <form action="<c:url value='/visit/search/patient'/>">
                <div class="form-group">
                    <label for="pFirstName">Patient First Name:</label>
                    <input id="pFirstName" name="firstName" type="text"><br>
                    <label for="pLastName">Patient Last Name:</label>
                    <input id="pLastName" name="lastName" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

    <div class="sub-container">
        <p>Find by Treatment</p>
        <form action="<c:url value='/visit/search/treatment'/>">
            <div class="form-group">
                <label for="tname">Treatment name:</label>
                <input id="tname" name="name" type="text">
            </div>
            <input type="submit" value="Search" class="button">
        </form>
    </div>

    <div class="sub-container">
        <p>Find by Specialist</p>
        <form action="<c:url value='/visit/search/specialist'/>">
            <div class="form-group">
                <label for="sFirstName">Specialist First Name:</label>
                <input id="sFirstName" name="firstName" type="text"><br>
                <label for="sLastName">Specialist Last Name:</label>
                <input id="sLastName" name="lastName" type="text">
            </div>
            <input type="submit" value="Search" class="button">
        </form>
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
