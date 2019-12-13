<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
    <table>
        <tr>
            <td>Продукт: ${product.namedItem.name}</td>
        </tr>
        <tr>
            <td>Описание: ${product.namedItem.description}</td>
        </tr>
    </table>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>