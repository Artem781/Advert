<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>Error page</title>
    <%@ include file="include/head.jsp" %>
    <style type="text/css">
        body, footer {
            color: black;
        }

        body {
            background-size: cover;
            background-image: url("<c:url value="../images/bg.jpg"/>");
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <h1>Opps...</h1>
    <p>ERROR: ${message}</p>
    Request from ${pageContext.errorData.requestURI} is failed<br>
    Servlet name: ${pageContext.errorData.servletName} <br>
    Status code: ${pageContext.errorData.statusCode}<br>
    Message from Exception: ${pageContext.exception.message}
    Exception: ${pageContext.errorData.throwable}<br>
    ${pageErrorMessageAttr}
    <div/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>