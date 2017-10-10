<%--
  Created by IntelliJ IDEA.
  User: pjoanna
  Date: 2017-10-10
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie autora</title>
</head>
<body>
<%@include file="../common/menu.jspf" %>
<fieldset>
    <legend>Dodawanie autora</legend>
    <form action="<c:url value="../author.jsp"/>" method="post">
        <input type="hidden" name="action" value="add_author" />
        <input type="text" name="name" value="" /><br />
        <input type="text" name="surname" value="">
        <input type="submit" name="submit" value="dodaj" />
    </form>
</fieldset>
</body>
</html>
