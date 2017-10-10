<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>new</title>
</head>
<body>
<h1>Witaj na stronie new</h1>
<h1>name = ${param.get("name")}</h1>
<% out.print("name = " + request.getParameter("name")); %>
<h1>
    name = <%= request.getParameter("name") %>
</h1>
</body>
</html>
