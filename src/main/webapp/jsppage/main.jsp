<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="label.main" bundle="${rb}"/>
    </title>
    <%@ include file="include/head.jsp" %>
</head>
<body>
<div class="container-fluid">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to-main">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.main" bundle="${rb}"/>
    </h2>
    <hr>
    <%--<div class="page-header">--%>
    <%--<h3><fmt:message key="label.advert" bundle="${rb}"/></h3>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-md-2"><fmt:message key="label.ad-title" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-3"><fmt:message key="label.ad-description" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-1"><fmt:message key="label.ad-brand" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-1"><fmt:message key="label.ad-model" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-1"><fmt:message key="label.ad-color" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-1"><fmt:message key="label.ad-engine-volume" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-1"><fmt:message key="label.ad-price" bundle="${rb}"/></div>--%>
    <%--<div class="col-md-2">just empty</div>--%>
    <%--</div>--%>
    <%--<c:forEach items="${ads}" var="ad">--%>
    <%--<br>--%>
    <%--<div class="row">--%>
    <%--&lt;%&ndash;<div class="zoom_img">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="col-md-1">&ndash;%&gt;--%>

    <%--&lt;%&ndash;<a target="_blank" href="images/ad${ad.id}">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<img src="images/ad${ad.id}" height="40px" alt="${ad.price}"&ndash;%&gt;--%>
    <%--&lt;%&ndash;onmouseover="this.height=150" ;&ndash;%&gt;--%>
    <%--&lt;%&ndash;onmouseout="this.height=40"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="col-md-2">${ad.title}</div>--%>
    <%--<div class="col-md-3">${ad.description}</div>--%>
    <%--<div class="col-md-1">${ad.brnd}</div>--%>
    <%--<div class="col-md-1">${ad.model}</div>--%>
    <%--<div class="col-md-1">${ad.color}</div>--%>
    <%--<div class="col-md-1">${ad.year}</div>--%>
    <%--<div class="col-md-1">${ad.engine} л.</div>--%>
    <%--<div class="col-md-2">${ad.price} руб.</div>--%>
    <%--</div>--%>
    <%--<hr>--%>
    <%--</c:forEach>--%>

    <button type="submit" class="btn btn-primary" data-toggle="popover" title="Сообщение"
            data-content="Ура, Bootstrap 4 работает">Поднеси ко мне курсор
    </button>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>


<script>
    $(function () {
        $('[data-toggle="popover"]').popover({trigger: 'hover'});
    });
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

<%--<%@ include file="include/scriptbottom.jsp" %>--%>
</body>
</html>
