<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
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


            <input type="submit" name="Send File">


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
                <div class="col-md-4">
                    <button type="submit"
                            id="singlebutton"
                            name="singlebutton"
                            class="btn btn-primary">Button</button>
                </div>
            </div>





        </fieldset>
    </form>
    <%--<form method="post" action="upload" enctype="multipart/form-data">--%>
        <%--<input type="hidden" name="command" value="update_photo"/>--%>

        <%--<table border="0">--%>
            <%--<tr>--%>
                <%--<td>Enter your name:</td>--%>
                <%--<td><input type="text" name="name"--%>
                           <%--&lt;%&ndash;size="50"&ndash;%&gt;--%>
                <%--></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>upload your photo:</td>--%>
                <%--<td><input type="file" name="file"--%>
                           <%--&lt;%&ndash;size="50"&ndash;%&gt;--%>
                <%--></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan="2"><input type="submit" value="save"></td>--%>
            <%--</tr>--%>
        <%--</table>--%>

    <%--</form>--%>
















</div>
<%@ include file="include/scriptbottom.jsp" %>
</body>
</html>
