<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All roles</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
        </div>
        <div class="sub-container" id="title-container-2">
            <h3>List of all Roles in Database</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>
                        <a href="<c:url value='/admin/role/edit?id=${role.id}'/>" class="button" id="yellow-button">Edit</a>
                        <a href="<c:url value='/admin/role/remove?id=${role.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
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
