<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add specialist</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Add new Specialist to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="specialist">
                <div>
                    <p>First Name:</p>
                    <form:input path="firstName" placeholder="Enter First Name" title="Enter first name"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
                <div>
                    <p>Last Name:</p>
                    <form:input path="lastName" placeholder="Enter Last Name" title="Enter last name"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
                <div>
                    <p>Date Of Birth:</p>
                    <form:input path="dateOfBirth" placeholder="date format [yyyy-MM-dd]" pattern="\d{4}-\d{2}-\d{2}" title="Please enter a date in the format yyyy-MM-DD"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                </div>
                <div>
                    <p>PESEL:</p>
                    <form:input path="pesel" placeholder="Enter PESEL" title="Enter PESEL"/>
                    <form:errors path="pesel" cssClass="error"/>
                </div>
                <div>
                    <p>Specialization:</p>
                    <form:select path="specialization.id" items="${specializations}" itemLabel="name" itemValue="id"/>
                    <form:errors path="specialization" cssClass="error"/>
                </div>
                <input type="submit" value="Add specialist" class="button" id="yellow-button">
            </form:form>
        </div>
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
