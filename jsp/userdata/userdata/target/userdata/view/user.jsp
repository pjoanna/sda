<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>User</title>
</head>
<body>
<%@include file="../jspf/menu.jspf"%>
<h2>${user}</h2>
<h3><form name="removeUser" action="/removeUser.do" method="post">
    <input type="hidden" name="id" value="${user.id}"/><br/>
    <input type="submit" name="submit" value="Usuń"/>
</form>
    <br/>
    <a href="/edituser.html?id=${user.getId()}">edytuj</a></h3>
</body>
</html>
