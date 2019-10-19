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

<%--<div class="container">--%>
    <%--<header>--%>
        <%--<%@include file="jsppage/include/menustart.jsp" %>--%>
    <%--</header>--%>

    <%--<div class="container ">--%>
        <%--<br>--%>
        <%--<hr>--%>
        <%--<h2>--%>
            <%--${lang}--%>
        <%--</h2>--%>
        <%--<br>--%>
        <%--<hr>--%>
        <%--<h2>--%>
            <%--<fmt:message key="label.index" bundle="${rb}"/>--%>
        <%--</h2>--%>
        <%--<hr>--%>
        <%--<div>--%>
            <%--<fmt:message key="label.language" bundle="${rb}"/>--%>
        <%--</div>--%>
        <%--<hr>--%>
        <%--<div>--%>
            <%--<a class="" href="controller?command=set_lang&page=to-index">--%>
                <%--<fmt:message key="label.language.type" bundle="${rb}"/>--%>
                <%--<i aria-hidden="true"></i>--%>
            <%--</a>--%>
        <%--</div>--%>
    <%--</div>--%>


    <%--<div class="page-header">--%>
        <%--<h3>Объявления</h3>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
        <%--<div class="col-md-1"></div>--%>
        <%--<div class="col-md-2">Заголовок</div>--%>
        <%--<div class="col-md-2">Описание</div>--%>
        <%--<div class="col-md-1">Марка</div>--%>
        <%--<div class="col-md-1">Модель</div>--%>
        <%--<div class="col-md-1">Цвет</div>--%>
        <%--<div class="col-md-1">Год</div>--%>
        <%--<div class="col-md-1">Объем двигателя</div>--%>
        <%--<div class="col-md-2">Цена</div>--%>
    <%--</div>--%>
    <%--<c:forEach items="${ads}" var="ad">--%>
        <%--<br>--%>
        <%--<div class="row">--%>
                <%--&lt;%&ndash;<div class="zoom_img">&ndash;%&gt;--%>
            <%--<div class="col-md-1">--%>

                    <%--&lt;%&ndash;<a target="_blank" href="images/ad${ad.id}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<img src="images/ad${ad.id}"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;height="40px"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;alt="${ad.price}"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;onmouseover="this.height=150" ;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;onmouseout="this.height=40"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;/>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
            <%--</div>--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--<div class="col-md-2">${ad.title}</div>--%>
            <%--<div class="col-md-2">${ad.description}</div>--%>
            <%--<div class="col-md-1">${ad.brnd}</div>--%>
            <%--<div class="col-md-1">${ad.model}</div>--%>
            <%--<div class="col-md-1">${ad.color}</div>--%>
            <%--<div class="col-md-1">${ad.year}</div>--%>
            <%--<div class="col-md-1">${ad.engine} л.</div>--%>
            <%--<div class="col-md-2">${ad.price} руб.</div>--%>
        <%--</div>--%>
        <%--<hr>--%>
    <%--</c:forEach>--%>
<%--</div>--%>
<%--<%@ include file="jsppage/include/scriptbottom.jsp" %>--%>
</body>
</html>
