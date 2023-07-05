<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ICD10-F</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    <h1>ICD10</h1>
        <div class="sub-container-top-small">
            <span class="span-bold-big">Logged in as:</span></br>
            <span class="span-bold">Username: </span><sec:authentication property="principal.username" /></br>
            <span class="span-bold">Full name: </span>${loggedInUserFullName}
        </div>
        <div class="sub-container">
            For specialist:
            <a href="<c:url value='/user/patient/list'/>" class="button">Patients</a>
            <a href="<c:url value='/user/specialist/list'/>" class="button">Specialists</a>
            <a href="<c:url value='/user/treatment/list'/>" class="button">Treatments</a>
            <a href="<c:url value='/user/visit/list'/>" class="button">Visits</a>
            <a href="<c:url value='/user/diagnosis/list'/>" class="button">Diagnoses</a>
            <a href="<c:url value='/user/specialization/list'/>" class="button">Specializations</a>
        </div>
        <div class="sub-container">
            For Administrator:
            <a href="<c:url value='/admin/user/list'/>" class="button-admin">Users</a>
            <a href="<c:url value='/admin/role/list'/>" class="button-admin">Roles</a>
        </div>
        <form action="/logout" method="post">
            <sec:csrfInput/>
            <input type="submit" value="Logout" class="button" id="red-logout"/>
        </form>
    </div>
</body>
</html>