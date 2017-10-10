<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista kategorii</title>
</head>
<body>
<%@include file="../common/menu.jspf" %>
<fieldset>
<legend>Lista kategorii</legend>
<c:choose>
    <c:when test="${empty categories}">
        <b style="color: red"><c:out value="Brak kategorii"/></b>
    </c:when>
    <c:otherwise>
        <table border="0">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>akcja</th>
            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td><c:out value="${category.value.id}"></c:out></td>
                    <td><c:out value="${category.value.name}"></c:out></td>
                    <td>
                        <a href="<c:url value="../category.jsp"><c:param name="id" value="${category.value.id}" /><c:param name="view" value="edit_form"/></c:url>">edytuj</a>
                        <a href="<c:url value="../category.jsp"><c:param name="id" value="${category.value.id}" /><c:param name="action" value="remove"/></c:url>">usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<p>
    <a href="<c:url value="../category.jsp"><c:param name="view" value="add_form"/></c:url>">Dodaj kategorię</a>
</p>
</fieldset>
</body>
</html>
