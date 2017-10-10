<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
    <%
        String loginFromURL = request.getParameter("login");
        out.print(loginFromURL);
        out.print("<br/>");

        String loginFromSeession = (String) session.getAttribute("login");
        out.print(loginFromSeession);
        out.print("<br/>");

        session.setAttribute("login",loginFromURL);

        String loginFromSeession2 = (String) session.getAttribute("login");
        out.print(loginFromSeession2);
        out.print("<br/>");

    %>
</body>
</html>
