<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All users</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
        </div>
        <div class="sub-container" id="title-container-2">
            <h3>List of all Users in Database</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Username</th>
                <th>Specialist</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
<%--                    <td>${user.username}</td>--%>
                    <td>${user.username}</td>
                    <td>${user.specialist.firstName} ${user.specialist.lastName}</td>
                    <td>
                        <c:forEach items="${user.roles}" var="role">
                            ${role.name}
                        </c:forEach>
                    </td>
                    <td>
                        <a href="<c:url value='/admin/user/edit?id=${user.id}'/>" class="button">Edit</a>
                        <a href="<c:url value='/admin/user/remove?id=${user.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
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
