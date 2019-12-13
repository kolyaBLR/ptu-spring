<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="fragments/head.jsp"/>
<body>
<div class="container">
    <form:form method="post" action="" modelAttribute="banModel">
        <div class="input-group">
            <form:label path="reason">Причина бана:</form:label>
            <form:textarea path="reason" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="reason" element="div" class="invalid-feedback"/>
        </div>

        <button class="btn btn-danger" type="submit">Бан!</button>
    </form:form>
    <spring:url value="/home" var="homeUrl" />
    <a href="${homeUrl}">Главная</a>
</div>
</body>
</html>