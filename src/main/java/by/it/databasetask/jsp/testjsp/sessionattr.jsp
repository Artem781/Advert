<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 09.07.2019
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
Role:${role}
<br/><hr/>
Counter:${counter}
<br/><hr/>
MaxInactiveInterval: ${pageContext.session.maxInactiveInterval}<br/>
ID session: ${pageContext.session.id}<br/>
LifeCycle: ${lifecycle}<br/>
DateLast: ${dateLast}<br/>
TimeLast: ${timeLast}<br/>
<a href="index.jsp">Back to index</a>
</body>
</html>
