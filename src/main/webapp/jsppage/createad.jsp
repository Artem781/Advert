<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="label.create-ad" bundle="${rb}"/>
    </title>
    <%@include file="include/head.jsp" %>
</head>
<body>
<div class="container-fluid">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-createad">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.create-ad" bundle="${rb}"/>
    </h2>
    <form class="form-horizontal"
          action="controller?command=create_advert"
          method="POST"
    <%--enctype="multipart/form-data">--%>
    <%--<input type="hidden" name="command" value="create_advert"/>--%>
    <fieldset>
        <!-- Form Create advert -->
        <legend>
            <fmt:message key="label.create-ad" bundle="${rb}"/>
        </legend>
        <div class="alert-danger">
            ${errorMessageAttrCreateAdvert}
        </div>
        <div class="alert-danger">
            ${incorrectCarTitleAttr}
        </div>
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

        <div class="alert-danger">
            ${incorrectCarBrandAttr}
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

        <div class="alert-danger">
            ${incorrectCarModelAttr}
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

        <div class="alert-danger">
            ${incorrectCarColorAttr}
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

        <div class="alert-danger">
            ${incorrectCarBodyAttr}
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
                    <option value="Sedan">Sedan</option>
                    <option value="Hatchback">Hatchback</option>
                    <option value="Universal">Universal</option>
                    <option value="Liftback">Liftback</option>
                    <option value="Coupe">Coupe</option>
                    <option value="Cabriolet">Cabriolet</option>
                    <option value="Roadster">Roadster</option>
                    <option value="Targa">Targa</option>
                    <option value="Limo">Limo</option>
                    <option value="Offroad">Offroad</option>
                    <option value="Crossover">Crossover</option>
                    <option value="Pickup">Pickup</option>
                    <option value="Furgon">Furgon</option>
                    <option value="Minivan">Minivan</option>
                </select>
            </div>
        </div>

        <div class="alert-danger">
            ${incorrectCarProductionYearAttr}
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
                >
                <span class="form__error">
                        <fmt:message key="label.format-car-production-year" bundle="${rb}"/>
                    </span>


            </div>
        </div>

        <div class="alert-danger">
            ${incorrectEngineVolumeAttr}
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
                <span class="form__error">
                        <fmt:message key="label.format-car-engine-volume" bundle="${rb}"/>
                    </span>
            </div>
        </div>

        <div class="alert-danger">
            ${incorrectAtTypeAttr}
        </div>
        <!-- At Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="at-0">
                <fmt:message key="label.choose-at" bundle="${rb}"/>
            </label>
            <div class="col-md-4">
                <label class="radio-inline" for="at-0">
                    <input type="radio"
                           name="atType"
                           id="at-0"
                           value="Automatic"
                           checked="checked"
                    >
                    <fmt:message key="label.choose-at-automatic" bundle="${rb}"/>
                </label>
                <label class="radio-inline" for="at-1">
                    <input type="radio"
                           name="atType"
                           value="Mechanic"
                           id="at-1"
                    >
                    <fmt:message key="label.choose-at-mechanical" bundle="${rb}"/>
                </label>
            </div>
        </div>

        <div class="alert-danger">
            ${incorrectCarDriveunitAttr}
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
                    <option value="FWD">Front-Wheel Drive</option>
                    <option value="RWD">Rear Wheel Drive</option>
                    <option value="4WD">Full(constant) 4WD</option>
                    <option value="AWD">Full(plug-in) AWD</option>
                </select>
            </div>
        </div>

        <div class="alert-danger">
            ${incorrectCarEquipmentAttr}
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
                    <option value="Base">Base</option>
                    <option value="Minimal">Minimal</option>
                    <option value="Middle">Middle</option>
                    <option value="Top">Top</option>
                    <option value="Premium">Premium</option>
                </select>
            </div>
        </div>

        <div class="alert-danger">
            ${incorrectCarMillageAttr}
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

        <div class="alert-danger">
            ${incorrectIfCrashedAttr}
        </div>
        <!-- Is crashed Multiple Radios (inline) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="accident-try">
                <fmt:message key="label.choose-is-crashed" bundle="${rb}"/>
            </label>
            <div class="col-md-4">
                <label class="radio-inline" for="accident-try">
                    <input type="radio"
                           name="trafficAccident"
                           id="accident-try"
                           value="wasTrafficAccident"
                    >
                    <fmt:message key="label.choose-is-crashed-yes" bundle="${rb}"/>
                </label>
                <label class="radio-inline" for="accident-no">
                    <input type="radio"
                           name="trafficAccident"
                           id="accident-no"
                           value="notTrafficAccident"
                           checked="checked"
                    >
                    <fmt:message key="label.choose-is-crashed-not" bundle="${rb}"/>
                </label>
            </div>
        </div>


        <%--        <div class="form-group">--%>
        <%--            <label class="col-md-4 control-label">--%>
        <%--                <fmt:message key="label.choose-is-crashed" bundle="${rb}"/>--%>
        <%--            </label>--%>
        <%--            <div class="col-md-4">--%>
        <%--                <label class="radio-inline" for="crashed-0">--%>
        <%--                    <input type="radio"--%>
        <%--                           name="ifcrashed"--%>
        <%--                           id="crashed-0"--%>
        <%--                           value="${car_if_crashed_attr}"--%>
        <%--                    &lt;%&ndash;checked="checked"&ndash;%&gt;--%>
        <%--                    >--%>
        <%--                    <fmt:message key="label.choose-is-crashed-not" bundle="${rb}"/>--%>
        <%--                </label>--%>
        <%--                <label class="radio-inline" for="crashed-1">--%>
        <%--                    <input type="radio"--%>
        <%--                           name="ifcrashed"--%>
        <%--                           id="crashed-1"--%>
        <%--                           value="${car_if_crashed_attr}"--%>
        <%--                    >--%>
        <%--                    <fmt:message key="label.choose-is-crashed-yes" bundle="${rb}"/>--%>
        <%--                </label>--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <div class="alert-danger">
            ${incorrectCarDescriptionAttr}
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

        <div class="alert-danger">
            ${incorrectCarPriceAttr}
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
                <span class="form__error">
                        <fmt:message key="label.format-car-price" bundle="${rb}"/>
                    </span>
            </div>
        </div>

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


    <button type="button" class="btn btn-primary" data-toggle="popover" title="Сообщение"
            data-content="Ура, Bootstrap 4 работает">Поднеси ко мне курсор
    </button>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<%--<%@ include file="include/scriptbottom.jsp" %>--%>

<script>
    $(function () {
        $('[data-toggle="popover"]').popover({trigger: 'hover'});
    });
</script>
</body>
</html>

