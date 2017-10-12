<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista autorów</title>
</head>
<body>
<%@include file="../common/menu.jspf" %>
<fieldset>
    <legend>Autorzy</legend>
    <c:choose>
        <c:when test="${empty authors}">
            <b style="color: red"><c:out value="Brak autorów"/></b>
        </c:when>
        <c:otherwise>
            <table border="0">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>akcja</th>
                </tr>
                <c:forEach var="author" items="${authors}">
                    <tr>
                        <td><c:out value="${author.value.id}"></c:out></td>
                        <td><c:out value="${author.value.name}"></c:out></td>
                        <td><c:out value="${author.value.surname}"></c:out></td>
                        <td>
                            <a href="<c:url value="../author.jsp">
                                <c:param name="id" value="${author.value.id}" />
                                <c:param name="view" value="edit_author_form"/>
                            </c:url>">edytuj </a>
                            <a href="<c:url value="../author.jsp">
                                <c:param name="id" value="${author.value.id}" />
                                <c:param name="action" value="remove_author"/>
                            </c:url>">usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <p>
        <a href="<c:url value="../author.jsp"><c:param name="view" value="add_author_form"/></c:url>">Dodaj autora</a>
    </p>
</fieldset>
</body>

</html>
