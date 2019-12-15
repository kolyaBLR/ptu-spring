<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="create" var="createCompanyUrl"/>
<body>
<div class="container">
    <h2>${action_name} компанию</h2>
    <form:form method="post" action="${createCompanyUrl}" modelAttribute="companyModel">

        <h3 class="form-group">Компания</h3>
        <div class="form-group">
            <form:label path="company.name">Название</form:label>
            <form:input path="company.name" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="company.name" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="company.cost">Стоимость</form:label>
            <form:input path="company.cost" type="number" class="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="company.cost" element="div" class="invalid-feedback"/>
        </div>

        <h3 class="form-group">Работники</h3>
        <div class="form-group">
            <form:label path="employee.positionName">Должность</form:label>
            <form:input path="employee.positionName" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="employee.positionName" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="employee.quantity">Количество</form:label>
            <form:input path="employee.quantity" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="employee.quantity" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="employee.middleSalaryForUnit">Средняя стоимость зарплаты работника</form:label>
            <form:input path="employee.middleSalaryForUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="employee.middleSalaryForUnit" element="div" class="invalid-feedback"/>
        </div>

        <h3 class="form-group">Оборудование</h3>
        <div class="form-group">
            <form:label path="equipment.name">Наименование</form:label>
            <form:input path="equipment.name" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="equipment.name" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="equipment.quantity">Количество оборудования</form:label>
            <form:input path="equipment.quantity" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="equipment.quantity" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="equipment.amortizationCostOfUnit">Стоимость поддержки оборудования</form:label>
            <form:input path="equipment.amortizationCostOfUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="equipment.amortizationCostOfUnit" element="div" class="invalid-feedback"/>
        </div>

        <div class="form-group">
            <form:label path="equipment.costOfUnit">Средняя стоимость единицы оборудования</form:label>
            <form:input path="equipment.costOfUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="equipment.costOfUnit" element="div" class="invalid-feedback"/>
        </div>

        <h3 class="form-group">Помещения</h3>
        <div class="form-group">
            <form:label path="placement.name">Наименование</form:label>
            <form:input path="placement.name" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="placement.name" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="placement.quantity">Количество помещений</form:label>
            <form:input path="placement.quantity" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="placement.quantity" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="placement.rentPriceForYear">Средняя стоимость содержания одного помещения</form:label>
            <form:input path="placement.rentPriceForYear" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="placement.rentPriceForYear" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="placement.costOfUnit">Средняя стоимость помещения</form:label>
            <form:input path="placement.costOfUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="placement.costOfUnit" element="div" class="invalid-feedback"/>
        </div>

        <h3 class="form-group">Продукт</h3>
        <div class="form-group">
            <form:label path="product.nameProduct">Наименование продукта</form:label>
            <form:input path="product.nameProduct" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="product.nameProduct" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="product.numOfReleaseOf">Количество продуктов</form:label>
            <form:input path="product.numOfReleaseOf" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="product.numOfReleaseOf" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="product.costRawForUnit">Средняя стоимость производства</form:label>
            <form:input path="product.costRawForUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="product.costRawForUnit" element="div" class="invalid-feedback"/>
        </div>
        <div class="form-group">
            <form:label path="product.costOfUnit">Доход с реализации одного продукта</form:label>
            <form:input path="product.costOfUnit" type="number" class="form-control"
                        cssErrorClass="form-control is-invalid"/>
            <form:errors path="product.costOfUnit" element="div" class="invalid-feedback"/>
        </div>


        <form:hidden path="company.id"/>
        <button class="btn btn-success" type="submit">${action_name}!</button>
    </form:form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
