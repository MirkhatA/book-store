<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>

<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Корзина</h1>

    <table class="table table-striped">
        <tr>
            <th>Title</th>
            <th>Image</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>


    </table>
</div>

<jsp:include page="footer.jsp"/>