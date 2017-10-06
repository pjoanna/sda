<%@ page import="java.time.LocalDate" pageEncoding="utf-8" %>
<%@page language="java" contentType="text/html" %>
<%--<html>--%>
<%--<head>--%>
<%--<title><h1>Hello World!</h1></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>--%>
<%--<%--%>
<%--String name = request.getParameter("name");--%>
<%--String timesString = request.getParameter("times");--%>
<%--Integer times = Integer.parseInt(timesString);--%>
<%--String hello = "Hello";--%>
<%--String word;--%>
<%--if (times == 0){--%>
<%--times = 1;--%>
<%--}else {--%>
<%--times = Math.abs(times);--%>
<%--}--%>
<%--for (int i = 0; i < times; i++) {--%>

<%--if (name == null || name.equals("")) {--%>
<%--word = "World";--%>
<%--} else {--%>
<%--word = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();--%>
<%--}--%>
<%--out.println(hello + ", " + word + "!");--%>
<%--out.print("</br>");--%>
<%--}--%>


<%--%></h1>--%>


<%--</body>--%>
<%--</html>--%>

<html>
<head>
    <title>dzisiaj jest... </title>
</head>
<body>
<%@ include file="header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
    Dzisiaj jest: <%= LocalDate.now().toString() %>

</p>

<%@ include file="footer.jspf" %>
</body>
</html>
