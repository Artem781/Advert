<%--<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary">--%>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-primary">

    <a class="navbar-brand" href="#">
        <img src="../img/icon-car.svg"
             width="30"
             height="30"
             class="d-inline-block align-top"
             alt="">
        ${nameUser}
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%--<li class="nav-item active">--%>
            <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>


            <c:choose>
            <c:when test="${nameUser==null}">




                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=to_sign_in">
                            <fmt:message key="label.sign-in" bundle="${rb}"/>
                                <%--Sign in--%>
                            <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=to_sign_up">
                            <fmt:message key="label.sign-up" bundle="${rb}"/>
                        </a>
                    </li>



            </c:when>
            <c:otherwise>
            <li class="nav-item dropdown">
                <a class="nav-item nav-link" href="do?command=CreateAd">Create ad</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-item nav-link" href="do?command=Profile">Profile</a>
            </li>


            <!-- Проверить левел юзера и левел админа-->
            <c:if test="${access_level==ADMIN}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Админка
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


            <form class="form-inline my-2 my-lg-0" action="do?command=SearchResult" method="POST">
                <input class="form-control mr-sm-2" id="search" name="search" pattern="[a-zA-Zа-яА-Я0-9- ]*"
                       minlength="1"
                       maxlength="45" placeholder="">
                <button class="btn btn-outline-success my-2 my-sm-0" id="gosearch" name="gosearch" value="gosearch">
                    Search
                </button>
            </form>

            <c:if test="${nameUser!=null}">
            <form class="form-inline my-2 my-lg-0" action="do?command=Profile" method="POST">
                <button id="logout" name="logout" class="btn btn-dark">Log out</button>
            </form>
            </c:if>

    </div>
</nav>