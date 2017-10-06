<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-06
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>counter</title>
</head>
<body>
    <%! private long visitCount = 0; %>
    <% visitCount++; %>
    <%-- komentarz jsp --%>
    <!-- komentarz html -->
    <h2>Ilość odwiedzin strony:
    <%
        out.print(visitCount);
    %>
    </h2>

    <h1>  ${cookie.get("JSESSIONID").name}</h1>
    <h1> ${cookie.get("JSESSIONID").value}</h1>
    <h1>  ${cookie.get("JSESSIONID").domain}</h1>
    <h1> ${cookie.get("JSESSIONID").maxAge}</h1>
    <h1> ${header.get("User-Agent").length()}</h1>

</body>
</html>
