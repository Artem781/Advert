<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>User profile</title>
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
    <%@include file="include/menu.jsp" %>
</header>


<%--<div class="container">--%>

<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--&lt;%&ndash;<a class="navbar-brand" href=".">&ndash;%&gt;--%>
<%--<a class="navbar-brand" href="controller?command=to_user_profile">--%>

<%--Home--%>
<%--</a>--%>
<%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"--%>
<%--aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--<span class="navbar-toggler-icon"></span>--%>
<%--</button>--%>

<%--<div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--<ul class="navbar-nav mr-auto">--%>
<%--<li class="nav-item active">--%>
<%--<a class="nav-link" href="controller?command=to_create_advert">--%>
<%--<fmt:message key="label.to-create-advert" bundle="${rb}"/>--%>
<%--<span class="sr-only">(current)</span>--%>
<%--</a>--%>
<%--</li>--%>
<%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="nav-link" href="controller?command=List_Advert">List Advert</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>


<%--&lt;%&ndash;<li class="nav-item dropdown">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"&ndash;%&gt;--%>
<%--&lt;%&ndash;data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">&ndash;%&gt;--%>
<%--&lt;%&ndash;Dropdown&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="dropdown-menu" aria-labelledby="navbarDropdown">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="dropdown-item" href="#">Action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="dropdown-item" href="#">Another action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="dropdown-divider"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="dropdown-item" href="#">Something else here</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--</ul>--%>
<%--<form class="form-inline my-2 my-lg-0">--%>
<%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--</form>--%>

<%--&lt;%&ndash;<ul class="navbar-nav mr-auto">&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul class="navbar rounded-right">&ndash;%&gt;--%>
<%--<ul class="nav navbar-nav navbar-right">--%>
<%--&lt;%&ndash;<li class="nav">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="nav-link" href="controller?command=forward_to_sign_in">Sign in&ndash;%&gt;--%>
<%--&lt;%&ndash;<span class="sr-only">(current)</span></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="nav-link" href="controller?command=forward_to_sign_up">Sign up</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="controller?command=Logout">--%>
<%--<fmt:message key="label.logout" bundle="${rb}"/>--%>
<%--</a>--%>
<%--</li>--%>
<%--</ul>--%>

<%--</div>--%>
<%--</nav>--%>
<br>
<div class="alert alert-success" role="alert">
    <h4 class="alert-heading">Well done!</h4>
    <p class="mb-0">Welcome ${nameUser}!</p>
