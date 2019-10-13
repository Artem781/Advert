<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="jsppage/error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>

<html>
<head>
    <title>
        <fmt:message key="label.index" bundle="${rb}"/>
    </title>
    <%@ include file="jsppage/include/head.jsp" %>
</head>
<body>

<header>
    <%@include file="jsppage/include/menu.jsp" %>
</header>

<div class="container ">

    <%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
        <%--<a class="navbar-brand" href=".">--%>
            <%--Home--%>
        <%--</a>--%>
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

                <%--<input class="form-control mr-sm-2" type="search" placeholder="Search advert" aria-label="Search">--%>
                <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">--%>
                    <%--Search--%>
                <%--</button>--%>
            <%--</form>--%>

            <%--&lt;%&ndash;<ul class="navbar-nav mr-auto">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ul class="navbar rounded-right">&ndash;%&gt;--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li class="nav">--%>
                    <%--<a class="nav-link" href="controller?command=to_sign_in">--%>
                        <%--<fmt:message key="label.sign-in" bundle="${rb}"/>--%>
                        <%--&lt;%&ndash;Sign in&ndash;%&gt;--%>
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

    <%--<h2>Index page</h2>--%>
    <h2>
        <fmt:message key="label.index" bundle="${rb}"/>
    </h2>
    <hr>

    <div>
        <fmt:message key="label.language" bundle="${rb}"/>
    </div>
    <hr>
    <div>
        <a class="" href="controller?command=set_lang&page=to-index">
            <fmt:message key="label.language.type" bundle="${rb}"/>
            <i aria-hidden="true"></i>
        </a>
    </div>
</div>
<%--<form class="form-horizontal" method="post" action="controller">--%>
<%--<fieldset>--%>

<%--<!-- Form Name -->--%>
<%--<legend>Button name</legend>--%>
<%--Login:<br/>--%>
<%--<input type="text" name="login" value=""/>--%>
<%--<br/>Password:<br/>--%>
<%--<input type="password" name="password" value=""/>--%>
<%--<br/>--%>
<%--<!-- Button -->--%>
<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label" for="singlebutton">Single Button</label>--%>
<%--<div class="col-md-4">--%>
<%--<button type="submit" id="singlebutton" name="command" value="signin" class="btn btn-primary">try--%>
<%--buttot--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</fieldset>--%>
<%--</form>--%>
<script src="js/bootstrap.js.map"/>
</body>
</html>
