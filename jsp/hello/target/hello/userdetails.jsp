<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userdetails</title>
</head>
<body>
    <jsp:useBean id="user" class="sda.nordea.hello.User"></jsp:useBean>
    <jsp:setProperty name="user" property="*"/>

    <p>Name: <jsp:getProperty name="user" property="name"/></p></br>
    <p>Surname: <jsp:getProperty name="user" property="surname"/></p></br>
    <p>Age: <jsp:getProperty name="user" property="age"/></p></br>
    <p>Adult: <jsp:getProperty name="user" property="adult"/></p>
</body>
</html>
