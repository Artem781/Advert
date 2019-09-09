<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<c:set var="language" value="ru_RU" scope="session"/>--%>
<%--<fmt:setLocale value="${language}" scope="session"/>--%>
<%--<fmt:bundle basename="pagecontext" prefix="label.">--%>
<!-- SIGN IN - SIGN_IN -->
<%@ page errorPage="error.jsp"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <%--<title><fmt:message key="login.title"/></title>--%>
    <title>Sign in to AdvertApp</title>
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

                <li class="nav-item">
                    <a class="nav-link" href="controller?command=set_lang&page=login">
                        <fmt:message key="label.language.type" bundle="${rb}"/>
                        <%--<i aria-hidden="true"></i>--%>
                    </a>
                </li>
                <li class="navbar-text">
                    <fmt:message key="label.language" bundle="${rb}"/>
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
    <br>
    <form class="form-horizontal" method="post" action="controller">
        <input type="hidden" name="command" value="sign_in"/>
        <fieldset>

            <!-- Form Name -->
            <legend>
                Sign in
                <fmt:message key="label.sign-in" bundle="${rb}"/>

            </legend>

            <!-- Login input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login:*</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="" type="text"
                           placeholder="<fmt:message key="label.login" bundle="${rb}"/>"
                           class="form-control input-md" required=""
                    <%--pattern="^[a-z0-9_-]*" minlength="3" maxlength="16"--%>
                           class="form-control input-md">
                    <span class="help-block"></span>

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Password:*</label>
                <div class="col-md-4">
                    <input id="passwordinput" name="password" value="" type="password"
                           placeholder="<fmt:message key="label.password" bundle="${rb}"/>"
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

                        Sign in
                    </button>
                </div>
            </div>

        </fieldset>

    </form>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    <%--${patternLogin}--%>
    <%--<br/>--%>
    <%--${patternPassword}--%>
    <%--<br/>--%>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
</div>
<%--/////////////////////////////////////////////////////////////////--%>
<%--<form name="loginForm" method="POST" action="controller">--%>
<%--<input type="hidden" name="command" value="login" />--%>
<%--Login:<br/>--%>
<%--<input type="text" name="login" value=""/>--%>
<%--<br/>Password:<br/>--%>
<%--<input type="password" name="password" value=""/>--%>
<%--<br/>--%>
<%--${errorLoginPassMessage}--%>
<%--<br/>--%>
<%--${wrongAction}--%>
<%--<br/>--%>
<%--${nullPage}--%>
<%--<br/>--%>
<%--<input type="submit" value="Login"/>--%>
<%--</form><hr/>--%>
<%--////////////////////////////////////////////////////////////////////////--%>


</body>
</html>
