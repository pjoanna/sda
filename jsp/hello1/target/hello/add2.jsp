<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-10
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add2</title>
</head>
<body>
<p>add2</p>
<p>
<%
    LocalDateTime now = (LocalDateTime) request.getAttribute("now");
    out.print(now);
%>
</p>
</body>
</html>
