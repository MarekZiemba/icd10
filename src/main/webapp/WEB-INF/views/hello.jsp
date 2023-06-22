<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <title>Hello World!</title>
</head>
<body>
<h1>Hello world!</h1>

<form action="/logout" method="post">
    <sec:csrfInput/>
    <div><input type="submit" value="Logout"/></div>
</form>
</body>
</html>