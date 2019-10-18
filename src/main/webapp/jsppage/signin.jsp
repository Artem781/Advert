<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
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
        <%@include file="include/menu.jsp" %>
    </header>
    <br>
    <form class="form-horizontal" method="post" action="controller">
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
</div>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>
