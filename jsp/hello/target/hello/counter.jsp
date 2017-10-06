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
<h1>
    ${cookie.get("JSESSIONID").name}
    ${cookie.get("JSESSIONID").value}</br>
    ${cookie.get("JSESSIONID").domain}</br>
    ${cookie.get("JSESSIONID").maxAge}
</h1>
</body>
</html>
