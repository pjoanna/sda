<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dodawanie kategorii</title>
</head>
<body>
<%@include file="../common/menu.jspf"%>
<fieldset>
<legend>Dodawanie kategorii</legend>
<form action="<c:url value="../category.jsp"/>" method="post">
    <input type="hidden" name="action" value="add" />
    <input type="text" name="name" value="" /><br />
    <input type="submit" name="submit" value="dodaj" />
</form>
</fieldset>
</body>
</html>
