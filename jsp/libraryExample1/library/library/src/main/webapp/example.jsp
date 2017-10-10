<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.sda.library.Category" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="pl.sda.library.Author" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="pl.sda.library.Book" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Example - remove after reading :)</title>
</head>
<body>
<fieldset>
    <legend>Demo</legend>
    <%
        Category poezja = new Category("Poezja");
        Category proza = new Category("Proza");
        Category dramat = new Category("Dramat");

        Map<Integer, Category> categories = new HashMap<>();
        categories.put(poezja.getId(), poezja);
        categories.put(proza.getId(), proza);
        categories.put(dramat.getId(), dramat);

        Author mickiewicz = new Author("Adam", "Mickieiwcz");
        Author brzechwa = new Author("Jan", "Brzechwa");
        Author slowacki = new Author("Juliusz", "Słowacki");
        Author sienkiewicz = new Author("Henryk", "Sienkiewicz");
        Author norwid = new Author("Cyprian", "Norwid");
        Author coehlo = new Author("Paulo", "Coehlo");

        Map<Integer, Author> authors = new HashMap<>();
        authors.put(mickiewicz.getId(), mickiewicz);
        authors.put(brzechwa.getId(), brzechwa);
        authors.put(slowacki.getId(), slowacki);
        authors.put(sienkiewicz.getId(), sienkiewicz);
        authors.put(norwid.getId(), norwid);
        authors.put(coehlo.getId(), coehlo);

        Set<Author> authorsOfMrTed = new HashSet<>();
        authorsOfMrTed.add(mickiewicz);
        authorsOfMrTed.add(coehlo);

        Book mrTed = new Book("Pan Tadeusz", poezja, authorsOfMrTed, 1812);

        request.setAttribute("categories", categories);
        request.setAttribute("authors", authors);
        request.setAttribute("book", mrTed);
    %>

    <form>
        <table border="0">
            <tr>
                <input type="hidden" name="id" value="${book.id}"/>
                <td>Tytuł:</td>
                <td><input type="text" name="title" value="${book.title}"/></td>
            </tr>
            <tr>
                <td>Kategoria:</td>
                <td><select name="category">
                    <c:forEach items="${categories}" var="category">
                        <c:set var="selected" value=""/>
                        <c:if test="${category.value.id eq book.category.id}">
                            <c:set var="selected" value="selected='selected'"/>
                        </c:if>
                        <option value="${category.value.id}" ${selected}>${category.value.name}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td>Autorzy:</td>
                <td>
                    <c:forEach items="${authors}" var="author">
                        <c:set var="checked" value=""/>
                        <c:forEach items="${book.authors}" var="bookAuthors">
                                <c:if test="${author.value.id eq bookAuthors.id}">
                                    <c:set var="checked" value="checked='checked'"/>
                                </c:if>
                        </c:forEach>
                        <input type="checkbox" name="authors" value="${author.value.id}" ${checked}> ${author.value.name} ${author.value.surname} <br/>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>Rok wydania:</td>
                <td><input type="text" name="year" value="${book.year}"/> </td>
            </tr>
        </table>
    </form>
</fieldset>

<fieldset>
    <legend>Debug</legend>
    <%=mrTed%>
</fieldset>
</body>
</html>
