<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Uptade specialist</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container">
            <h3>Uptade existing Specialist Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="specialist">
                <div class="form-group">
                    <label for="firstName"><p>First Name:</p></label>
                    <form:input path="firstName" id="firstName"/>
                    <form:errors path="firstName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="lastName"><p>Last Name:</p></label>
                    <form:input path="lastName" id="lastName"/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="dateOfBirth"><p>Date Of Birth:</p></label>
                    <form:input path="dateOfBirth" id="dateOfBirth"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="pesel"><p>PESEL:</p></label>
                    <form:input path="pesel" id="pesel"/>
                    <form:errors path="pesel" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="specialization.id"><p>Specialization:</p></label>
                    <form:select path="specialization.id" items="${specializations}" itemLabel="name" itemValue="id"/>
                    <form:errors path="specialization" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update specialist" class="button" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container">
            <a href="<c:url value='/specialist/add'/>" class="button">Add new specialist</a>
            <a href="<c:url value='/specialist/search'/>" class="button">Search specialist</a>
            <a href="<c:url value='/specialist/list'/>" class="button">List of all specialists</a>
        </div>
        <form action="/logout" method="post">
            <sec:csrfInput/>
            <input type="submit" value="Logout" class="button" id="red-logout"/>
        </form>
    </div>
</body>
</html>