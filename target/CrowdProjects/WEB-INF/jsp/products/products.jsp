<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="../fragments/head.jsp"/>
<body>
    <spring:url value="/products/create" var="createProductUrl"/>
    <a class="btn btn-primary" href="${createProductUrl}">Создать продукт</a>
    <h2>Продукты:</h2>
    <table>
        <c:forEach var="product" items="${products}">
            <spring:url var="prodUrl" value="/product/${product.productId}"/>
            <tr><td><a class="btn btn-outline-dark" href="${prodUrl}">${product.namedItem.name}</a></td></tr>
        </c:forEach>
    </table>
    <spring:url value="/home" var="homeUrl" />
    <a href="${homeUrl}">Главная</a>
</body>
</html>