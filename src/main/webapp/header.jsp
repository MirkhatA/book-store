<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="/showAllBooks">Book Store</a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="showAllGenres"><fmt:message key="label.genres"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="showAllAuthors"><fmt:message key="label.authors"/></a>
                </li>
                <c:if test="${not empty sessionScope.email}">
                    <li class="nav-item">
                        <a class="nav-link" href="/showProfileService">
                            <c:out value="${sessionScope.email}"/>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/showCartService">
                            cart
                        </a>
                    </li>
                </c:if>
                <li class="nav-item dropdown">
                    <c:if test="${not empty sessionScope.email}">
                        <a class="nav-link" href="/logoutService">
                            logout
                        </a>
                    </c:if>
                    <c:if test="${empty sessionScope.email}">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <fmt:message key="label.login"/>
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="login.jsp"><fmt:message key="label.login"/></a></li>
                            <li><a class="dropdown-item" href="registration.jsp"><fmt:message key="label.register"/></a>
                            </li>
                        </ul>
                    </c:if>
                </li>
            </ul>

            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <c:out value="${sessionScope.language}"/>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="/changeToEnglishService">English</a></li>
                        <li><a class="dropdown-item" href="/changeToRussianService">Русский</a></li>
                    </ul>
                </li>
            </ul>

            <form class="d-flex m-0" role="search">
                <input class="form-control me-2" type="search" placeholder="<fmt:message key="label.searchBook"/>"
                       aria-label="Search">
                <button class="btn btn-outline-success" type="submit"><fmt:message key="label.search"/></button>
            </form>
        </div>
    </div>
</nav>
