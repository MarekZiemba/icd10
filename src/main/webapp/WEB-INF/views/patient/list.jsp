<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All patients</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container">
            <h3>List of all patients in Registry</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date Of Birth</th>
                <th>PESEL</th>
                <th>Insurance</th>
                <th>Categories</th>
                <th>Specialists</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${patients}" var="patient">
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.firstName}</td>
                    <td>${patient.lastName}</td>
                    <td>${patient.dateOfBirth}</td>
                    <td>${patient.pesel}</td>
                    <td>${patient.insurance}</td>
                    <td>
                        <c:forEach items="${patient.categories}" var="category">
                            ${category.name}
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${patient.specialists}" var="specialist">
                            ${specialist.fullName}
                        </c:forEach>
                    </td>
                    <td>
                        <a href="<c:url value='/patient/edit?id=${patient.id}'/>" class="button" id="yellow-button">Edit</a>
                        <a href="<c:url value='/patient/remove?id=${patient.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container">
            <a href="<c:url value='/hello'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/patient/add'/>" class="button">Add new patient</a>
            <a href="<c:url value='/patient/search'/>" class="button">Search patient</a>
            <a href="<c:url value='/patient/list'/>" class="button">List of all patients</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
