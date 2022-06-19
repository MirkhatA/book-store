<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Корзина</h1>

    <table class="table table-striped">
        <tr>
            <th>book id</th>
            <th>quantity</th>
            <th>action</th>
        </tr>

        <c:forEach var="cart" items="${sessionScope.cartList}">
            <tr>
                <td>${cart.bookName}</td>
                <td>${cart.quantity}</td>
                <td>
                    <a href="#">Add</a>
                    <a href="#">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="footer.jsp"/>