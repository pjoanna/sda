<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Strona błędów</title>
</head>
<body>
<h3 style="text-align:center; color: red"><%=request.getAttribute("_ERROR")%></h3>
</body>
</html>