</div>
<hr>
    <h3>
        ${created_advert_attr}
    </h3>
    <h4>
        ${login}
    </h4>
    <br>
    <div class="page-header">
        <h3>Профиль ${user.login}</h3>
    </div>
    <div class="row">
        <div class="col-md-2">Лоигн</div>
        <div class="col-md-2">Имя</div>
        <div class="col-md-2">Дата рождения</div>
        <div class="col-md-2">Email</div>
        <div class="col-md-2">Телефон</div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-2">${user.login}</div>
        <div class="col-md-2">${user.name}</div>
        <div class="col-md-2">${user.dateOfBirth}</div>
        <div class="col-md-2">${user.email}</div>
        <div class="col-md-2">${user.tel}</div>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h3>Объявления ${user.login}</h3>
            </div>
            <div>
                <label class="switch">
                    <input type="checkbox" onclick="toggle_visibility('list','edit')">
                    <span class="slider round"></span>
                </label>
            </div>
        </div>
    </div>


    <%--<div>--%>
    <%--<label class="switch">--%>
    <%--<input type="checkbox" onclick="toggle_visibility('list','edit')">--%>
    <%--<span class="slider round"></span>--%>
    <%--</label>--%>
    <%--</div>--%>


    <%--<button type="button" onclick="toggle_visibility('list','edit')" class="btn btn-primary"--%>
    <%--data-toggle="button"--%>
    <%--aria-pressed="false"--%>
    <%--autocomplete="off">--%>
    <%--Ред/Лист--%>
    <%--</button>--%>

    <%--<div class="btn-group btn-group-toggle" data-toggle="buttons">--%>
    <%--<label class="btn btn-secondary active">--%>
    <%--<input type="radio" name="ad_list" data-toggle="button" id="ad_list" autocomplete="off" aria-pressed="false" onclick="toggle_visibility('list','edit')" checked>Список--%>
    <%--</label>--%>
    <%--<label class="btn btn-secondary">--%>
    <%--<input type="radio" name="ad_edit" data-toggle="button" id="ad_edit" autocomplete="off" aria-pressed="false" onclick="toggle_visibility('list','edit')"> Редактировать--%>
    <%--</label>--%>
    <%--</div>--%>

    <br>
    <div id="list" style="display: block">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-2">Заголовок</div>
            <div class="col-md-2">Описание</div>
            <div class="col-md-1">Марка</div>
            <div class="col-md-1">Модель</div>
            <div class="col-md-1">Цвет</div>
            <div class="col-md-1">Объем двигателя</div>
            <div class="col-md-2">Цена</div>
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
                <div class="col-md-2">${ad.description}</div>
                <div class="col-md-1">${ad.brnd}</div>
                <div class="col-md-1">${ad.model}</div>
                <div class="col-md-1">${ad.color}</div>
                <div class="col-md-1">${ad.engine} л.</div>
                <div class="col-md-2">${ad.price} руб.</div>
                <hr>
            </div>
        </c:forEach>
    </div>
    <div id="edit" style="display: none">
        <c:forEach items="${ads}" var="ad">
            <form class="update-ads-${ad.id}" action="do?command=Profile" method="POST" enctype="multipart/form-data">
                <div class="row">

                    <div class="hiden">
                        <label for="id">ID</label>
                        <input readonly type="number" id="id" class="form-control input-md" name="id" value="${ad.id}"/>
                    </div>

                    <div class="col-md-3">
                        <label for="title">Заголовок</label>
                        <input id="title" name="title" type="text" value="${ad.title}" placeholder=" "
                               class="form-control input-md" required
                               pattern="[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\-!?,. ]*" minlength="8" maxlength="50">
                        <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>первый символ - буква в верхнем или нижнем регистре</div>
                        <div>от 8 до 50 символов</div>
                        <div>буквы в верхнем и нижнем регистре, цифры</div>
                        <div>символы \ - ! ? , . ]*</div>
                      </span>
                    </div>
                    <div class="col-md-3">
                        <label for="description">Описание</label>
                        <input minlength="7" max="2000" type="text" id="description" class="form-control input-md"
                               name="description"
                               value="${ad.description}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="brnd">Марка</label>
                        <input readonly type="text" id="brnd" class="form-control input-md" name="brnd"
                               value="${ad.brnd}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="model">Модель</label>
                        <input readonly type="text" id="model" class="form-control input-md" name="model"
                               value="${ad.model}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="color">Цвет</label>
                        <input id="color" name="color" type="text" value="${ad.color}" placeholder=" "
                               class="form-control input-md" required
                               pattern="[a-zA-Zа-яА-Я- ]*" minlength="1" maxlength="45">
                        <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>от 1 до 45 символов</div>
                        <div>буквы в верхнем и нижнем регистре</div>
                        <div>символ "-"</div>
                      </span>
                    </div>
                    <div class="col-md-3">
                        <label for="body">Кузов</label>
                        <input readonly id="body" type="text" class="form-control input-md" name="body"
                               value="${ad.body}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="year">Год</label>
                        <input id="year" name="year" type="number" value="${ad.year}" placeholder=" "
                               class="form-control input-md" required
                               minlength="4" maxlength="4" min="1900" max="2019">
                    </div>
                    <div class="col-md-3">
                        <label for="engine">Объем двигателя</label>
                        <input id="engine" name="engine" type="number" value="${ad.engine}" step="0.1" placeholder="2.5"
                               class="form-control input-md"
                               required/>
                    </div>
                    <div class="col-md-3">
                        <label for="at">Коробка передач</label>
                        <input readonly id="at" class="form-control input-md" name="at" value="${ad.at}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="driveunit">Привод</label>
                        <input readonly id="driveunit" class="form-control input-md" name="driveunit"
                               value="${ad.driveunit}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="equipment">Комплектация</label>
                        <input readonly id="equipment" class="form-control input-md" name="equipment"
                               value="${ad.equipment}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="millage">Пробег</label>
                        <input id="millage" type="number" class="form-control input-md" name="millage"
                               value="${ad.millage}"/>
                    </div>
                    <div class="col-md-3">
                        <label for="crashed">ДТП</label>
                        <input id="crashed" class="form-control" name="crashed" required value="${ad.crashed}">

                    </div>

                    <div class="col-md-3">
                        <label for="price">Цена</label>
                        <input id="price" type="number" step="0.01" class="form-control input-md" required name="price"
                               value="${ad.price}"/>
                    </div>


                    <div class=hiden>
                        <label for="id_User">Пользователь</label>
                        <input readonly id="id_User" class="form-control input-md" name="id_User"
                               value="${ad.id_User}"/>
                            <%--<select disabled id="id_User" name="id_User" class="form-control">--%>
                            <%--<c:forEach items="${users}" var="user">--%>
                            <%--<option value="${user.id}"--%>
                            <%--user=${user.id} ${user.id==ad.id_User?"selected":""}>--%>
                            <%--${user.login}--%>
                            <%--</option>--%>
                            <%--</c:forEach>--%>
                            <%--</select>--%>
                    </div>


                    <div class="col-md-3">
                        <label class="col-md-3 control-label" for="upload">Фото</label>
                        <div class="col-md-3">
                            <input id="upload" name="upload" class="input-file" type="file">
                        </div>
                    </div>

                    <div class="container">
                        <br>
                        <button id="delete" name="delete" value="delete" class="btn btn-danger">
                            Удалить
                        </button>
                        <button id="update" name="update" value="update" class="btn btn-success">
                            Обновить
                        </button>
                    </div>

                </div>
            </form>
            <hr>
        </c:forEach>
    </div>


</div>
</body>
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
</html>