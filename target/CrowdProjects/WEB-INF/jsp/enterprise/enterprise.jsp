<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
    <c:if test="${enterprise != null && enterprise.approvedBy != null}">
        <table>
            <tr>
                <td>Предприятие: ${enterprise.namedItem.name}</td>
            </tr>
            <tr>
                <td>Описание: ${enterprise.namedItem.description}</td>
            </tr>
            <c:if test="${currentUser != null && currentUser.equals(enterprise.owner)}">
                <tr>
                    <c:url var="addProductUrl" value="/enterprise/${enterprise.registrationId}/addProduct"/>
                    <td><a href="${addProductUrl}" class="btn btn-primary">Добавить продукт</a></td>
                </tr>
            </c:if>
            <tr>
                <td>Продукты предприятия:
                    <ul>
                        <c:forEach var="enterpriseProduct" items="${enterpriseProducts}">
                            <c:url var="productUrl" value="/product/${enterpriseProduct.enterpriseProductPK.product.productId}"/>
                            <li><a href="${productUrl}">${enterpriseProduct.enterpriseProductPK.product.namedItem.name}</a>, цена за шт - ${enterpriseProduct.cost}, количество - ${enterpriseProduct.amount}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
        </table>
    </c:if>
    <c:if test="${enterprise == null}">
        <h2>Такого предприятия не существует</h2>
    </c:if>
    <c:if test="${enterprise != null && enterprise.approvedBy == null}">
        <h2>Это предприятие ещё не прошло проверку</h2>
    </c:if>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>