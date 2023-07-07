<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update user</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container" id="add-edit-search-container">
        <div class="sub-container" id="title-container-2">
            <h3>Update existing User Information</h3>
        </div>
        <div class="sub-container">
            <form:form method="post" modelAttribute="user">
                <div class="form-group">
                    <label for="username"><p>Username:</p></label>
                    <form:input path="username" id="username"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="password"><p>Password:</p></label>
                    <form:input path="password" id="password" readonly="true"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group" title="Check to open new password field">
                    <label for="changePassword"><p class="p-small"title="If you want to keep the old password, leave this field empty!">Check below, to change Password:</p></label>
                    <input type="checkbox" id="changePassword" onclick="togglePasswordInput(this)" />
                </div>
                <div class="form-group" id="newPasswordContainer" style="display: none;">
                    <label for="newPassword"><p>New Password:</p></label>
                    <form:password path="newPassword" id="newPassword" placeholder="Input new password"/>
                    <form:errors path="newPassword" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="enabled"><p>Enabled:</p></label>
                    <form:select path="enabled" id="enabled">
                        <form:option value="true">True</form:option>
                        <form:option value="false">False</form:option>
                    </form:select>
                    <form:errors path="enabled" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="specialist.id"><p>Specialist:</p></label>
                    <form:select path="specialist.id" items="${specialists}" itemLabel="fullName" itemValue="id"/>
                    <form:errors path="specialist" cssClass="error"/>
                </div>
                <div class="form-group"><p>Roles:</p>
                    <form:select path="roles" items="${roles}" itemLabel="name" itemValue="id" multiple="true"/>
                    <form:errors path="roles" cssClass="error"/>
                </div>
                <input type="hidden" path="id"/>
                <input type="submit" value="Update" class="button" id="yellow-button">
            </form:form>
        </div>
        <div class="sub-container-bottom">
            <a href="<c:url value='/main'/>" class="button" id="blue-button">Back to main</a>
            <a href="<c:url value='/admin/user/add'/>" class="button">Add new user</a>
            <a href="<c:url value='/admin/user/search'/>" class="button">Search in users</a>
            <a href="<c:url value='/admin/user/list'/>" class="button">Users List</a>
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Logout" class="button" id="red-logout"/>
            </form>
        </div>
    </div>
    <script>
        function togglePasswordInput(checkbox) {
            var newPasswordContainer = document.getElementById("newPasswordContainer");
            newPasswordContainer.style.display = checkbox.checked ? "block" : "none";
        }
    </script>
</body>
</html>
