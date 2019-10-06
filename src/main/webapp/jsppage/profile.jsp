<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>



<!--            TEST PAGE                -->



<html>

<head>
    <title>Profile</title>


    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <link rel="stylesheet"
          href="../css/bootstrap.min.css"
          <%--integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
          <%--crossorigin="anonymous"--%>
    >
    <link rel="stylesheet"
          href="../css/advertstylesheet.css"
    >
    <link href="https://fonts.googleapis.com/css?family=Turret+Road&display=swap" rel="stylesheet">

</head>
<body>


<header>

    <!-- class="container-fluid" занимает всю доступную ширину  -->
    <div class="container">
        <%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="#">
                &#x100;dver&#x164;</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <!-- class="navbar-nav mr-auto" класс margin right -->
                <ul class="navbar-nav mr-auto">

                    <!-- Active sign menu -->
                    <%--<li class="nav-item active">--%>
                    <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
                    <%--</li>--%>

                    <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Link1</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Link2</a></li>

                    <!-- Dropdown menu -->
                    <%--<li class="nav-item dropdown">--%>
                    <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
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

                <!-- Form search -->
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item"><a class="nav-link" href="#">Link3</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Link4</a></li>


                </ul>


            </div>
        </nav>

    </div>

</header>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
