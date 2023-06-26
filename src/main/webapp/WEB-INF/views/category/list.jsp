<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All categories</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container-2">
            <h3>List of all Categories in Registry</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Evaluation Criteria</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.evaluationCriteria}</td>
                    <td>${category.description}</td>
                    <td>
                        <a href="<c:url value='/category/edit?id=${category.id}'/>" class="button" id="yellow-button">Edit</a>
                        <a href="<c:url value='/category/remove?id=${category.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/category/add'/>" class="button">Add new category</a>
            <a href="<c:url value='/category/search'/>" class="button">Search category</a>
            <a href="<c:url value='/category/list'/>" class="button">List of all categories</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
