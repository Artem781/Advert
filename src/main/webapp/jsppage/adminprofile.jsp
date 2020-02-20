<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html>
<head>
    <title>
        <fmt:message key="label.admin-profile" bundle="${rb}"/>
    </title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<header>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
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

                        <%--                                CHANGE LANGUAGE                                             --%>
                        <a class="dropdown-item" href="controller?command=set_lang&page=to-adminprofile">
                            <fmt:message key="label.language.type" bundle="${rb}"/>
                        </a>
                    </div>
                </div>
                <form class="form-inline my-2 my-lg-0" action="controller?command=Logout" method="POST">
                    <button type="submit" id="logout" name="logout" class="btn btn-dark">
                        <fmt:message key="label.logout" bundle="${rb}"/>
                    </button>
                </form>
            </div>
        </nav>
    </div>
</header>
<main>
    <div class="container-fluid">
        <br>
        <div class="row">
            <div class="col-md-8" style="height: 200px;">
                <div class="alert alert-success" role="alert">
                    <p class="mb-0">
                        <strong>
                            <h2><fmt:message key="label.admin-profile" bundle="${rb}"/></h2>
                        </strong>
                    </p>
                </div>
            </div>
            <div class="col-md-4">
                <img class="img-responsive"
                     src="upload?command=get_account_image&account_id=${accountId}"
                     alt=""
                     width="100%" height="auto"
                >
            </div>
        </div>
        <br>
        <hr>
        <div id="AllList" style="display: block">
            <c:set var="countAdvert" scope="session" value="1"/>
            <div class="table-responsive">
                <table class="table table-bordered ">
                    <caption align="center">
                        <fmt:message key="label.all-user" bundle="${rb}"/>
                    </caption>
                    <thead class="thead-light">
                    <tr>
                        <th>Id</th>
                        <th scope="col"><fmt:message key="label.table-login" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.table-name" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.table-date-of-birth" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.table-email" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.table-tel" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.delete-profile" bundle="${rb}"/></th>
                    </tr>
                    </thead>
                    <tbody class="table table-striped">
                    <c:forEach var="account" items="${allAccountList}">
                        <c:set var="AdminLogin" scope="session" value="AdminLevel"/>
                        <c:if test="${account.login != AdminLogin}">
                            <tr>
                                <td>${account.getId()}</td>
                                <td>${account.login}</td>
                                <td>${account.name}</td>
                                <td>${account.birthday}</td>
                                <td>${account.email}</td>
                                <td>${account.tel}</td>
                                <td>
                                    <a href="controller?command=delete_user&id_user_for_delete=${account.getId()}&mark_if_admin=true"
                                       class="btn btn-sm btn-danger">
                                        <fmt:message key="label.delete-user-button" bundle="${rb}"/> ${account.name}
                                        <span class="glyphicon glyphicon-trash">

                                        </span>
                                    </a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<footer>
    <div class="container-fluid">
        <p><%@include file="include/footer.jsp" %></p>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script>
    document.addEventListener('keydown', (e) => {
        if (e.key === 'F5') e.preventDefault();
        console.log(e.key, e.keyCode)
    })
    document.addEventListener('keyup', (e) => {
        if (e.key === 'F5') e.preventDefault();
        console.log(e.key, e.keyCode);
    })
</script>
</body>
</html>
