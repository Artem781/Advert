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


    <%--<style>--%>
    <%--.form__error {--%>
    <%--color: red;--%>
    <%--text-align: left;--%>
    <%--font-size: 12px;--%>
    <%--display: block;--%>
    <%--margin-top: 3px;--%>
    <%--display: none;--%>
    <%--}--%>

    <%--input:valid:not(:placeholder-shown) {--%>
    <%--border-color: green;--%>
    <%--}--%>

    <%--input:invalid:not(:placeholder-shown) {--%>
    <%--border-color: red;--%>
    <%--}--%>

    <%--input:invalid:not(:placeholder-shown) + .form__error {--%>
    <%--display: block;--%>
    <%--}--%>

    <%--.zoom_img img {--%>
    <%---moz-transition: all 1s ease-out;--%>
    <%---o-transition: all 1s ease-out;--%>
    <%---webkit-transition: all 1s ease-out;--%>
    <%--}--%>

    <%--.zoom_img img:hover {--%>
    <%---webkit-transform: scale(1.1);--%>
    <%---moz-transform: scale(1.1);--%>
    <%---o-transform: scale(1.1);--%>
    <%--}--%>
    <%--</style>--%>


</head>
<body>
<div class="container">


    <header>
        <%@include file="jsppage/include/menu.jsp" %>
    </header>

    <div class="container ">
        <br>
        <hr>
        <h2>
            ${lang}
        </h2>
        <br>
        <hr>
        <h2>
            <fmt:message key="label.index" bundle="${rb}"/>
        </h2>
        <hr>
        <div>
            <fmt:message key="label.language" bundle="${rb}"/>
        </div>
        <hr>
        <div>
            <a class="" href="controller?command=set_lang&page=to-index">
                <fmt:message key="label.language.type" bundle="${rb}"/>
                <i aria-hidden="true"></i>
            </a>
        </div>
    </div>


    <div class="page-header">
        <h3>Объявления</h3>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-2">Заголовок</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Марка</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Цвет</div>
        <div class="col-md-1">Год</div>
        <div class="col-md-1">Объем двигателя</div>
        <div class="col-md-2">Цена</div>
    </div>
    <c:forEach items="${ads}" var="ad">
        <br>
        <div class="row">
            <div class="zoom_img">
                <div class="col-md-1">

                    <a target="_blank" href="images/ad${ad.id}">
                        <img src="images/ad${ad.id}"
                             height="40px"
                             alt="${ad.price}"
                             onmouseover="this.height=150" ;
                             onmouseout="this.height=40"
                        />
                    </a>
                </div>
            </div>
            <div class="col-md-2">${ad.title}</div>
            <div class="col-md-2">${ad.description}</div>
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

<script src="js/bootstrap.min.js"/>
</body>
</html>
