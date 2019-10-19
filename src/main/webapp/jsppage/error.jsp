<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>Error page</title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container">
    <p>ERROR: ${message}</p>

    Request from ${pageContext.errorData.requestURI} is failed
    <br/>
    Servlet name or type: ${pageContext.errorData.servletName}
    <br/>
    Status code: ${pageContext.errorData.statusCode}
    <br/>
    Exception: ${pageContext.errorData.throwable}
    <div/>
</body>
</html>