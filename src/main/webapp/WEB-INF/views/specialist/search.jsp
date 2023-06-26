<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search specialists in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container">
            <h3>Search specialists in Registry</h3>
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
            <p>Find by Specialization</p>
            <form action="<c:url value='/specialist/search/specialization'/>">
                <div class="form-group">
                    <label for="sname">Specialization name:</label>
                    <input id="sname" name="name" type="text">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>
        <div class="sub-container">
            <a href="<c:url value='/specialist/add'/>" class="button">Add new specialist</a>
            <a href="<c:url value='/specialist/search'/>" class="button">Search specialist</a>
            <a href="<c:url value='/specialist/list'/>" class="button">List of all specialists</a>
        </div>
        <form action="/logout" method="post">
            <sec:csrfInput/>
            <input type="submit" value="Logout" class="button" id="red-logout"/>
        </form>
    </div>
</body>
</html>
