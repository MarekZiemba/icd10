<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Search specializations in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container-2">
            <h3>Search Specializations in Registry</h3>
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
            <a href="<c:url value='/hello'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/specialization/add'/>" class="button">Add new specialization</a>
            <a href="<c:url value='/specialization/search'/>" class="button">Search specialization</a>
            <a href="<c:url value='/specialization/list'/>" class="button">List of all specializations</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
