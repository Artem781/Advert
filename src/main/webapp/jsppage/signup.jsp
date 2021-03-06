<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="label.sign-up" bundle="${rb}"/></title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container-fluid">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-signup">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <br>
    <form class="form-horizontal" action="controller" method="post">
        <input type="hidden" name="command" value="sign_up"/>
        <fieldset>
            <br>
            <br>
            <!-- Form Name -->
            <legend>
                <fmt:message key="label.sign-up" bundle="${rb}"/>
            </legend>
            <br>
            ${checkEnterData}
            <div class="alert-danger">
                ${errorMessageAttr}
            </div>
            <div class="alert-danger">
                ${incorrectNameAttr}
            </div>

            <!-- Name input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">
                    <fmt:message key="label.name" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="name"
                           name="name"
                           value="${nameUser}"
                           type="text"
                           placeholder="<fmt:message key="label.name-placeholder" bundle="${rb}"/>"
                           class="form-control input-md"
                           required=""
                           aria-describedby="nameHelpBlock"
                    >
                    <small id="nameHelpBlock" class="text-muted">
                        <fmt:message key="label.format-name" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- Login input-->
            <div class="alert-danger">
                ${incorrectLoginAttr}
            </div>
            <div class="alert-danger">
                ${busyLoginAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">
                    <fmt:message key="label.login" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="login"
                           name="login"
                           value="${login}"
                           type="text"
                           placeholder="<fmt:message key="label.login-placeholder" bundle="${rb}"/>"
                    <%--pattern="^[a-z0-9_-]*" minlength="3" maxlength="16"--%>
                           class="form-control input-md"
                           required=""
                           aria-describedby="loginHelpBlock"
                    >
                    <small id="loginHelpBlock" class="text-muted">
                        <fmt:message key="label.format-login" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- Password input-->
            <div class="alert-danger">
                ${incorrectPassAttr}
            </div>
            <div class="alert-danger">
                ${noConfirmPassAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordfirst">
                    <fmt:message key="label.pass" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="passwordfirst"
                           name="passwordfirst"
                           type="password"
                           placeholder="<fmt:message key="label.password-placeholder" bundle="${rb}"/>"
                    <%--pattern="^[a-z0-9_-]*" minlength="6" maxlength="18"--%>
                           class="form-control input-md"
                           required=""
                           aria-describedby="passHelpBlock"
                    >
                    <small id="passHelpBlock" class="text-muted">
                        <fmt:message key="label.format-pass" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- Password confirm input-->
            <div class="alert-danger">
                ${incorrectPassAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordsecond">
                    <fmt:message key="label.pass-confirm" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="passwordsecond"
                           name="passwordsecond"
                           type="password"
                           placeholder="<fmt:message key="label.confirm-placeholder" bundle="${rb}"/>"
                           class="form-control input-md"
                           required="">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Birthday input-->
            <div class="alert-danger">
                ${incorrectBirthAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="dateofbirth">
                    <fmt:message key="label.birth" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="dateofbirth"
                           name="birthday"
                           value="${birthdayAttr}"
                           type="text"
                           placeholder="<fmt:message key="label.birth-placeholder" bundle="${rb}"/>"
                           class="form-control input-md"
                           aria-describedby="birthHelpBlock"
                           required="">
                    <small id="birthHelpBlock" class="text-muted">
                        <fmt:message key="label.format-birth" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- E-mail input-->
            <div class="alert-danger">
                ${incorrectEmailAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">
                    <fmt:message key="label.email" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="email"
                           name="email"
                           value="${emailAttr}"
                           type="email"
                           placeholder="<fmt:message key="label.email-placeholder" bundle="${rb}"/>"
                           class="form-control input-md"
                           aria-describedby="emailHelpBlock"
                           required="">
                    <small id="emailHelpBlock" class="text-muted">
                        <fmt:message key="label.format-email" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- Telephone input-->
            <div class="alert-danger">
                ${incorrectTelAttr}
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="tel">
                    <fmt:message key="label.tel" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="tel"
                           name="tel"
                           value="${telAttr}"
                           type="text"
                           placeholder="<fmt:message key="label.tel-placeholder" bundle="${rb}"/>"
                           class="form-control input-md"
                           aria-describedby="telHelpBlock"
                           required="">
                    <small id="telHelpBlock" class="text-muted">
                        <fmt:message key="label.format-tel" bundle="${rb}"/>
                    </small>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submitButton"></label>
                <div class="col-md-4">
                    <button id="submitButton"
                            value=""
                            type="submit"
                            name="submitButton"
                            class="btn btn-primary">
                        <fmt:message key="label.sign-up" bundle="${rb}"/>
                    </button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<footer>
    <div class="container-fluid">
        <p><%@include file="include/footer.jsp" %></p>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script>
    document.addEventListener('keydown', (e) => {
        if (e.key === 'F5') e.preventDefault();
        console.log(e.key, e.keyCode)
    })
    document.addEventListener('keyup', (e) => {
        if (e.key === 'F5') e.preventDefault();
        console.log(e.key, e.keyCode);
    })
</script>
</body>
</html>
