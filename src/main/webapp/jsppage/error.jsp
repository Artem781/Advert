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
</head>
<body>
<div class="container-fluid">
    <p>ERROR: ${message}</p>

    Request from ${pageContext.errorData.requestURI} is failed
    <br>
    Servlet name or type: ${pageContext.errorData.servletName}
    <br>
    Status code: ${pageContext.errorData.statusCode}
    <br>
    Exception: ${pageContext.errorData.throwable}
    <br>
    Message from exception: ${pageContext.exception.message}
    <div/>
    <%@ include file="include/scriptbottom.jsp" %>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <script>
        document.addEventListener('keydown', (e) => {
            if (e.key === 'F5') e.preventDefault();
            console.log(e.key, e.keyCode)
        })
        document.addEventListener('keyup', (e) => {
            if (e.key === 'F5') e.preventDefault();
            console.log(e.key, e.keyCode);
        })
    </script>
</body>
</html>