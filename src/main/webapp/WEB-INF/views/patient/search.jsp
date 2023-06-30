<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search patients in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container">
            <h3>Search patients in Registry</h3>
        </div>
        <div class="sub-container">
            <p>Find by Name</p>
            <form>
                <div class="form-group">
                    <label for="firstName">First name:</label>
                    <input id="firstName" name="firstName" type="text">
                </div>
                <div class="form-group">
                    <label for="lastName">Last name:</label>
                    <input id="lastName" name="lastName" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

        <div class="sub-container">
            <p>Find by Date Of Birth</p>
            <form>
                <div class="form-group">
                    <label for="dateOfBirth">Date of birth:</label>
                    <input id="dateOfBirth" name="dateOfBirth" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

        <div class="sub-container">
            <p>Find by PESEL</p>
            <form>
                <div class="form-group">
                    <label for="pesel">PESEL:</label>
                    <input id="pesel" name="pesel" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

        <div class="sub-container">
            <p>Find by Insurance</p>
            <form>
                <div class="form-group">
                    <label for="insurance">Insurance:</label>
                    <input id="insurance" name="insurance" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>

        <div class="sub-container">
            <p>Find by Specialist</p>
            <form action="<c:url value='/patient/search/specialist'/>">
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

        <div class="sub-container">
            <p>Find by Diagnosis (ICD 10)</p>
            <form action="<c:url value='/patient/search/diagnosis'/>">
                <div class="form-group">
                    <label for="cname">Diagnosis name:</label>
                    <input id="cname" name="name" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
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
