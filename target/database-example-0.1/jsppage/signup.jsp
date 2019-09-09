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
        <input type="hidden" name="accesslevel" value="user"/>
        <br>
        ${checkEnterData}
        <br>
        <fieldset>

            <!-- Form Name -->
            <legend>
                <fmt:message key="label.sign-up" bundle="${rb}"/>
            </legend>
            <div class="alert-danger">
                ${errorMessageAttr}
            </div>
            <!-- Name input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name:*</label>
                <div class="col-md-4">
                    <input id="name" name="name" value="${nameUser}" type="text"
                           placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">
                        The first name is between 1 and 25 characters.
                        The first name can only start with an a-z (ignore case) character.
                        After that the first name can contain a-z (ignore case) and [ '-,.].
                        The first name can only end with an a-z (ignore case) character.
                    </span>
                </div>
            </div>

            <!-- Login input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login:*</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="${login}" type="text"
                           placeholder="<fmt:message key="label.login" bundle="${rb}"/>"
                           class="form-control input-md" required="">
                    <span class="help-block">
                    Login contains: letters, numbers, hyphens and underscores,
                    from 3 to 16 characters.
                    </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordfirst">Password input:*</label>
                <div class="col-md-4">
                    <input id="passwordfirst" name="passwordfirst" type="password"
                           placeholder="<fmt:message key="label.password" bundle="${rb}"/>"
                           class="form-control input-md" required="">
                    <span class="help-block">
                        Password contains: letters, numbers, hyphens and underscores,
                        from 6 to 18 characters.
                    </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordsecond">Password input confirm:*</label>
                <div class="col-md-4">
                    <input id="passwordsecond" name="passwordsecond" type="password"
                           placeholder="<fmt:message key="label.confirm" bundle="${rb}"/>"
                           class="form-control input-md" required="">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Birthday input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="dateofbirth">Birthday:*</label>
                <div class="col-md-4">
                    <input id="dateofbirth" name="birthday" value="${birthdayAttr}" type="text" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">
                        date format (yyyy-mm-dd).
                    </span>
                </div>
            </div>

            <!-- E-mail input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail:*</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="${emailAttr}" type="text" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Telephone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="tel">Telephone:*</label>
                <div class="col-md-4">
                    <input id="tel" name="tel" value="${telAttr}" type="text" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"></span>
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
