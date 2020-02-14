<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <c:choose>
        <c:when test="${nameUser==null}">
        <a class="navbar-brand" href="controller?command=to_main">
            <i class="fa fa-home fa-fw"></i>
            <fmt:message key="label.home" bundle="${rb}"/>
        </a>
        </c:when>
        <c:otherwise>
        <a class="navbar-brand" href="controller?command=to_user_profile">
            <i class="fa fa-home fa-fw"></i>
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
                            <a class="nav-item nav-link" href="controller?command=to_edit_profile">
                                <fmt:message key="label.edit-profile" bundle="${rb}"/>
                            </a>
                        </li>
                        <c:if test="${access_level==ADMIN}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <fmt:message key="label.admin" bundle="${rb}"/>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="controller?command=edit_users">
                                        <fmt:message key="label.users" bundle="${rb}"/>
                                    </a>
                                    <a class="dropdown-item" href="controller?command=edit_advert">
                                        <fmt:message key="label.adverts" bundle="${rb}"/>
                                    </a>
                                </div>
                            </li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </ul>
            <div class="dropdown form-inline my-2 my-lg-0">
                <button class="btn btn-secondary dropdown-toggle"
                        type="button"
                        id="dropdownMenuButton"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false">
                    <fmt:message key="label.language" bundle="${rb}"/>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <%----%>