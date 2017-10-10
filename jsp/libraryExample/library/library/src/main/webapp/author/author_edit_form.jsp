<%--
  Created by IntelliJ IDEA.
  User: pjoanna
  Date: 2017-10-10
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja autora</title>
</head>
<body>
<%@include file="../common/menu.jspf" %>
<fieldset>
    <legend>Edycja autora</legend>
    <form action="<c:url value="../author.jsp"/>" method="post">
        <input type="hidden" name="action" value="edit_author" />
        <input type="hidden" name="id" value="${param.id}" />
        <input type="text" name="name" value="${authors[Integer.valueOf(param.id)].name}" /><br />
        <input type="text" name="surname" value="${authors[Integer.valueOf(param.id)].surname}" /><br />
        <input type="submit" name="submit" value="edytuj" />
    </form>
</fieldset>
</body>
</html>
