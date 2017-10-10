<%@ page import="pl.sdacademy.user.User" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    out.println(user);
%>
</body>
</html>
