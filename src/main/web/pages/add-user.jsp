<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bean" type="web.AddUserPageBean" scope="request" />
<html>
<head>
    <title>Adding user</title>
</head>
<body>
<form action="add-user" method="post">
    <p>
        <label>
            Type User:
            <select name="typeUser">
                <!-- TODO select from bean -->
                <option value="operator">Operator</option>
                <option value="manager">Manager</option>
            </select>
        </label>
    </p>
    <p>
        <label>First Name:
            <input type="text" name="firstName" value="${bean.firstName}"/>
        </label>
    </p>
    <p>
        <label>Second Name:
            <input type="text" name="secondName" value="${bean.secondName}"/>
        </label>
    </p>
    <p>
        <label>Login:
            <input type="text" name="login" value="${bean.login}"/>
        </label>

        <c:if test="${not empty bean.loginError}">
            <span style="color: red">
                ${bean.loginError}
            </span>
        </c:if>
    </p>

    <p>
        <input type="submit">
    </p>
</form>
</body>
</html>