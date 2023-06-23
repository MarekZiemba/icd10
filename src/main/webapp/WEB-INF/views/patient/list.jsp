<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All patients</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

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
    </tr>
    <c:forEach items="${patients}" var="patient">
        <tr>
            <td>${patient.id}</td>
            <td>${patient.firstName}</td>
            <td>${patient.lastName}</td>
            <td>${patient.dateOfBirth}</td>
            <td>${patient.pesel}</td>
            <td>${patient.insurance.insuranceNumber}</td>
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
            <td><a href="<c:url value='/patient/edit?id=${patient.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/patient/remove?id=${patient.id}'/>" onclick="return confirm('Are you sure?')">Remove</a></td>
        </tr>
    </c:forEach>
</table>

<a href="<c:url value='/patient/add'/>">Add new patient</a>
<a href="<c:url value='/patient/search'/>">Search patient</a>
<a href="<c:url value='/patient/list'/>">List of all patients</a>
</body>
</html>
