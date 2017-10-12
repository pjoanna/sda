<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-10
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edycja usera</title>
</head>
<body>
<%@include file="../jspf/message.jspf" %>
<%@include file="../jspf/menu.jspf"%>
<h2>${user}</h2>
<form name="editUser" action="/editUser.do" method="post">
    id: <input type="text" name="id" value="${user.id}"/><br/>
    name: <input type="text" name="name" value="${user.name}"/><br/>
    <input type="submit" name="submit" value="Edytuj"/>
</form>
</body>
</html>
