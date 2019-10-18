<nav class="navbar navbar-expand-lg navbar-dark bg-dark">


    <%--<a class="navbar-brand" href="#">--%>
    <%--<img src="../img/icon-car.svg" height="56">--%>
    <%--<fmt:message key="label.nav-brand" bundle="${rb}"/>--%>
    <%--</a>--%>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="navbarSupportedContent"--%>
    <%--aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
    <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>


    <c:choose>
        <c:when test="${nameUser==null}">
            <a class="navbar-brand" href="controller?command=to_main">
                <fmt:message key="label.home" bundle="${rb}"/>
            </a>
        </c:when>
        <c:otherwise>
            <a class="navbar-brand" href="controller?command=to_user_profile">
                <fmt:message key="label.home" bundle="${rb}"/>
            </a>
        </c:otherwise>
    </c:choose>

    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${nameUser==null}">
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="controller?command=to_sign_in">
                            <fmt:message key="label.sign-in" bundle="${rb}"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="controller?command=to_sign_up">
                            <fmt:message key="label.sign-up" bundle="${rb}"/>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item dropdown">
                        <a class="nav-item nav-link" href="controller?command=to_create_advert">
                            <fmt:message key="label.to-create-advert" bundle="${rb}"/>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-item nav-link" href="controller?command=to_profile">
                            <fmt:message key="label.profile" bundle="${rb}"/>
                        </a>
                    </li>
                    <c:if test="${access_level==ADMIN}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <fmt:message key="label.admin" bundle="${rb}"/>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <%--<a class="dropdown-item" href="do?command=EditUsers">--%>
                                <a class="dropdown-item" href="controller?command=edit_users">
                                    <fmt:message key="label.users" bundle="${rb}"/>
                                </a>
                                <%--<a class="dropdown-item" href="do?command=EditAds">--%>
                                <a class="dropdown-item" href="controller?command=edit_advert">
                                    <fmt:message key="label.adverts" bundle="${rb}"/>
                                </a>
                                    <%--<a target="_blank" class="dropdown-item" href="http://localhost:2080/phpmyadmin/">phpMyAdmin</a>--%>
                            </div>
                        </li>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLinkLang" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="label.language" bundle="${rb}"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLinkLang">
                    <a class="dropdown-item" href="controller?command=set_lang&page=to-main">
                        <fmt:message key="label.language.type" bundle="${rb}"/>
                    </a>
                </div>
            </li>
        </ul>

        <%--<div class="col-md-1" style="left: 35px">--%>
        <%--<a target="_blank" href="http://t.me/bot">--%>
        <%--<img src="images/tlogo.png" height="30px">--%>
        <%--</a>--%>
        <%--</div>--%>

        <%--<form class="form-inline my-2 my-lg-0" action="do?command=SearchResult" method="POST">--%>
        <form class="form-inline my-2 my-lg-0" action="controller?command=search_result" method="POST">
            <input class="form-control mr-sm-2"
                   id="search"
                   name="search"
                   value=""
                   <%--pattern="[a-zA-Zа-яА-Я0-9- ]*"--%>
                   <%--minlength="1"--%>
                   <%--maxlength="45"--%>
                   placeholder="<fmt:message key="label.by-car-brand" bundle="${rb}"/>"
            >
            <button class="btn btn-outline-success my-2 my-sm-0"
                    id="gosearch"
                    name="gosearch"
                    value="gosearch">
                <fmt:message key="label.search" bundle="${rb}"/>
            </button>
        </form>


        <%--<div class="dropdown-menu">--%>
        <%--<form class="px-4 py-3">--%>
        <%--<div class="form-group">--%>
        <%--<label for="exampleDropdownFormEmail1">Email address</label>--%>
        <%--<input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
        <%--<label for="exampleDropdownFormPassword1">Password</label>--%>
        <%--<input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">--%>
        <%--</div>--%>
        <%--<div class="form-check">--%>
        <%--<input type="checkbox" class="form-check-input" id="dropdownCheck">--%>
        <%--<label class="form-check-label" for="dropdownCheck">--%>
        <%--Remember me--%>
        <%--</label>--%>
        <%--</div>--%>
        <%--<button type="submit" class="btn btn-primary">Sign in</button>--%>
        <%--</form>--%>
        <%--<div class="dropdown-divider"></div>--%>
        <%--<a class="dropdown-item" href="#">New around here? Sign up</a>--%>
        <%--<a class="dropdown-item" href="#">Forgot password?</a>--%>
        <%--</div>--%>


        <c:if test="${nameUser!=null}">
            <form class="form-inline my-2 my-lg-0" action="controller?command=Logout" method="POST">
                <button id="logout" name="logout" class="btn btn-dark">
                    <fmt:message key="label.logout" bundle="${rb}"/>
                </button>
            </form>
        </c:if>
    </div>
</nav>
