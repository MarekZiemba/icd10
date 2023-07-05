<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All visits</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container">
            <h3>List of all Visits in Database</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Date Of Visit</th>
                <th>Time Of Visit</th>
                <th>Description</th>
                <th>Patient</th>
                <th>Treatment</th>
                <th>Specialist</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${visits}" var="visit">
                <tr>
                    <td>${visit.id}</td>
                    <td>${visit.dateOfVisit}</td>
                    <td>${visit.timeOfVisit}</td>
                    <td>${visit.description}</td>
                    <td>${visit.patient.firstName} ${visit.patient.lastName}</td>
                    <td>${visit.treatment.name}</td>
                    <td>${visit.specialist.firstName} ${visit.specialist.lastName}</td>
                    <td>
                        <a href="<c:url value='/user/visit/edit?id=${visit.id}'/>" class="button" id="yellow-button">Edit</a>
                        <a href="<c:url value='/user/visit/remove?id=${visit.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/user/visit/add'/>" class="button">Add new visit</a>
            <a href="<c:url value='/user/visit/search'/>" class="button">Search in visits</a>
            <a href="<c:url value='/user/visit/list'/>" class="button">Visits List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
