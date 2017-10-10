<%@ page import="java.time.LocalDate" pageEncoding="utf-8" isELIgnored="false" %>
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

    <c:out value="wyświetlam cokolwiek"></c:out>

    <c:if test="${5<7}">
        <c:out value="prawda"></c:out>
    </c:if>
    </br>
    <%--<c:import var="data" url="http://hapacz.pl"/>--%>
    <%--<c:out value="${data}"/>--%>

    <c:catch var="catchtheException">
            <% int x = 2/0;%>
    </c:catch>

    <c:if test="${catchtheException != null}">
<p>The type of exception is : ${catchtheException} <br/>
    There is an exception: ${catchtheException.message}</p>
</c:if>

<c:forEach var="j" begin="1" end="3">
Item <c:out value="${j}"/><p>
    </c:forEach>

</p>

<%@ include file="footer.jspf" %>
</body>
</html>
