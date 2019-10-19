<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title><fmt:message key="label.user-profile" bundle="${rb}"/></title>
    <%@ include file="include/head.jsp" %>


    <style>
        div.hiden { /* this will hide all divs on the page */
            display: none;
        }

        /* The switch - the box around the slider */
        .switch {
            position: relative;
            display: inline-block;
            width: 68px;
            height: 33px;
        }

        /* Hide default HTML checkbox */
        .switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        /* The slider */
        .slider {
            position: absolute;
            cursor: pointer;
            top: 5px;
            left: 15px;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            -webkit-transition: .4s;
            transition: .4s;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 21px;
            width: 21px;
            left: 3px;
            bottom: 4px;
            background-color: white;
            -webkit-transition: .4s;
            transition: .4s;
        }

        input:checked + .slider {
            background-color: #2196F3;
        }

        input:focus + .slider {
            box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .slider:before {
            -webkit-transform: translateX(26px);
            -ms-transform: translateX(26px);
            transform: translateX(26px);
        }

        /* Rounded sliders */
        .slider.round {
            border-radius: 34px;
        }

        .slider.round:before {
            border-radius: 50%;
        }
    </style>


</head>
<body>
<div class="container">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-userprofile">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <h2><fmt:message key="label.user-profile" bundle="${rb}"/></h2>
    <br>
    <div class="alert alert-success" role="alert">
        <%--<h4 class="alert-heading">Well done!</h4>--%>
        <p class="mb-0">Welcome <strong>${nameUser}</strong>!</p>
    </div>
    <hr>
    <h3>
        ${created_advert_attr}
    </h3>
    <br>
    <div class="page-header">
        <h3><fmt:message key="label.profile" bundle="${rb}"/> ${nameUser}</h3>
    </div>
    <div class="row">
        <div class="col-md-2"><fmt:message key="label.table-login" bundle="${rb}"/></div>
        <div class="col-md-2"><fmt:message key="label.table-name" bundle="${rb}"/></div>
        <div class="col-md-2"><fmt:message key="label.table-date-of-birth" bundle="${rb}"/></div>
        <div class="col-md-2"><fmt:message key="label.table-email" bundle="${rb}"/></div>
        <div class="col-md-2"><fmt:message key="label.table-tel" bundle="${rb}"/></div>
        <div class="col-md-2">just empty</div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-2">${login}</div>
        <div class="col-md-2">${nameUser}</div>
        <div class="col-md-2">${birthdayAttr}</div>
        <div class="col-md-2">${emailAttr}</div>
        <div class="col-md-2">${telAttr}</div>
        <div class="col-md-2"></div>
    </div>
    <br>
    <%--<div class="container">--%>
        <div class="row">
            <div class="page-header">
                <h3>
                    <fmt:message key="label.advert" bundle="${rb}"/> ${nameUser}
                </h3>
            </div>
            <div>
                <label class="switch">
                    <input type="checkbox" onclick="toggle_visibility('list','edit')">
                    <span class="slider round"></span>
                </label>
            </div>
        </div>
    <%--</div>--%>
    <br>
    <div id="list" style="display: block">
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

                <div class="zoom_img">
                    <div class="col-md-1">
                        <a target="_blank" href="images/ad${ad.id}">
                            <img src="images/ad${ad.id}" height="40px" alt="${ad.price}"
                                 onmouseover="this.height=150" ;
                                 onmouseout="this.height=40"/>
                        </a>
                    </div>
                </div>

                <div class="col-md-2">${ad.title}</div>
                <div class="col-md-3">${ad.description}</div>
                <div class="col-md-1">${ad.brnd}</div>
                <div class="col-md-1">${ad.model}</div>
                <div class="col-md-1">${ad.color}</div>
                <div class="col-md-1">${ad.year}</div>
                <div class="col-md-1">${ad.engine} л.</div>
                <div class="col-md-2">${ad.price} руб.</div>
                <hr>
            </div>
        </c:forEach>
    </div>
    <%--<div id="edit" style="display: none">--%>
        <%--<c:forEach items="${ads}" var="ad">--%>
            <%--<form class="update-ads-${ad.id}" action="do?command=Profile" method="POST" enctype="multipart/form-data">--%>
                <%--<div class="row">--%>

                    <%--<div class="hiden">--%>
                        <%--<label for="id">ID</label>--%>
                        <%--<input readonly type="number" id="id" class="form-control input-md" name="id" value="${ad.id}"/>--%>
                    <%--</div>--%>

                    <%--<div class="col-md-3">--%>
                        <%--<label for="title">Заголовок</label>--%>
                        <%--<input id="title" name="title" type="text" value="${ad.title}" placeholder=" "--%>
                               <%--class="form-control input-md" required--%>
                               <%--pattern="[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\-!?,. ]*" minlength="8" maxlength="50">--%>
                        <%--<span class="form__error">--%>
                        <%--<div>латиница, кириллица</div>--%>
                        <%--<div>первый символ - буква в верхнем или нижнем регистре</div>--%>
                        <%--<div>от 8 до 50 символов</div>--%>
                        <%--<div>буквы в верхнем и нижнем регистре, цифры</div>--%>
                        <%--<div>символы \ - ! ? , . ]*</div>--%>
                      <%--</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="description">Описание</label>--%>
                        <%--<input minlength="7" max="2000" type="text" id="description" class="form-control input-md"--%>
                               <%--name="description"--%>
                               <%--value="${ad.description}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="brnd">Марка</label>--%>
                        <%--<input readonly type="text" id="brnd" class="form-control input-md" name="brnd"--%>
                               <%--value="${ad.brnd}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="model">Модель</label>--%>
                        <%--<input readonly type="text" id="model" class="form-control input-md" name="model"--%>
                               <%--value="${ad.model}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="color">Цвет</label>--%>
                        <%--<input id="color" name="color" type="text" value="${ad.color}" placeholder=" "--%>
                               <%--class="form-control input-md" required--%>
                               <%--pattern="[a-zA-Zа-яА-Я- ]*" minlength="1" maxlength="45">--%>
                        <%--<span class="form__error">--%>
                        <%--<div>латиница, кириллица</div>--%>
                        <%--<div>от 1 до 45 символов</div>--%>
                        <%--<div>буквы в верхнем и нижнем регистре</div>--%>
                        <%--<div>символ "-"</div>--%>
                      <%--</span>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="body">Кузов</label>--%>
                        <%--<input readonly id="body" type="text" class="form-control input-md" name="body"--%>
                               <%--value="${ad.body}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="year">Год</label>--%>
                        <%--<input id="year" name="year" type="number" value="${ad.year}" placeholder=" "--%>
                               <%--class="form-control input-md" required--%>
                               <%--minlength="4" maxlength="4" min="1900" max="2019">--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="engine">Объем двигателя</label>--%>
                        <%--<input id="engine" name="engine" type="number" value="${ad.engine}" step="0.1" placeholder="2.5"--%>
                               <%--class="form-control input-md"--%>
                               <%--required/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="at">Коробка передач</label>--%>
                        <%--<input readonly id="at" class="form-control input-md" name="at" value="${ad.at}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="driveunit">Привод</label>--%>
                        <%--<input readonly id="driveunit" class="form-control input-md" name="driveunit"--%>
                               <%--value="${ad.driveunit}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="equipment">Комплектация</label>--%>
                        <%--<input readonly id="equipment" class="form-control input-md" name="equipment"--%>
                               <%--value="${ad.equipment}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="millage">Пробег</label>--%>
                        <%--<input id="millage" type="number" class="form-control input-md" name="millage"--%>
                               <%--value="${ad.millage}"/>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3">--%>
                        <%--<label for="crashed">ДТП</label>--%>
                        <%--<input id="crashed" class="form-control" name="crashed" required value="${ad.crashed}">--%>

                    <%--</div>--%>

                    <%--<div class="col-md-3">--%>
                        <%--<label for="price">Цена</label>--%>
                        <%--<input id="price" type="number" step="0.01" class="form-control input-md" required name="price"--%>
                               <%--value="${ad.price}"/>--%>
                    <%--</div>--%>


                    <%--<div class=hiden>--%>
                        <%--<label for="id_User">Пользователь</label>--%>
                        <%--<input readonly id="id_User" class="form-control input-md" name="id_User"--%>
                               <%--value="${ad.id_User}"/>--%>
                            <%--&lt;%&ndash;<select disabled id="id_User" name="id_User" class="form-control">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<c:forEach items="${users}" var="user">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<option value="${user.id}"&ndash;%&gt;--%>
                            <%--&lt;%&ndash;user=${user.id} ${user.id==ad.id_User?"selected":""}>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;${user.login}&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</option>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
                    <%--</div>--%>


                    <%--<div class="col-md-3">--%>
                        <%--<label class="col-md-3 control-label" for="upload">Фото</label>--%>
                        <%--<div class="col-md-3">--%>
                            <%--<input id="upload" name="upload" class="input-file" type="file">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="container">--%>
                        <%--<br>--%>
                        <%--<button id="delete" name="delete" value="delete" class="btn btn-danger">--%>
                            <%--Удалить--%>
                        <%--</button>--%>
                        <%--<button id="update" name="update" value="update" class="btn btn-success">--%>
                            <%--Обновить--%>
                        <%--</button>--%>
                    <%--</div>--%>

                <%--</div>--%>
            <%--</form>--%>
            <%--<hr>--%>
        <%--</c:forEach>--%>
    <%--</div>--%>


</div>


<script type="text/javascript">
    function toggle_visibility(id, id2) {
        var e = document.getElementById(id);
        if (e.style.display == 'none')
            e.style.display = 'block';
        else
            e.style.display = 'none';

        var c = document.getElementById(id2);
        if (c.style.display == 'block')
            c.style.display = 'none';
        else
            c.style.display = 'block';
    }
</script>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>