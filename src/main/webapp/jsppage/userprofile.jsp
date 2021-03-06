<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="label.user-profile" bundle="${rb}"/></title>
    <%@ include file="include/head.jsp" %>
    <style>
        div.hidden { /* this will hide all divs on the page */
            display: none;
        }

        /* The switch - the box around the slider */
        .switch {
            position: relative;
            display: inline-block;
            width: 68px;
            height: 33px;
        }

        /* Hide default HTML checkbox */
        .switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        /* The slider */
        .slider {
            position: absolute;
            cursor: pointer;
            top: 5px;
            left: 15px;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            -webkit-transition: .4s;
            transition: .4s;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 21px;
            width: 21px;
            left: 3px;
            bottom: 4px;
            background-color: white;
            -webkit-transition: .4s;
            transition: .4s;
        }

        input:checked + .slider {
            background-color: #2196F3;
        }

        input:focus + .slider {
            box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .slider:before {
            -webkit-transform: translateX(26px);
            -ms-transform: translateX(26px);
            transform: translateX(26px);
        }

        /* Rounded sliders */
        .slider.round {
            border-radius: 34px;
        }

        .slider.round:before {
            border-radius: 50%;
        }
    </style>
</head>
<body>
<header>
    <div class="container-fluid">
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-userprofile">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </div>
</header>
<main>
    <div class="container-fluid">
        <br>
        <div class="row">
            <div class="col-md-auto">
                <h2>${nameUser} <fmt:message key="label.profile" bundle="${rb}"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8" style="height: 200px;">
                <div class="alert alert-success" role="alert">
                    <p class="mb-0">Welcome <strong>${nameUser}</strong>!</p>
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
        <div class="table-responsive">
            <table class="table">
                <caption align="left">
                    <fmt:message key="label.profile" bundle="${rb}"/>: ${nameUser}
                </caption>
                <thead class="thead-light">
                <tr>
                    <th scope="col"><fmt:message key="label.table-login" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="label.table-name" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="label.table-date-of-birth" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="label.table-email" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="label.table-tel" bundle="${rb}"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${login}</td>
                    <td>${nameUser}</td>
                    <td>${birthdayAttr}</td>
                    <td>${emailAttr}</td>
                    <td>${telAttr}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <hr>
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h3>
                        <fmt:message key="label.advert" bundle="${rb}"/> ${nameUser}
                        <label class="switch">
                            <input type="checkbox" onclick="toggle_visibility('UsersList','edit')">
                            <span class="slider round"></span>
                        </label>
                    </h3>
                </div>
            </div>
        </div>
        <div id="UsersList" style="display: block">
            <c:set var="countAdvert" scope="session" value="1"/>
            <div class="table-responsive">
                <table class="table table-bordered ">
                    <caption align="left">
                        <fmt:message key="label.advert" bundle="${rb}"/> ${nameUser}
                    </caption>
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col"><fmt:message key="label.ad-title" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-description" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-brand" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-model" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-color" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-body" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-year" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-transmission" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-drive-unit" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-equipment" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-mileage" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-crashed" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-engine-volume" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-price" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-photo" bundle="${rb}"/></th>
                    </tr>
                    </thead>
                    <tbody class="table table-striped">
                    <c:forEach var="ad" items="${listUserAdvertAttr}">
                        <tr>
                            <th scope="row">${countAdvert}</th>
                            <td>${ad.title}</td>
                            <td>${ad.description}</td>
                            <td>${ad.getBrand()}</td>
                            <td>${ad.getModel()}</td>
                            <td>${ad.getColor()}</td>
                            <td>${ad.getBody()}</td>
                            <td>${ad.getYear()}</td>
                            <td>${ad.getAt()}</td>
                            <td>${ad.getDriveunit()}</td>
                            <td>${ad.getEquipment()}</td>
                            <td>${ad.getMilage()}</td>
                            <td>${ad.getCrashed()}</td>
                            <td>${ad.getEngine()}</td>
                            <td>${ad.getPrice()}</td>
                            <td>@photo</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <br>
        <hr>
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h3>
                        <fmt:message key="label.all-advert" bundle="${rb}"/>
                        <label class="switch">
                            <input type="checkbox" onclick="toggle_visibility('AllList','edit')">
                            <span class="slider round"></span>
                        </label>
                    </h3>
                </div>
            </div>
        </div>
        <div id="AllList" style="display: block">
            <c:set var="countAdvert" scope="session" value="1"/>
            <div class="table-responsive">
                <table class="table table-bordered ">
                    <caption align="left">
                        <fmt:message key="label.all-advert" bundle="${rb}"/>
                    </caption>
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col"><fmt:message key="label.ad-title" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-description" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-brand" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-model" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-color" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-body" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-year" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-transmission" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-drive-unit" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-equipment" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-mileage" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-crashed" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-engine-volume" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-price" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="label.ad-photo" bundle="${rb}"/></th>
                    </tr>
                    </thead>
                    <tbody class="table table-striped">
                    <c:forEach var="account" items="${listAllAdvertAttr}">
                        <tr>
                            <th scope="row">${countAdvert}</th>
                            <td>${account.getTitle()}</td>
                            <td>${account.getDescription()}</td>
                            <td>${account.getBrand()}</td>
                            <td>${account.getModel()}</td>
                            <td>${account.getColor()}</td>
                            <td>${account.getBody()}</td>
                            <td>${account.getYear()}</td>
                            <td>${account.getAt()}</td>
                            <td>${account.getDriveunit()}</td>
                            <td>${account.getEquipment()}</td>
                            <td>${account.getMilage()}</td>
                            <td>${account.getCrashed()}</td>
                            <td>${account.getEngine()}</td>
                            <td>${account.getPrice()}</td>
                            <td>@photo</td>
                        </tr>
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
<script type="text/javascript">
    function toggle_visibility(id, id2) {
        var e = document.getElementById(id);
        if (e.style.display == 'none')
            e.style.display = 'block';
        else
            e.style.display = 'none';

        var c = document.getElementById(id2);
        if (c.style.display == 'block')
            c.style.display = 'none';
        else
            c.style.display = 'block';
    }
</script>
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