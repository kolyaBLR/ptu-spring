<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="/company/create" var="createCompanyUrl"/>
<body>
<div class="container">
    <h2>Ваша компания <a href="${createCompanyUrl}/${companyModel.company.id}">${companyModel.company.name}</a> стоит ${companyModel.company.cost}</h2>

    <h3>companyInfo</h3>
    <div class="form-group">
        <div>amortizationDeduction ${companyModel.companyInfo.amortizationDeduction}</div>
        <div>assets ${companyModel.companyInfo.assets}</div>
        <div>capital ${companyModel.companyInfo.capital}</div>
        <div>cleanProfit ${companyModel.companyInfo.cleanProfit}</div>
        <div>dues ${companyModel.companyInfo.dues}</div>
    </div>

    <h3>employee</h3>
    <div class="form-group">
        <div>middleSalaryForUnit ${companyModel.employee.middleSalaryForUnit}</div>
        <div>positionName ${companyModel.employee.positionName}</div>
        <div>quantity ${companyModel.employee.quantity}</div>
        <div>dues ${companyModel.companyInfo.dues}</div>
    </div>

    <h3>equipment</h3>
    <div class="form-group">
        <div>quantity ${companyModel.equipment.quantity}</div>
        <div>name ${companyModel.equipment.name}</div>
        <div>amortizationCostOfUnit ${companyModel.equipment.amortizationCostOfUnit}</div>
        <div>costOfUnit ${companyModel.equipment.costOfUnit}</div>
    </div>

    <h3>placement</h3>
    <div class="form-group">
        <div>costOfUnit ${companyModel.placement.costOfUnit}</div>
        <div>name ${companyModel.placement.name}</div>
        <div>quantity ${companyModel.placement.quantity}</div>
        <div>rentPriceForYear ${companyModel.placement.rentPriceForYear}</div>
    </div>

    <h3>product</h3>
    <div class="form-group">
        <div>costOfUnit ${companyModel.product.costOfUnit}</div>
        <div>costRawForUnit ${companyModel.product.costRawForUnit}</div>
        <div>nameProduct ${companyModel.product.nameProduct}</div>
        <div>numOfReleaseOf ${companyModel.product.numOfReleaseOf}</div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
