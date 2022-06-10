<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container mt-5">
    <div class="row">
        <form action="userRegister" method="post">
            <div class="mb-3 row">
                <label for="name" class="col-sm-2 col-form-label">Имя</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="firstName" id="name">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="email" id="email">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="phoneNo" class="col-sm-2 col-form-label">Телефон</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="phoneNo" id="phoneNo">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="password" class="col-sm-2 col-form-label">Пароль</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" id="password">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Зарегестрироваться</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>