<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"/>


<div class="container mt-5">
    <div class="row">
        <form action="userRegister" method="post">
            <c:if test="${requestScope.emailIsTaken != null}">
                <div class="alert alert-danger" role="alert">
                    Данная почта уже зарегестрирована!
                </div>
            </c:if>
            <c:if test="${requestScope.numberIsTaken != null}">
                <div class="alert alert-danger" role="alert">
                    Данный номер уже зарегестрирован!
                </div>
            </c:if>
            <div class="mb-3 row">
                <label for="name" class="col-sm-2 col-form-label">Имя</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="firstName" id="name" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="email" id="email" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="phoneNo" class="col-sm-2 col-form-label">Телефон</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="phoneNo" id="phoneNo" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="password" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Зарегестрироваться</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>