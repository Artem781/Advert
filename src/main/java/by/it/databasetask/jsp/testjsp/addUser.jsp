
  <%--Created by IntelliJ IDEA.--%>
  <%--Account: Админ--%>
  <%--Date: 08.06.2019--%>
  <%--Time: 13:17--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Login</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please add account!
    </div>
    <form method="post" action="/accounts">
        <label for="first-name">First name
            <input class="input-field" type="text" id="first-name" name="first-name">
        </label>
        <label for="last-name">Last name
            <input class="input-field" type="text" id="last-name" name="last-name">
        </label>
        <input type="submit" value="Add account">
    </form>
</div>
</body>
</html>
