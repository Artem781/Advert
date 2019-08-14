<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>


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
    <c:forEach items="${adverts}" var="advert">
        <br>
        <div class="row">
            <div class="zoom_img">
                <div class="col-md-1">

                    <a target="_blank" href="images/advert${advert.id}">
                        <img src="images/advert${advert.id}" height="40px" alt="${advert.price}"
                             onmouseover="this.height=150" ;
                             onmouseout="this.height=40"/>
                    </a>
                </div>
            </div>
            <div class="col-md-2">${advert.title}</div>
            <div class="col-md-2">${advert.description}</div>
            <div class="col-md-1">${advert.brand}</div>
            <div class="col-md-1">${advert.model}</div>
            <div class="col-md-1">${advert.color}</div>
            <div class="col-md-1">${advert.year}</div>
            <div class="col-md-1">${advert.engine} л.</div>
            <div class="col-md-2">${advert.price} руб.</div>
        </div>
        <hr>
    </c:forEach>
</div>
</div>
</body>
</html>


