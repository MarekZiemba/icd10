<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <title>Hello World!</title>
</head>
<body>
<h1>Hello world!</h1>
<div><a href="<c:url value='/patient/list'/>">List of all patients</a></div><br>
<div><a href="<c:url value='/specialist/list'/>">List of all specialists</a></div><br>
<form action="/logout" method="post">
    <sec:csrfInput/>
    <div><input type="submit" value="Logout"/></div>
</form>
</body>
</html>