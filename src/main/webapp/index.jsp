<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Index</title>
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

<%--<jsp:forward page="/jsppage/signin.jsp"/>--%>

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href=".">
            Home
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <%--<li class="nav-item active">--%>
                    <%--<a class="nav-link" href="controller?command=CreateAdvert">Create Advert <span--%>
                            <%--class="sr-only">(current)</span></a>--%>
                <%--</li>--%>
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

                <input class="form-control mr-sm-2" type="search" placeholder="Search advert" aria-label="Search">
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
                    <%--<a class="nav-link" href="controller?command=sign_up">SignUp</a>--%>
                    <a class="nav-link" href="controller?command=forward_to_sign_up">Sign up</a>
                </li>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="controller?command=Logout">Logout</a>--%>
                <%--</li>--%>
            </ul>

        </div>
    </nav>
    <h2>Index page</h2>

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
</body>
</html>
