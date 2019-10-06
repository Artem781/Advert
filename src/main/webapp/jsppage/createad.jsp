<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<%--<%@ include file="include/head.jsp" %>--%>

<html>
<head>
    <title>
        <fmt:message key="label.createad" bundle="${rb}"/>
        <%--Index--%>
    </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="container">


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarTogglerDemo01"
                aria-controls="navbarTogglerDemo01"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon">
                Пример
            </span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="#">Hidden brand</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        Home
                        <span class="sr-only">
                            (current)
                        </span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>


    <%--<%@ include file="include/menu.jsp" %>--%>
    <form class="form-horizontal" action="do?command=CreateAd" method="POST" enctype="multipart/form-data">
        <fieldset>

            <!-- Form Name -->
            <legend>Создать объявление</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="title">Заголовок объявления</label>
                <div class="col-md-4">
                    <input id="title" name="title" type="text" placeholder=" " class="form-control input-md" required
                           pattern="[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\-!?,. ]*" minlength="8" maxlength="50">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>первый символ - буква в верхнем или нижнем регистре</div>
                        <div>от 8 до 50 символов</div>
                        <div>буквы в верхнем и нижнем регистре, цифры</div>
                        <div>символы \ - ! ? , . ]*</div>
                      </span>
                </div>
            </div>


            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="brnd">Выберите марку</label>
                <div class="col-md-4">
                    <select id="brnd" name="brnd" class="form-control">
                        <option value="Acura">Acura</option>
                        <option value="Aston Martin">Aston Martin</option>
                        <option value="Audi">Audi</option>
                        <option value="Bentley">Bentley</option>
                        <option value="BMW">BMW</option>
                        <option value="Buick">Buick</option>
                        <option value="BYD">BYD</option>
                        <option value="Cadillac">Cadillac</option>
                        <option value="Chevrolet">Chevrolet</option>
                        <option value="Chrysler">Chrysler</option>
                        <option value="Citroen">Citroën</option>
                        <option value="Dacia">Dacia</option>
                        <option value="DAF">DAF</option>
                        <option value="Daihatsu">Daihatsu</option>
                        <option value="Dodge">Dodge</option>
                        <option value="Ferrari">Ferrari</option>
                        <option value="Fiat">Fiat</option>
                        <option value="Ford">Ford</option>
                        <option value="Geely">Geely</option>
                        <option value="GMC">GMC</option>
                        <option value="Honda">Honda</option>
                        <option value="Hyundai">Hyundai</option>
                        <option value="Infiniti">Infiniti</option>
                        <option value="Jaguar">Jaguar</option>
                        <option value="Kia">Kia</option>
                        <option value="Lamborghini">Lamborghini</option>
                        <option value="Land Rover">Land Rover</option>
                        <option value="Lexus">Lexus</option>
                        <option value="Lincoln">Lincoln</option>
                        <option value="Mack">Mack</option>
                        <option value="Maserati">Maserati</option>
                        <option value="Mazda">Mazda</option>
                        <option value="McLaren">McLaren</option>
                        <option value="Mercedes-Benz">Mercedes-Benz</option>
                        <option value="MINI">MINI</option>
                        <option value="Mitsubishi">Mitsubishi</option>
                        <option value="Nissan">Nissan</option>
                        <option value="Opel">Opel</option>
                        <option value="Peugeot">Peugeot</option>
                        <option value="Porsche">Porsche</option>
                        <option value="Renault">Renault</option>
                        <option value="Rolls-Royce">Rolls-Royce</option>
                        <option value="Seat">Seat</option>
                        <option value="Skoda">Skoda</option>
                        <option value="Smart">Smart</option>
                        <option value="SSangYong">SSangYong</option>
                        <option value="Subaru">Subaru</option>
                        <option value="Suzuki">Suzuki</option>
                        <option value="Tesla">Tesla</option>
                        <option value="Toyota">Toyota</option>
                        <option value="Volkswagen">Volkswagen</option>
                        <option value="Volvo">Volvo</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Модель</label>
                <div class="col-md-4">
                    <input id="model" name="model" type="text" placeholder=" " class="form-control input-md" required
                           pattern="[a-zA-Zа-яА-Я0-9 ]*" minlength="1" maxlength="45">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>от 1 до 45 символов</div>
                        <div>буквы в верхнем и нижнем регистре, цифры</div>
                      </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="color">Цвет</label>
                <div class="col-md-4">
                    <input id="color" name="color" type="text" placeholder=" " class="form-control input-md" required
                           pattern="[a-zA-Zа-яА-Я- ]*" minlength="1" maxlength="45">
                    <span class="form__error">
                        <div>латиница, кириллица</div>
                        <div>от 1 до 45 символов</div>
                        <div>буквы в верхнем и нижнем регистре</div>
                        <div>символ "-"</div>
                      </span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="body">Кузов</label>
                <div class="col-md-4">
                    <select id="body" name="body" class="form-control">
                        <option value="Sedan">Седан</option>
                        <option value="Hatchback">Хэтчбек</option>
                        <option value="Universal">Универсал</option>
                        <option value="Liftback">Лифтбек</option>
                        <option value="Coupe">Купе</option>
                        <option value="Cabriolet">Кабриолет</option>
                        <option value="Roadster">Роадстер</option>
                        <option value="Targa">Тарга</option>
                        <option value="Limo">Лимузин</option>
                        <option value="Offroad">Джип</option>
                        <option value="Crossover">Кроссовер</option>
                        <option value="Pickup">Пикап</option>
                        <option value="Furgon">Фургон</option>
                        <option value="Minivan">Минивен</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year">Год выпуска</label>
                <div class="col-md-4">
                    <input id="year" name="year" type="number" placeholder=" " class="form-control input-md" required
                           minlength="4" maxlength="4" min="1900" max="2019">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="engine">Обьем двигателя</label>
                <div class="col-md-4">
                    <input id="engine" name="engine" type="number" step="0.1" placeholder="2.5"
                           class="form-control input-md"
                           required>

                </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="at">Коробка передач</label>
                <div class="col-md-4">
                    <label class="radio-inline" for="at-0">
                        <input type="radio" name="at" id="at-0" value="Automatic" checked="checked">
                        Автоматическая
                    </label>
                    <label class="radio-inline" for="at-1">
                        <input type="radio" name="at" id="at-1" value="Manual">
                        Механическая
                    </label>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="driveunit">Привод</label>
                <div class="col-md-4">
                    <select id="driveunit" name="driveunit" class="form-control">
                        <option value="FWD">Передний</option>
                        <option value="RWD">Задний</option>
                        <option value="4WD">Полный(постоянный)</option>
                        <option value="AWD">Полный(подключаемый)</option>
                    </select>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="equipment">Комплектация</label>
                <div class="col-md-4">
                    <select id="equipment" name="equipment" class="form-control">
                        <option value="Base">Базовая</option>
                        <option value="Minimal">Минимальная</option>
                        <option value="Middle">Средняя</option>
                        <option value="Top">Люкс</option>
                        <option value="Premium">Премиум</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="millage">Пробег</label>
                <div class="col-md-4">
                    <input id="millage" name="millage" type="number" placeholder=" " class="form-control input-md"
                           required="">

                </div>
            </div>

            <!-- Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label">Бывал ли авто в ДТП?</label>
                <div class="col-md-4">
                    <label class="radio-inline" for="crashed-0">
                        <input type="radio" name="crashed" id="crashed-0" value="No" checked="checked">
                        Нет
                    </label>
                    <label class="radio-inline" for="crashed-1">
                        <input type="radio" name="crashed" id="crashed-1" value="Yes">
                        Да
                    </label>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <textarea id="description" name="description" minlength="7" maxlength="2000" placeholder=" "
                              class="form-control input-md" required></textarea>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input id="price" name="price" type="number" step="0.01" placeholder="1500.75"
                           class="form-control input-md"
                           required>

                </div>
            </div>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="upload">Фото</label>
                <div class="col-md-4">
                    <input id="upload" name="upload" class="input-file" type="file">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createad"></label>
                <div class="col-md-4">
                    <button id="createad" name="createad" class="btn btn-primary">Создать объявление</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>

