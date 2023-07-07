<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="sub-container div-access-denied">
    <h3 class="error">Brak dostępu</h3>
    <div class="access-denied">
        <p>Nie masz wystarczających uprawnień do wyświetlenia tego widoku.</p>
        <p>Skontaktuj się z administratorem systemu w celu uzyskania dostępu.</p>
    </div>
<%--    <div class="sub-container-bottom">--%>
        <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
<%--    </div>--%>
</div>
</body>
</html>
