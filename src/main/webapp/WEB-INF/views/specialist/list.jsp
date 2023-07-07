<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All specialists</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
        </div>
        <div class="sub-container" id="title-container">
            <h3>List of all Specialists in Database</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date Of Birth</th>
                <th>PESEL</th>
                <th>Specialization</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${specialists}" var="specialist">
                <tr>
                    <td>${specialist.id}</td>
                    <td>${specialist.firstName}</td>
                    <td>${specialist.lastName}</td>
                    <td>${specialist.dateOfBirth}</td>
                    <td>${specialist.pesel}</td>
                    <td>${specialist.specialization.name}</td>
                    <td>
                        <a href="<c:url value='/admin/specialist/edit?id=${specialist.id}'/>" class="button-admin">Edit</a>
                        <a href="<c:url value='/admin/specialist/remove?id=${specialist.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/specialist/add'/>" class="button-admin">Add new specialist</a>
            <a href="<c:url value='/user/specialist/search'/>" class="button">Search in specialists</a>
            <a href="<c:url value='/user/specialist/list'/>" class="button">Specialists List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
