<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>
        <fmt:message key="label.create-ad" bundle="${rb}"/>
    </title>
    <%@include file="include/head.jsp" %>
</head>
<body>
<div class="container">
    <header>
        <%@include file="include/menu.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.create-ad" bundle="${rb}"/>
    </h2>
    <form class="form-horizontal"
          action="controller?command=create_advert"
          method="POST"
    <%--enctype="multipart/form-data"--%>
    >
        <fieldset>
            <!-- Form Create advert -->
            <legend>
                <fmt:message key="label.create-ad" bundle="${rb}"/>
            </legend>

            <!-- Title input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="title">
                    <fmt:message key="label.car-title" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="title"
                           name="cartitle"
                           value="${car_title_attr}"
                           type="text"
                           placeholder=""
                           class="form-control input-md"
                    <%--required--%>
                    <%--pattern="[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\-!?,. ]*"--%>
                    <%--minlength="8"--%>
                    <%--maxlength="50">--%>
                    <span class="form__error">
                        <fmt:message key="label.format-car-title" bundle="${rb}"/>
                      </span>
                </div>
            </div>

            <!-- Select Brand -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="brnd">
                    <fmt:message key="label.choose-brand" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <select id="brnd"
                            name="carbrand"
                            value="${car_brand_attr}"
                            class="form-control">
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

            <!-- Model input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">
                    <fmt:message key="label.choose-model" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="model"
                           name="carmodel"
                           value="${car_model_attr}"
                           type="text"
                           placeholder=""
                           class="form-control input-md"
                    <%--required--%>
                    <%--pattern="[a-zA-Zа-яА-Я0-9 ]*" --%>
                    <%--minlength="1" --%>
                    <%--maxlength="45"--%>
                    >
                    <span class="form__error">
                        <fmt:message key="label.format-car-model" bundle="${rb}"/>
                      </span>
                </div>
            </div>

            <!-- Color input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="color">
                    <fmt:message key="label.choose-color" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="color"
                           name="carcolor"
                           value="${car_color_attr}"
                           type="text"
                           placeholder=""
                           class="form-control input-md"
                    <%--required--%>
                    <%--pattern="[a-zA-Zа-яА-Я- ]*"--%>
                    <%--minlength="1"--%>
                    <%--maxlength="45"--%>
                    >
                    <span class="form__error">
                        <fmt:message key="label.format-car-color" bundle="${rb}"/>
                    </span>
                </div>
            </div>

            <!-- Select body -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="body">
                    <fmt:message key="label.choose-body" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <select id="body"
                            name="carbody"
                            value="${car_body_attr}"
                            class="form-control">
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

            <!-- Production year input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year">
                    <fmt:message key="label.choose-prod-year" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="year"
                           name="productionyear"
                           value="${car_production_year_attr}"
                           type="number"
                           placeholder=""
                           class="form-control input-md"
                    <%--required--%>
                    <%--minlength="4" --%>
                    <%--maxlength="4"--%>
                    <%--min="1900" --%>
                    <%--max="2019">--%>
                </div>
            </div>

            <!-- Volume engine input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="engine">
                    <fmt:message key="label.choose-vol-engine" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="engine"
                           name="enginevolume"
                           value="${car_engine_volume_attr}"
                           type="number"
                           step="0.1"
                    <%--placeholder="2.5"--%>
                    <%--required--%>
                           class="form-control input-md"
                    >
                </div>
            </div>

            <!-- At Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="at-0">
                    <fmt:message key="label.choose-at" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <label class="radio-inline" for="at-0">
                        <input type="radio"
                               name="attype"
                               id="at-0"
                               value="${car_at_type_attr}"
                               checked="checked"
                        >
                        <fmt:message key="label.choose-at-automatic" bundle="${rb}"/>
                    </label>
                    <label class="radio-inline" for="at-1">
                        <input type="radio"
                               name="attype"
                               value="${car_at_type_attr}"
                               id="at-1"
                        >
                        <fmt:message key="label.choose-at-mechanical" bundle="${rb}"/>
                    </label>
                </div>
            </div>

            <!-- Select drive unit -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="driveunit">
                    <fmt:message key="label.choose-drive-unit" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <select id="driveunit"
                            name="cardriveunit"
                            value="${car_driveunit_attr}"
                            class="form-control">
                        <option value="FWD">Передний</option>
                        <option value="RWD">Задний</option>
                        <option value="4WD">Полный(постоянный)</option>
                        <option value="AWD">Полный(подключаемый)</option>
                    </select>
                </div>
            </div>

            <!-- Select equipment -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="equipment">
                    <fmt:message key="label.choose-equipment" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <select id="equipment"
                            name="carequipment"
                            value="${car_equipment_attr}"
                            class="form-control">
                        <option value="Base">Базовая</option>
                        <option value="Minimal">Минимальная</option>
                        <option value="Middle">Средняя</option>
                        <option value="Top">Люкс</option>
                        <option value="Premium">Премиум</option>
                    </select>
                </div>
            </div>

            <!-- Text Mileage-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="millage">
                    <fmt:message key="label.choose-mileage" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="millage"
                           name="carmillage"
                           value="${car_millage_attr}"
                           type="number"
                           placeholder=" "
                    <%--required=""--%>
                           class="form-control input-md"
                    >
                </div>
            </div>

            <!-- Is crashed Multiple Radios (inline) -->
            <div class="form-group">
                <label class="col-md-4 control-label">
                    <fmt:message key="label.choose-is-crashed" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <label class="radio-inline" for="crashed-0">
                        <input type="radio"
                               name="ifcrashed"
                               id="crashed-0"
                               value="${car_if_crashed_attr}"
                               checked="checked">
                        <fmt:message key="label.choose-is-crashed-not" bundle="${rb}"/>
                    </label>
                    <label class="radio-inline" for="crashed-1">
                        <input type="radio"
                               name="ifcrashed"
                               id="crashed-1"
                               value="${car_if_crashed_attr}"
                        >
                        <fmt:message key="label.choose-is-crashed-yes" bundle="${rb}"/>
                    </label>
                </div>
            </div>

            <!-- Description input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">
                    <fmt:message key="label.choose-description" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <textarea id="description"
                              name="cardescription"
                              value="${car_description_attr}"
                    <%--minlength="7"--%>
                    <%--maxlength="2000"--%>
                    <%--required--%>
                              placeholder=" "
                              class="form-control input-md"
                    >
                    </textarea>
                </div>
            </div>

            <!-- Price input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">
                    <fmt:message key="label.choose-price" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="price"
                           name="carprice"
                           value="${car_price_attr}"
                           type="number"
                    <%--step="0.01"--%>
                    <%--placeholder="1500.75"--%>
                    <%--required--%>
                           class="form-control input-md"
                    >
                </div>
            </div>

            <!-- File Button -->
            <%--<div class="form-group">--%>
            <%--<label class="col-md-4 control-label" for="upload">Фото</label>--%>
            <%--<div class="col-md-4">--%>
            <%--<input id="upload" name="carphotoupload"                            value=""--%>
            <%--class="input-file" type="file">--%>
            <%--</div>--%>
            <%--</div>--%>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createad"></label>
                <div class="col-md-4">
                    <button id="createad" name="createad" value=""
                            class="btn btn-primary">
                        <fmt:message key="label.create-advert" bundle="${rb}"/>
                    </button>
                </div>
            </div>

        </fieldset>
    </form>

    <div/>
    <%@ include file="include/scriptbottom.jsp" %>
</div>
</body>
</html>

