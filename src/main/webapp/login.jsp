<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container mt-5">
    <div class="row">
        <form action="userLogin" method="post">
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label">Email или телефон</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="login" id="email">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="password">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Логин</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>