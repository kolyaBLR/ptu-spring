<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="/company/create" var="createCompanyUrl"/>
<body>
<div class="container">
    <h2>Ваша компания <a href="${createCompanyUrl}/${companyModel.company.id}">${companyModel.company.name}</a> стоит ${companyModel.company.cost}</h2>

    <h3>Информация о компании</h3>
    <div class="form-group">
        <div>Амортизационные расходы ${companyModel.companyInfo.amortizationDeduction}</div>
        <div>Активы ${companyModel.companyInfo.assets}</div>
        <div>Капитал ${companyModel.companyInfo.capital}</div>
        <div>Чистая прибыль ${companyModel.companyInfo.cleanProfit}</div>
        <div>Налоги ${companyModel.companyInfo.dues}</div>
    </div>

    <h3>Работники</h3>
    <div class="form-group">
        <div>Средняя зарплата по должности ${companyModel.employee.middleSalaryForUnit}</div>
        <div>Должность ${companyModel.employee.positionName}</div>
        <div>Количество работников ${companyModel.employee.quantity}</div>
    </div>

    <h3>Оборудование</h3>
    <div class="form-group">
        <div>Наименование ${companyModel.equipment.name}</div>
        <div>Количество ${companyModel.equipment.quantity}</div>
        <div>Стоимость содержания ${companyModel.equipment.amortizationCostOfUnit}</div>
        <div>Стоимость оборудования${companyModel.equipment.costOfUnit}</div>
    </div>

    <h3>Помещения</h3>
    <div class="form-group">
        <div>Наименование ${companyModel.placement.name}</div>
        <div>Стоимость ${companyModel.placement.costOfUnit}</div>
        <div>Количество ${companyModel.placement.quantity}</div>
        <div>Стоимость содержания помещения${companyModel.placement.rentPriceForYear}</div>
    </div>

    <h3>Продукт</h3>
    <div class="form-group">
        <div>Название ${companyModel.product.nameProduct}</div>
        <div>Стоимость с реализации ${companyModel.product.costOfUnit}</div>
        <div>Стомость производства ${companyModel.product.costRawForUnit}</div>
        <div>Количество выпущенной продукции${companyModel.product.numOfReleaseOf}</div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
