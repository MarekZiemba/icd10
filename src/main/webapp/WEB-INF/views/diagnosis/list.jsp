<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All categories</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
        </div>
        <div class="sub-container" id="title-container-2">
            <h3>List of all Categories (ICD 10) in Database</h3>
        </div>
        <table>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Evaluation Criteria (ICD 10)</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${diagnoses}" var="diagnosis">
                <tr>
                    <td>${diagnosis.id}</td>
                    <td>${diagnosis.name}</td>
                    <td>${diagnosis.evaluationCriteria}</td>
                    <td>
                        <a href="<c:url value='/admin/diagnosis/edit?id=${diagnosis.id}'/>" class="button-admin">Edit</a>
                        <a href="<c:url value='/admin/diagnosis/remove?id=${diagnosis.id}'/>" class="button" id="red-button" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/diagnosis/add'/>" class="button-admin">Add new diagnosis</a>
            <a href="<c:url value='/user/diagnosis/search'/>" class="button">Search in diagnosis</a>
            <a href="<c:url value='/user/diagnosis/list'/>" class="button">Diagnosis List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
