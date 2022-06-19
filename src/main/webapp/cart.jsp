<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Корзина</h1>

    <form action="" method="post">
        <table class="table table-striped">
            <tr>
                <th>book id</th>
                <th>quantity</th>
            </tr>

            <c:forEach var="cart" items="${sessionScope.cartList}">
                <tr>
                    <td>${cart.bookName}</td>
                    <td>
                        <a href="/addToCartService?id=${cart.bookId}">+</a>
                        <b>${cart.quantity}</b>
                        <a href="/removeFromCartService?id=${cart.bookId}">-</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <button type="submit" class="btn btn-primary">Оформить заказ</button>
    </form>


</div>

<jsp:include page="footer.jsp"/>