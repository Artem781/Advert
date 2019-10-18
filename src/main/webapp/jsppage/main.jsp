<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>
        <fmt:message key="label.main" bundle="${rb}"/>
    </title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container">
    <header>
        <%@include file="include/menu.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.main" bundle="${rb}"/>
    </h2>
    <h3>
        ${lang}
    </h3>


</div>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>
