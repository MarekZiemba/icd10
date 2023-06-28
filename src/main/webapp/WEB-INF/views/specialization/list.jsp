<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All specializations</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container" id="title-container-2">
            <h3>List of all Specializations in Registry</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${specializations}" var="specialization">
                <tr>
                    <td>${specialization.id}</td>
                    <td>${specialization.name}</td>
                    <td>
                        <a href="<c:url value='/specialization/edit?id=${specialization.id}'/>" class="button" id="yellow-button">Edit</a>
                        <a href="<c:url value='/specialization/remove?id=${specialization.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/specialization/add'/>" class="button">Add specialization</a>
            <a href="<c:url value='/specialization/search'/>" class="button">Search in specializations</a>
            <a href="<c:url value='/specialization/list'/>" class="button">Specializations List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
