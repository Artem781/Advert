<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="label.main" bundle="${rb}"/>
    </title>
    <link rel="stylesheet" href="../css/advertstyle.css">
    <%@ include file="include/head.jsp" %>
</head>
<body>

<header>
    <div class="container-fluid">
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-main">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </div>
</header>
<main>
    <div class="container-fluid">
        <h2>
            <fmt:message key="label.main" bundle="${rb}"/>
        </h2>
        <hr>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<%--<%@ include file="include/scriptbottom.jsp" %>--%>
</body>
</html>
