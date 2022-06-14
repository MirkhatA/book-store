<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<fmt:setLocale value="${sessionScope.language}"/>

<div class="container">

    <h1><fmt:message key="label.welcomeTitle"/></h1>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Image</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>author_id</th>
            <th>publisher_id</th>
            <th>language_id</th>
        </tr>

        <c:forEach var="book" items="${sessionScope.books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.image}</td>
                <td>${book.quantity}</td>
                <td>${book.price}</td>
                <td>${book.authorId}</td>
                <td>${book.publisherId}</td>
                <td>${book.languageId}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="footer.jsp"/>