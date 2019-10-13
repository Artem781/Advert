<nav class="navbar  navbar-expand-lg navbar-dark bg-dark">

    <%--<div class="container">--%>
        <c:choose>
            <c:when test="${nameUser==null}">
                <a class="navbar-brand" href="controller?command=to_index">Home</a>
            </c:when>
            <c:otherwise>
                <a class="navbar-brand" href="controller?command=to_user_profile">Home</a>
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
                            <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
                        </li>
                        <c:if test="${access_level==ADMIN}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Admin
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="do?command=EditUsers">Users</a>
                                    <a class="dropdown-item" href="do?command=EditAds">Ads</a>
                                    <a target="_blank" class="dropdown-item" href="http://localhost:2080/phpmyadmin/">phpMyAdmin</a>
                                </div>

                            </li>


                        </c:if>
                    </c:otherwise>
                </c:choose>
            </ul>

            <%--<div class="col-md-1" style="left: 35px">--%>
            <%--<a target="_blank" href="http://t.me/zhivov_bot">--%>
            <%--<img src="images/tlogo.png" height="30px">--%>
            <%--</a>--%>
            <%--</div>--%>

            <form class="form-inline my-2 my-lg-0" action="do?command=SearchResult" method="POST">
                <input class="form-control mr-sm-2"
                       id="search"
                       name="search"
                       pattern="[a-zA-Zа-яА-Я0-9- ]*"
                       minlength="1"
                       maxlength="45"
                       placeholder="<fmt:message key="label.by-car-brand" bundle="${rb}"/>
                ">
                <button class="btn btn-outline-success my-2 my-sm-0"
                        id="gosearch"
                        name="gosearch"
                        value="gosearch">
                    <fmt:message key="label.search" bundle="${rb}"/>
                </button>
            </form>

            <c:if test="${nameUser!=null}">
                <form class="form-inline my-2 my-lg-0" action="controller?command=Logout" method="POST">
                    <button id="logout" name="logout" class="btn btn-dark">
                        <fmt:message key="label.logout" bundle="${rb}"/>
                    </button>
                </form>
            </c:if>
        </div>
    <%--</div>--%>
</nav>
