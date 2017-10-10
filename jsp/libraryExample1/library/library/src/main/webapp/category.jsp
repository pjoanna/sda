<%@ page import="pl.sda.library.Category" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>

<c:choose>
    <c:when test="${param.action eq 'add'}">
        <% addCategory(request, session); %>
    </c:when>
    <c:when test="${param.action eq 'edit'}">
        <% editCategory(request, session); %>
    </c:when>
    <c:when test="${param.action eq 'remove'}">
        <% removeCategory(request, session); %>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${param.view eq 'list'}">
        <jsp:forward page="category/category_list.jsp"></jsp:forward>
    </c:when>
    <c:when test="${param.view eq 'add_form'}">
        <jsp:forward page="category/category_add_form.jsp"></jsp:forward>
    </c:when>
    <c:when test="${param.view eq 'edit_form'}">
        <jsp:forward page="category/category_edit_form.jsp"></jsp:forward>
    </c:when>
    <c:otherwise>
        <jsp:forward page="category/category_list.jsp"></jsp:forward>
    </c:otherwise>
</c:choose>

</body>
</html>
<%!
    private void addCategory(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        Category category = new Category(name);
        Map<Integer, Category> categories = (Map<Integer, Category>) session.getAttribute("categories");
        if (categories == null) {
            categories = new HashMap<>();
        }
        categories.put(category.getId(), category);
        session.setAttribute("categories", categories);
    }

    private void editCategory(HttpServletRequest request, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Map<Integer, Category> categories = (Map<Integer, Category>) session.getAttribute("categories");
        if (categories == null) {
            categories = new HashMap<>();
        }
        Category category = categories.get(id);
        category.setName(name);
        session.setAttribute("categories", categories);
    }

    private void removeCategory(HttpServletRequest request, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("id"));
        Map<Integer, Category> categories = (Map<Integer, Category>) session.getAttribute("categories");
        if (categories == null) {
            categories = new HashMap<>();
        }
        Category category = categories.remove(id);
        session.setAttribute("categories", categories);
    }
%>