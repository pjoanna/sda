<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ciasteczka</title>
</head>
<body>
    <% Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " " + cookie.getValue()+"<br/>");
        }

        String login = request.getParameter("login");
        if (!(login == null)  &&  !login.isEmpty()){
            Cookie cookie = new Cookie("login_cookie", login);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }

        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " " + cookie.getValue()+"<br/>");
        }



    %>
</body>
</html>
