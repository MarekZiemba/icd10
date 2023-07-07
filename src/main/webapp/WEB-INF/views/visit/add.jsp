<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add visit</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as: </span><sec:authentication property="principal.username" />
        </div>
        <div class="sub-container" id="title-container-2">
            <h3>Add new Visit to Registry</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="visit">
                <div class="form-group">
                    <label for="dateOfVisit"><p>Date Of Visit:</p></label>
                    <form:input path="dateOfVisit" id="dateOfVisit" placeholder="[yyyy-MM-dd]" pattern="\d{4}-\d{2}-\d{2}" title="Please enter a date in the format yyyy-MM-DD"/>
                    <form:errors path="dateOfVisit" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="timeOfVisit"><p>Time Of Visit:</p></label>
                    <form:input path="timeOfVisit" id="timeOfVisit" placeholder="[hh:mm]" pattern="\d{2}:\d{2}" title="Please enter a time in the format hh:mm"/>
                    <form:errors path="timeOfVisit" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="patient.id"><p>Patient:</p></label>
                    <form:select path="patient.id" items="${patients}" itemLabel="fullName" itemValue="id"/>
                    <form:errors path="patient" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="treatment.id"><p>Treatment:</p></label>
                    <form:select path="treatment.id" items="${treatments}" itemLabel="name" itemValue="id"/>
                    <form:errors path="treatment" cssClass="error"/>
                </div>
                <input type="hidden" name="specialist.id" value="${loggedInSpecialistId}" />
                <input type="hidden" path="id"/>
                <div class="form-group">
                    <label for="description"><p>Description:</p></label>
                    <form:textarea path="description" id="description" rows="40" cols="80" placeholder="Here you can enter a report of the patient's visit"/>
                    <form:errors path="description" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Save" class="button" class="button" id="yellow-button-big">
            </form:form>
            <span class="span-bold">This form will be signed with : </span>
            <span>Full name : </span>${loggedInUserFullName}
        </div>
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
