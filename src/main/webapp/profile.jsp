<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>

<jsp:include page="header.jsp"/>

<div class="container">
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

</div>

<jsp:include page="footer.jsp"/>