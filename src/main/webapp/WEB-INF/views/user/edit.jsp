<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update user</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Update existing User Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="user">
                <div class="form-group">
                    <label for="username"><p>Username:</p></label>
                    <form:input path="username" id="username"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="password"><p>Password:</p></label>
                    <form:input path="password" id="password"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="enabled"><p>Enabled:</p></label>
                    <form:input path="enabled" id="enabled"/>
                    <form:errors path="enabled" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="specialist.id"><p>Specialist:</p></label>
                    <form:select path="specialist.id" items="${specialists}" itemLabel="fullName" itemValue="id"/>
                    <form:errors path="specialist" cssClass="error"/>
                </div>
                <div class="form-group"><p>Roles:</p>
                    <form:select path="roles" items="${roles}" itemLabel="name" itemValue="id" multiple="true"/>
                    <form:errors path="roles" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/user/add'/>" class="button">Add new user</a>
            <a href="<c:url value='/user/search'/>" class="button">Search in users</a>
            <a href="<c:url value='/user/list'/>" class="button">Users List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
