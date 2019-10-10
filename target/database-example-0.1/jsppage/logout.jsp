<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>Logout</title>
    <%@ include file="include/head.jsp" %>
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
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>

            <%--<ul class="navbar-nav mr-auto">--%>
            <%--<ul class="navbar rounded-right">--%>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav">
                    <a class="nav-link" href="controller?command=to_sign_in">Sign in
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=to_sign_up">Sign up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="controller?command=Logout">Logout</a>
                </li>
            </ul>

        </div>
    </nav>
    <p>Cmd Logout: ${message}</p>

</div>
</body>
</html>