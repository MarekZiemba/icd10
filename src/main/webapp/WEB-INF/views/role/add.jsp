<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add role</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container-2">
        <div class="sub-container" id="title-container">
            <h3>Add new Role to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="role">
                <div><p>Name:</p> <form:input path="name"/><form:errors path="name" cssClass="error"/></div>
               <input type="submit" value="Add role" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/role/add'/>" class="button">Add role</a>
            <a href="<c:url value='/admin/role/search'/>" class="button">Search in roles</a>
            <a href="<c:url value='/admin/role/list'/>" class="button">Roles List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
