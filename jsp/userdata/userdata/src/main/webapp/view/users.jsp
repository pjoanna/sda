<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Userzy</title>
</head>
<body>
<%@include file="../jspf/message.jspf"%>
<%@include file="../jspf/menu.jspf"%>

<c:if test="${users.size() == 0}">
    Brak userów!
</c:if>
<c:forEach items="${users}" var="user">
    <a href="user.html?id=${user.getId()}"><c:out value="${user}"></c:out></a><br />
</c:forEach>
</body>
</html>
