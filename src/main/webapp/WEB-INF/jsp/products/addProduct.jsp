<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
<div class="container">
    <form:form method="post" action="" modelAttribute="enterpriseProductModel">
        <div class="input-group">
            <form:label path="">Продукт</form:label>
            <form:select path="enterpriseProductPK.product.productId" class="form-control" cssErrorClass="form-control is-invalid">
                <c:forEach var="product" items="${products}">
                    <form:option value="${product.productId}">${product.namedItem.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="input-group">
            <form:label path="amount">Количество</form:label>
            <form:input path="amount" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="amount" element="div" class="invalid-feedback"/>
        </div>
        <div class="input-group">
            <form:label path="cost">Цена 1 шт:</form:label>
            <form:input path="cost" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="cost" element="div" class="invalid-feedback"/>
        </div>

        <button type="submit">Добавить!</button>
    </form:form>
    <spring:url value="/home" var="homeUrl" />
    <a href="${homeUrl}">Главная</a>
</div>
</body>
</html>