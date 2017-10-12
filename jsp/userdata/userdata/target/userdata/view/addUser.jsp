<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Dodawanie usera</title>
</head>
<body>
<%@include file="../jspf/message.jspf" %>
<%@include file="../jspf/menu.jspf" %>
<form name="addUser" action="/addUser.do" method="post">
    id: <input type="text" name="id" value=""/><br/>
    name: <input type="text" name="name" value=""/><br/>
    <input type="submit" name="submit" value="Dodaj"/>
</form>
</body>
</html>