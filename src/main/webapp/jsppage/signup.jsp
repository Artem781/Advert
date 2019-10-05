<!--REGISTRATION - SIGN UP -->
<%@ page language="java" errorPage="error.jsp"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>


<html>
<head>
    <title>Sign up</title>
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
        <a class="navbar-brand" href=".">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="controller?command=CreateAdvert">Create Advert <span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=ListAdvert">List Advert</a>
                </li>


                <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"--%>
                <%--data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Dropdown--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                <%--</div>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                <%--</li>--%>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search Advert" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>

            <%--<ul class="navbar-nav mr-auto">--%>
            <%--<ul class="navbar rounded-right">--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav">
                    <a class="nav-link" href="controller?command=forward_to_sign_in">Sign in
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=forward_to_sign_up">Sign up</a>
                </li>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="controller?command=Logout">Logout</a>--%>
                <%--</li>--%>
            </ul>

        </div>
    </nav>


    <%--</div>--%>
    <form class="form-horizontal" action="controller" method="post">
        <input type="hidden" name="command" value="sign_up"/>
        <%--<input type="hidden" name="accesslevel" value="user"/>--%>
        <fieldset>
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
                <label class="col-md-4 control-label" for="tel"><fmt:message key="label.tel" bundle="${rb}"/>
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
                    <button id="submitButton" name="submitButton" class="btn btn-success">
                        <%--signup--%>
                        <fmt:message key="label.sign-up" bundle="${rb}"/>
                    </button>
                </div>
            </div>

        </fieldset>
    </form>

</div>

</body>
</html>
