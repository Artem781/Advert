<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="jsppage/error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html >
<html>
<head>
    <title>
        <fmt:message key="label.index" bundle="${rb}"/>
    </title>
    <%@ include file="jsppage/include/head.jsp" %>
</head>
<body>
<c:set var="lang" scope="session" value="en"/>
<jsp:forward page="jsppage/main.jsp"/>
</body>
</html>
