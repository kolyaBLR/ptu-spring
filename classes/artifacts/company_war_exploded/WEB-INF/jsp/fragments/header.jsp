<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-light bg-light">
    <spring:url value="/home" var="homeUrl"/>
    <spring:url value="/login" var="loginUrl"/>
    <spring:url value="/user/${currentUser.login}" var="userUrl"/>
    <a class="navbar-brand" href="${homeUrl}">Крауд-проекты</a>
    <c:if test="${currentUser == null}">
        <a class="btn btn-outline-primary my-2 my-lg-0" role="button" href="${loginUrl}">Вход &nbsp;<i class="fas fa-sign-in-alt"></i></a>
    </c:if>
    <c:if test="${currentUser != null}">
        <a class="btn btn-outline-primary my-2 my-lg-0" role="button" href="${userUrl}">${currentUser.namedItem.name} &nbsp;<i class="fas fa-sign-in-alt"></i></a>
    </c:if>
</nav>