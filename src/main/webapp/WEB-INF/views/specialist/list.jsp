<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All specialists</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container">
            <h3>List of all specialists in Registry</h3>
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
                        <a href="<c:url value='/specialist/edit?id=${specialist.id}'/>" class="button-admin">Edit</a>
                        <a href="<c:url value='/specialist/remove?id=${specialist.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/specialist/add'/>" class="button-admin">Add new specialist</a>
            <a href="<c:url value='/specialist/search'/>" class="button">Search specialist</a>
            <a href="<c:url value='/specialist/list'/>" class="button">List of all specialists</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
