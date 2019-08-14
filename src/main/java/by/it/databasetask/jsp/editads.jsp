<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>

<%@ include file="include/head.jsp" %>

<body>

<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
    <c:forEach items="${adverts}" var="advert">
        <form class="update-adverts-${advert.id}" action="do?command=EditAds" method="POST">
            <div class="row">
                <div class="col-md-3">
                    <label for="id">ID</label>
                    <input readonly id="id" class="form-control input-md" name="id" value="${advert.id}"/>
                </div>
                <div class="col-md-3">
                    <label for="title">Заголовок</label>
                    <input readonly id="title" class="form-control input-md" name="title" value="${advert.title}"/>
                </div>
                <div class="col-md-3">
                    <label for="description">Описание</label>
                    <input readonly id="description" class="form-control input-md" name="description"
                           value="${advert.description}"/>
                </div>
                <div class="col-md-3">
                    <label for="brand">Марка</label>
                    <input readonly id="brand" class="form-control input-md" name="brand" value="${advert.brand}"/>
                </div>
                <div class="col-md-3">
                    <label for="model">Модель</label>
                    <input readonly id="model" class="form-control input-md" name="model" value="${advert.model}"/>
                </div>
                <div class="col-md-3">
                    <label for="color">Цвет</label>
                    <input readonly id="color" class="form-control input-md" name="color" value="${advert.color}"/>
                </div>
                <div class="col-md-3">
                    <label for="body">Кузов</label>
                    <input readonly id="body" class="form-control input-md" name="body" value="${advert.body}"/>
                </div>
                <div class="col-md-3">
                    <label for="year">Год</label>
                    <input readonly id="year" class="form-control input-md" name="year" value="${advert.year}"/>
                </div>
                <div class="col-md-3">
                    <label for="engine">Объем двигателя</label>
                    <input readonly id="engine" class="form-control input-md" name="engine" value="${advert.engine}"/>
                </div>
                <div class="col-md-3">
                    <label for="at">Коробка передач</label>
                    <input readonly id="at" class="form-control input-md" name="at" value="${advert.at}"/>
                </div>
                <div class="col-md-3">
                    <label for="driveunit">Привод</label>
                    <input readonly id="driveunit" class="form-control input-md" name="driveunit"
                           value="${advert.driveunit}"/>
                </div>
                <div class="col-md-3">
                    <label for="equipment">Комплектация</label>
                    <input readonly id="equipment" class="form-control input-md" name="equipment"
                           value="${advert.equipment}"/>
                </div>
                <div class="col-md-3">
                    <label for="milage">Пробег</label>
                    <input readonly id="milage" class="form-control input-md" name="milage" value="${advert.milage}"/>
                </div>
                <div class="col-md-3">
                    <label for="crashed">ДТП</label>
                    <input readonly id="crashed" class="form-control input-md" name="crashed" value="${advert.crashed}"/>
                </div>

                <div class="col-md-3">
                    <label for="price">Цена</label>
                    <input readonly id="price" class="form-control input-md" name="price" value="${advert.price}"/>
                </div>

                <div class=col-md-3>
                    <label for="accountIdFk">Пользователь</label>

                    <input readonly id="accountIdFk" class="form-control input-md" name="accountIdFk" value="${advert.accountIdFk}"/>

                        <%--<select disabled id="accountIdFk" name="accountIdFk" class="form-control">--%>
                        <%--<c:forEach items="${accounts}" var="account">--%>
                        <%--<option value="${advert.accountIdFk}"--%>
                        <%--account=${account.id} ${account.id==advert.accountIdFk?"selected":""}>--%>
                        <%--${account.login}--%>
                        <%--</option>--%>
                        <%--</c:forEach>--%>
                        <%--</select>--%>
                </div>

                <div class="col-md-3">
                    <div class="container">
                        <br>
                        <button id="delete" value="Delete" name="delete" class="btn btn-danger">
                            Удалить
                        </button>
                    </div>
                </div>
            </div>
        </form>
        <hr>
    </c:forEach>
</div>
</body>
</html>


