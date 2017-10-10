<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-10-07
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Parametry szukania</h2>
<form action="search.jsp" method="post">
    <p>
        Szukane słowo: <input type="text" value="word"><br/>
        Strona: <input type="text" value="page"><br/>
        Sortowanie:
        <select name="sort">
            <option value="asc">rosnąco</option>
            <option value="desc">malejąco</option>
        </select><br/>

        <input type="submit" name="submit" value="start">
    </p>
</form>
</body>
</html>
