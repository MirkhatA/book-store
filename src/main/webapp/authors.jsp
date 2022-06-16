<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>

<div class="container">
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        <c:forEach var="author" items="${sessionScope.authors}">
            <tr>
                <th>${author.id}</th>
                <th>${author.fullName}</th>
            </tr>
        </c:forEach>

    </table>
</div>

<jsp:include page="footer.jsp"/>