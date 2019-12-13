<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
    <div class="container">
        <form:form method="post" action="" modelAttribute="productModel">
        <div class="input-group">
            <form:label path="namedItem.name">Названиие</form:label>
            <form:input path="namedItem.name" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="namedItem.name" element="div" class="invalid-feedback"/>
        </div>
        <div class="input-group">
            <form:label path="namedItem.description">Описание</form:label>
                <form:textarea path="namedItem.description" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="namedItem.description" element="div" class="invalid-feedback"/>
            </div>

                <button type="submit">Создать!</button>
                </form:form>
            <spring:url value="/home" var="homeUrl" />
            <a href="${homeUrl}">Главная</a>
    </div>
</body>
</html>