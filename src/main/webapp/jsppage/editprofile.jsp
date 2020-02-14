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
<div>

    <!-- HTML-код модального окна-->
    <div id="deleteUserModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">
                        <fmt:message key="label.delete-user-button" bundle="${rb}"/>
                    </h4>
                </div>
                <div class="modal-body">
                    <fmt:message key="label.delete-user-button" bundle="${rb}"/> ${nameUser}?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <fmt:message key="label.delete-user-button-close" bundle="${rb}"/>
                    </button>
                    <a href="controller?command=delete_user&id_user_for_delete=${accountId}&mark_if_admin=false"
                       class="btn btn-danger">
                        <span class="glyphicon glyphicon-trash">
                            <fmt:message key="label.delete-user-button" bundle="${rb}"/> ${nameUser}
                        </span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<header>
    <div class="container-fluid">
        <%@include file="include/menustart.jsp" %>
        <a class="dropdown-item" href="controller?command=set_lang&page=to_edit_profile">
            <fmt:message key="label.language.type" bundle="${rb}"/>
        </a>
        <%@include file="include/menuend.jsp" %>
    </div>
</header>
<main>
    <div class="container-fluid">
        <br>
        <h2>
            <fmt:message key="label.edit-profile" bundle="${rb}"/>
        </h2>
        <hr>

        <%--        FORM UPDATE PHOTO--%>
        <form class="form-horizontal" method="post" action="upload" enctype="multipart/form-data">
            <input type="hidden" name="command" value="update_photo"/>
            <fieldset>

                <!-- Form Name -->
                <legend>
                    <fmt:message key="label.choose-avatar" bundle="${rb}"/>
                </legend>
                <div class="alert-danger">
                    ${errorMessageAttrUploadMessage}
                </div>

                <!-- File Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="filebutton">
                    </label>
                    <div class="col-md-4">
                        <input id="filebutton" name="file" value="" class="input-file" type="file">
                    </div>
                </div>
                <span class="form__error">
                        <fmt:message key="label.format-photo" bundle="${rb}"/>
                    </span>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton">
                    </label>
                    <div class="col-md-4">
                        <button type="submit"
                                id="singlebutton"
                                name="singlebutton"
                                class="btn btn-primary">
                            <fmt:message key="label.upload-photo" bundle="${rb}"/>
                        </button>
                    </div>
                </div>
            </fieldset>
        </form>
        <hr>

        <%--        FORM UPDATE USER DATA--%>
        <form class="form-horizontal" action="controller" method="post">
            <input type="hidden" name="command" value="update_profile_data"/>
            <fieldset>

                <!-- Form Name -->
                <legend>
                    <fmt:message key="label.update-data-user" bundle="${rb}"/>
                </legend>
                <div class="row">
                    <div class="col-md-6">
                        <div class="alert-success">
                            <h4>
                                <strong>
                                    ${successUpdateProfileDataAttr}
                                </strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="alert-danger">
                    ${feedback}
                </div>
                <div class="alert-danger">
                    ${fbAttr}
                </div>
                <div class="alert-danger">
                    ${checkEnterData}
                </div>
                <div class="alert-danger">
                    ${errorMessageAttr}
                </div>
                <br>
                <div class="alert-danger">
                    ${incorrectNameAttr}
                </div>

                <!-- Name input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">
                        <fmt:message key="label.name" bundle="${rb}"/>
                    </label>
                    <div class="col-md-4">
                        <input id="name"
                               name="name"
                               value="${nameUser}"
                               type="text"
                               placeholder="<fmt:message key="label.name-placeholder" bundle="${rb}"/>"
                               class="form-control input-md"
                               required=""
                               aria-describedby="nameHelpBlock"
                        >
                        <small id="nameHelpBlock" class="text-muted">
                            <fmt:message key="label.format-name" bundle="${rb}"/>
                        </small>
                    </div>
                </div>

                <!-- Password input-->
                <div class="alert-danger">
                    ${incorrectPassAttr}
                </div>
                <div class="alert-danger">
                    ${noConfirmPassAttr}
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordfirst">
                        <fmt:message key="label.pass" bundle="${rb}"/>
                    </label>
                    <div class="col-md-4">
                        <input id="passwordfirst"
                               name="passwordfirst"
                               type="password"
                               placeholder="<fmt:message key="label.password-placeholder" bundle="${rb}"/>"
                        <%--pattern="^[a-z0-9_-]*" minlength="6" maxlength="18"--%>
                               class="form-control input-md"
                               required=""
                               aria-describedby="passHelpBlock"
                        >
                        <small id="passHelpBlock" class="text-muted">
                            <fmt:message key="label.format-pass" bundle="${rb}"/>
                        </small>
                    </div>
                </div>

                <!-- Password confirm input-->
                <div class="alert-danger">
                    ${incorrectPassAttr}
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordsecond">
                        <fmt:message key="label.pass-confirm" bundle="${rb}"/>
                    </label>
                    <div class="col-md-4">
                        <input id="passwordsecond"
                               name="passwordsecond"
                               type="password"
                               placeholder="<fmt:message key="label.confirm-placeholder" bundle="${rb}"/>"
                               class="form-control input-md"
                               required="">
                        <span class="help-block"></span>
                    </div>
                </div>

                <!-- E-mail input-->
                <div class="alert-danger">
                    ${incorrectEmailAttr}
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">
                        <fmt:message key="label.email" bundle="${rb}"/>
                    </label>
                    <div class="col-md-4">
                        <input
                                id="email"
                                name="email"
                                value="${emailAttr}"
                                type="email"
                                placeholder="<fmt:message key="label.email-placeholder" bundle="${rb}"/>"
                                class="form-control input-md"
                                aria-describedby="emailHelpBlock"
                                required="">
                        <small id="emailHelpBlock" class="text-muted">
                            <fmt:message key="label.format-email" bundle="${rb}"/>
                        </small>
                    </div>
                </div>

                <!-- Telephone input-->
                <div class="alert-danger">
                    ${incorrectTelAttr}
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="tel">
                        <fmt:message key="label.tel" bundle="${rb}"/>
                    </label>
                    <div class="col-md-4">
                        <input id="tel"
                               name="tel"
                               value="${telAttr}"
                               type="text"
                               placeholder="<fmt:message key="label.tel-placeholder" bundle="${rb}"/>"
                               class="form-control input-md"
                               aria-describedby="telHelpBlock"
                               required="">
                        <small id="telHelpBlock" class="text-muted">
                            <fmt:message key="label.format-tel" bundle="${rb}"/>
                        </small>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submitButton"></label>
                    <div class="col-md-4">
                        <button id="submitButton"
                                value=""
                                type="submit"
                                name="submitButton"
                                class="btn btn-primary">
                            <fmt:message key="label.update-button" bundle="${rb}"/>
                        </button>
                    </div>
                </div>
            </fieldset>
        </form>
        <br>
        <hr>

        <!-- Кнопка, вызывающее модальное окно -->
        <a href="#deleteUserModal" class="btn  btn-danger btn-sm" data-toggle="modal">
            <i class="fa fa-trash-o fa-lg"></i>
            <fmt:message key="label.delete-user-button" bundle="${rb}"/> ${nameUser}
        </a>
        <br>
        <hr>
    </div>
</main>
<footer>
</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>
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
<%--<%@ include file="include/scriptbottom.jsp" %>--%>
</body>
</html>
