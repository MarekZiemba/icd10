<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All treatments</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container">
            <h3>List of all Treatments in Registry</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Description</th>
                <th>Specialists</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${treatments}" var="treatment">
                <tr>
                    <td>${treatment.id}</td>
                    <td>${treatment.name}</td>
                    <td>${treatment.description}</td>
                    <td>
                        <c:forEach items="${treatment.specialists}" var="specialist">
                            ${specialist.fullName}
                        </c:forEach>
                    </td>
                    <td>
                        <a href="<c:url value='/treatment/edit?id=${treatment.id}'/>" class="button-admin>Edit</a>
                        <a href="<c:url value='/treatment/remove?id=${treatment.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/treatment/add'/>" class="button-admin">Add new treatment</a>
            <a href="<c:url value='/treatment/search'/>" class="button">Search treatment</a>
            <a href="<c:url value='/treatment/list'/>" class="button">List of all treatments</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
