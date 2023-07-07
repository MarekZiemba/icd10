<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update treatment</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Update existing Treatment Information</h3>
        </div>
        <div class="sub-container">
                <form:form method="post" modelAttribute="treatment">
                    <div>
                        <p>Name:</p> <form:input path="name"/><form:errors path="name" cssClass="error"/>
                    </div>
                    <div>
                        <p>Description:</p> <form:textarea path="description" rows="4" cols="50"/><form:errors path="description" cssClass="error"/>
                    </div>
                <div class="form-group">
                    <label for="specialists"><p>Specialists:</p></label>
                    <form:select path="specialists" items="${specialists}" itemLabel="fullName" itemValue="id" multiple="true"/>
                    <form:errors path="specialists" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update treatment" class="button" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/treatment/add'/>" class="button-admin">Add new treatment</a>
            <a href="<c:url value='/user/treatment/search'/>" class="button">Search in treatments</a>
            <a href="<c:url value='/user/treatment/list'/>" class="button">Treatments List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
</body>
</html>
