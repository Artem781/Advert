<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>Logout</title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container">
<header>
    <%@include file="include/menustart.jsp" %>
</header>
<p>Cmd Logout: ${message}</p>
</div>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>