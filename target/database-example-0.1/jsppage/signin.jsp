<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <%--<title><fmt:message key="login.title"/></title>--%>
    <title>Sign in to AdvertApp</title>
    <%@ include file="include/head.jsp" %>
</head>
<body>


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
                <%--&lt;%&ndash;<li class="navbar-text">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<fmt:message key="label.language" bundle="${rb}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a class="nav-link" href="controller?command=set_lang&page=login">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<fmt:message key="label.language.type" bundle="${rb}"/>&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<i aria-hidden="true"></i>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
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
<%--</div>--%>
<%--//////////////////////////////////////////////////////////////////////--%>
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
