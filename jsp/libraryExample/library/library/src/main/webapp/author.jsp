<%@ page import="pl.sda.library.Author" isELIgnored="false" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>Autorzy</head>
<body>
<c:choose>
    <c:when test="${param.action eq 'add_author'} ">
        <%
            addAuthor(request, session);
        %>
    </c:when>
    <c:when test="${param.action eq 'edit_author'}">
        <%
            editAuthor(request, session);
        %>
    </c:when>
    <c:when test="${param.action eq 'remove_author'}">
        <%
            removeAuthor(request, session);
        %>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${param.view eq 'list_author'}">
        <jsp:forward page="author/author_list.jsp"></jsp:forward>
    </c:when>
    <c:when test="${param.view eq 'add_author'}">
        <jsp:forward page="author/author_add_form.jsp"></jsp:forward>
    </c:when>
    <c:when test="${param.view eq 'edit_author'}">
        <jsp:forward page="author/author_edit_form.jsp"></jsp:forward>
    </c:when>
    <c:otherwise>
        <jsp:forward page="author/author_list.jsp"></jsp:forward>
    </c:otherwise>

</c:choose>

</body>
</html>
<%!
    public void addAuthor(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Author author = new Author(name, surname);
        Map<Integer, Author> authors = (Map<Integer, Author>) session.getAttribute("authors");
        if (authors == null) {
            authors = new HashMap<>();
        }
        authors.put(author.getId(), author);
        session.setAttribute("authors", authors);
    }

    public void editAuthor(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Author author = new Author(name, surname);
        Integer id = Integer.parseInt(request.getParameter("id"));
        author.setId(id);
        Map<Integer, Author> authors = (Map<Integer, Author>) session.getAttribute("authors");
        authors.put(author.getId(), author);
        session.setAttribute("authors", authors);
    }

    public void removeAuthor(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Author author = new Author(name, surname);
        Map<Integer, Author> authors = (Map<Integer, Author>) session.getAttribute("authors");
        authors.remove(author.getId());
        session.setAttribute("authors", authors);
    }
%>