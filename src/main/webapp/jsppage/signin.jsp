<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="label.sign-in" bundle="${rb}"/>
    </title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-signin">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <br>
    <form class="form-horizontal" method="post" action="controller" autocomplete="off">
        <input type="hidden" name="command" value="sign_in"/>
        <fieldset>

            <!-- Form Name -->
            <legend>
                <fmt:message key="label.sign-in" bundle="${rb}"/>
            </legend>
            <br>
            <!--  localisation -->
            <div class="alert-danger">
                ${errorMessageAttr}
            </div>
            <div class="alert-danger">
                ${errorLoginPassMessage}
            </div>
            <div class="alert-danger">
                ${wrongAction}
            </div>
            <div class="alert-danger">
                ${nullPage}
            </div>
            <!-- Login input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">
                    <fmt:message key="label.login" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="login" name="login" value="" type="text"
                           placeholder="<fmt:message key="label.login-placeholder" bundle="${rb}"/>"
                           class="form-control input-md" required=""
                    <%--pattern="^[a-z0-9_-]*" minlength="3" maxlength="16"--%>
                           class="form-control input-md">
                    <span class="help-block"></span>

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">
                    <fmt:message key="label.pass" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="passwordinput" name="password" value="" type="password"
                           placeholder="<fmt:message key="label.password-placeholder" bundle="${rb}"/>"
                           class="form-control input-md" required=""
                    <%--pattern="^[a-z0-9_-]*" minlength="6" maxlength="18"--%>
                           class="" form-control input-md>
                    <span class="help-block"></span>
                </div>
            </div>

            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="save">
                <label name="save" class="form-check-label" for="save">запомнить меня пока не работает</label>
            </div>






            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signinbutton"></label>
                <div class="col-md-4">
                    <button id="signinbutton" type="submit" value="" name="signinbutton"
                            class="btn btn-primary">
                        <fmt:message key="label.sign-in" bundle="${rb}"/>
                    </button>
                </div>
            </div>


        </fieldset>
    </form>
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


<script>
    $(function () {
        $('[data-toggle="popover"]').popover({trigger: 'hover'});
    });
</script>
<%--<%@ include file="include/scriptbottom.jsp" %>--%>
</body>
</html>
