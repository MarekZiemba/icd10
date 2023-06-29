<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add Category</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container-2">
        <div class="sub-container" id="title-container">
            <h3>Add new Category to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="category">
                <div><p>Name:</p> <form:input path="name"/><form:errors path="name" cssClass="error"/></div>
                <div><p>Evaluation Criteria:</p> <form:textarea path="evaluationCriteria" rows="4" cols="50"/><form:errors path="evaluationCriteria" cssClass="error"/></div>
                <div><p>Description:</p> <form:textarea path="description" rows="4" cols="50"/><form:errors path="description" cssClass="error"/></div>
                <input type="submit" value="Add category" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/category/add'/>" class="button-admin">Add new category</a>
            <a href="<c:url value='/category/search'/>" class="button">Search in categories</a>
            <a href="<c:url value='/category/list'/>" class="button">Categories List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
