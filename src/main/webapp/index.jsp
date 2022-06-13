<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>

<div class="container">
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Language</th>
        </tr>

        <c:forEach var="genre" items="${sessionScope.genres}">
            <tr>
                <td>${genre.id}</td>
                <td>${genre.name}</td>
                <td>${genre.languageId}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="footer.jsp"/>