<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 08.06.2019
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sign Up</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>First name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="account">
            <tr>
                <td>${account.firstName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
