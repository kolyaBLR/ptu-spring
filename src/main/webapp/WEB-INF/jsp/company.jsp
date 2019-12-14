<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="create" var="createCompanyUrl"/>
<body>
<div class="container">
    <h2>${action_name} новую компанию</h2>
    <form:form method="post" action="${createCompanyUrl}" modelAttribute="company">
        <div class="form-group">
            <form:label path="name">Название</form:label>
            <form:input path="name" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="name" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="cost">Стоимость</form:label>
            <form:input path="cost" type="number" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="cost" element="div" class="invalid-feedback"/>
            <form:hidden path="id"/>
        </div>
        <button class="btn btn-success" type="submit">${action_name}!</button>
    </form:form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
