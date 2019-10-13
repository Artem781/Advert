<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html>
<head>
    <title>Sign up</title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container">

<header>
    <%@include file="include/menu.jsp" %>
</header>

<%--<div class="container">--%>

    <%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
        <%--<a class="navbar-brand" href=".">Home</a>--%>
        <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"--%>
                <%--aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--<span class="navbar-toggler-icon"></span>--%>
        <%--</button>--%>

        <%--<div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
            <%--<ul class="navbar-nav mr-auto">--%>
                <%--&lt;%&ndash;<li class="nav-item active">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a class="nav-link" href="controller?command=CreateAdvert">Create Advert <span&ndash;%&gt;--%>
                <%--&lt;%&ndash;class="sr-only">(current)</span></a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a class="nav-link" href="controller?command=ListAdvert">List Advert</a>&ndash;%&gt;--%>
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
                <%--<input class="form-control mr-sm-2" type="search" placeholder="Search Advert" aria-label="Search">--%>
                <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
            <%--</form>--%>

            <%--&lt;%&ndash;<ul class="navbar-nav mr-auto">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="navbar rounded-right">&ndash;%&gt;--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li class="nav">--%>
                    <%--<a class="nav-link" href="controller?command=to_sign_in">--%>
                        <%--<fmt:message key="label.sign-in" bundle="${rb}"/>--%>
                        <%--<span class="sr-only">(current)</span></a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="controller?command=to_sign_up">--%>
                        <%--<fmt:message key="label.sign-up" bundle="${rb}"/>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a class="nav-link" href="controller?command=Logout">Logout</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--</ul>--%>

        <%--</div>--%>
    <%--</nav>--%>


    <%--</div>--%>
    <form class="form-horizontal" action="controller" method="post">
        <input type="hidden" name="command" value="sign_up"/>
        <%--<input type="hidden" name="accesslevel" value="user"/>--%>
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
                <label class="col-md-4 control-label" for="dateofbirth"><fmt:message key="label.birth" bundle="${rb}"/>
                </label>
                <div class="col-md-4">
                    <input id="dateofbirth"
                           name="birthday" value="${birthdayAttr}"
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
                <label class="col-md-4 control-label" for="email"><fmt:message key="label.email" bundle="${rb}"/>
                </label>
                <div class="col-md-4">


                    <!-- заменить type="text" на type="email" -->


                    <input id="email"
                           name="email"
                           value="${emailAttr}"
                           type="text"
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
                    <button id="submitButton" name="submitButton" class="btn btn-primary">
                        <%--signup--%>
                        <fmt:message key="label.sign-up" bundle="${rb}"/>
                    </button>
                </div>
            </div>

        </fieldset>
    </form>

<%--</div>--%>
</div>
</body>
</html>
