<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>formularz</title>
</head>
<body>
<jsp:useBean id="user" class="sda.nordea.hello.User"/>
<form action="userdetails.jsp" method="post">
    <p>Name</p> </br>
    <input name="name"> </br>

    <p>Surname</p> </br>
    <input type="text" name="surname"> </br>

    <p>Age</p> </br>
    <input name="age"> </br>

    <input type="submit" value="details">
</form>
</body>
</html>
