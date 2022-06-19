<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>

<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="/showAllOrdersService">
                            <span data-feather="file" class="align-text-bottom"></span>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="shopping-cart" class="align-text-bottom"></span>
                            Cart
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/showProfileService">
                            <span data-feather="users" class="align-text-bottom"></span>
                            Profile
                        </a>
                    </li>
                </ul>

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
                    <span>Personal data</span>
                    <a class="link-secondary" href="#" aria-label="Add a new report">
                        <span data-feather="plus-circle" class="align-text-bottom"></span>
                    </a>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text" class="align-text-bottom"></span>
                            Change password
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2><fmt:message key="label.personalPage"/></h2>

            <form action="updateUserDataService" method="post">
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
                <c:if test="${requestScope.profileSuccessfullyUpdated != null}">
                    <div class="alert alert-success" role="alert">
                        Profile updated successfully!
                    </div>
                </c:if>

                <div class="mb-3">
                    <label for="emailInput" class="form-label">Email</label>
                    <input name="email" type="email" class="form-control" id="emailInput" value="${sessionScope.email}">
                </div>

                <div class="mb-3">
                    <label for="firstNameInput" class="form-label">First Name</label>
                    <input name="firstName" type="text" class="form-control" id="firstNameInput"
                           value="${sessionScope.firstName}">
                </div>

                <div class="mb-3">
                    <label for="lastNameInput" class="form-label">Last Name</label>
                    <input name="lastName" type="text" class="form-control" id="lastNameInput" value="${sessionScope.lastName}">
                </div>

                <div class="mb-3">
                    <label for="addressInput" class="form-label">Address</label>
                    <input name="address" type="text" class="form-control" id="addressInput" value="${sessionScope.address}">
                </div>

                <div class="mb-3">
                    <label for="mobileInput" class="form-label">Mobile</label>
                    <input name="phoneNo" type="text" class="form-control" id="mobileInput" value="${sessionScope.mobile}">
                </div>

                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form>
        </main>

    </div>
</div>

<jsp:include page="footer.jsp"/>