<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="label.edit-profile" bundle="${rb}"/>
    </title>
    <%@include file="include/head.jsp" %>
</head>
<body>
<div class="container">
    <header>
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to_edit_profile">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </header>
    <h2>
        <fmt:message key="label.edit-profile" bundle="${rb}"/>
    </h2>
    <br>
    <hr>

    <form class="form-horizontal" method="post" action="upload" enctype="multipart/form-data">
        <input type="hidden" name="command" value="update_photo"/>
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="filebutton">File Button</label>
                <div class="col-md-4">
                    <input id="filebutton" name="file" value="" class="input-file" type="file">
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
                <div class="col-md-4">
                    <button type="submit"
                            id="singlebutton"
                            name="singlebutton"
                            class="btn btn-primary">Button
                    </button>
                </div>
            </div>


        </fieldset>
    </form>


    <button type="button" class="btn btn-primary" data-toggle="popover" title="Сообщение"
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
<%--<%@ include file="include/scriptbottom.jsp" %>--%>
</body>
</html>
