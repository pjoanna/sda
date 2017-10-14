<%@ page import="sda.spring.model.User" %>
<%@ page import="sda.spring.model.LoggedUsers" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-14
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Zalogowani użytkownicy</title>
</head>
<body>

<c:forEach items="${users}" var="user">
    <c:out value="1111"></c:out>
    <c:out value="${user}"></c:out>

</c:forEach>

<a href="home.jsp">Home</a>

</body>
</html>
