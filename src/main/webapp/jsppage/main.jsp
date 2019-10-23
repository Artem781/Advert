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
        <%@include file="include/menustart.jsp" %>


        <a class="dropdown-item" href="controller?command=set_lang&page=to-main">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>

        <%@include file="include/menuend.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.main" bundle="${rb}"/>
    </h2>
    <hr>
    <div class="page-header">
        <h3><fmt:message key="label.advert" bundle="${rb}"/></h3>
    </div>
    <div class="row">
        <div class="col-md-2"><fmt:message key="label.ad-title" bundle="${rb}"/></div>
        <div class="col-md-3"><fmt:message key="label.ad-description" bundle="${rb}"/></div>
        <div class="col-md-1"><fmt:message key="label.ad-brand" bundle="${rb}"/></div>
        <div class="col-md-1"><fmt:message key="label.ad-model" bundle="${rb}"/></div>
        <div class="col-md-1"><fmt:message key="label.ad-color" bundle="${rb}"/></div>
        <div class="col-md-1"><fmt:message key="label.ad-engine-volume" bundle="${rb}"/></div>
        <div class="col-md-1"><fmt:message key="label.ad-price" bundle="${rb}"/></div>
        <div class="col-md-2">just empty</div>
    </div>
    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
                <%--<div class="zoom_img">--%>
                <%--<div class="col-md-1">--%>

                <%--<a target="_blank" href="images/ad${ad.id}">--%>
                <%--<img src="images/ad${ad.id}" height="40px" alt="${ad.price}"--%>
                <%--onmouseover="this.height=150" ;--%>
                <%--onmouseout="this.height=40"/>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--</div>--%>
            <div class="col-md-2">${ad.title}</div>
            <div class="col-md-3">${ad.description}</div>
            <div class="col-md-1">${ad.brnd}</div>
            <div class="col-md-1">${ad.model}</div>
            <div class="col-md-1">${ad.color}</div>
            <div class="col-md-1">${ad.year}</div>
            <div class="col-md-1">${ad.engine} л.</div>
            <div class="col-md-2">${ad.price} руб.</div>
        </div>
        <hr>
    </c:forEach>


</div>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>
