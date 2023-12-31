<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search users in registry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
    <div class="sub-container" id="title-container">
            <h3>Search Users in Registry</h3>
        </div>
        <div class="sub-container">
            <p>Find by Username</p>
            <form>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input id="username" name="username" type="text" placeholder="Eneter username">
                </div>
                <input type="submit" value="Search" class="button">
            </form>
        </div>
    <div class="sub-container">
        <p>Find by Specialist</p>
        <form action="<c:url value='/admin/user/search/specialist'/>">
            <div class="form-group">
                <label for="sFirstName">Specialist First Name:</label>
                <input id="sFirstName" name="firstName" type="text" placeholder="Enter first name"><br>
                <label for="sLastName">Specialist Last Name:</label>
                <input id="sLastName" name="lastName" type="text"placeholder="Enter last name">
            </div>
            <input type="submit" value="Search" class="button">
        </form>
    </div>
    <div class="sub-container">
        <p>Find by Role</p>
        <form action="<c:url value='/admin/user/search/role'/>">
            <div class="form-group">
                <label for="rname">Role Name:</label>
                <input id="rname" name="name" type="text" placeholder="Enter role name">
            </div>
            <input type="submit" value="Search" class="button">
        </form>
    </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/user/add'/>" class="button">Add new user</a>
            <a href="<c:url value='/admin/user/search'/>" class="button">Search in users</a>
            <a href="<c:url value='/admin/user/list'/>" class="button">Users List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
