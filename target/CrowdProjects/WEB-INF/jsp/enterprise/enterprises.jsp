<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
<h2>Предприятия:</h2>
<table>
    <c:forEach var="enterprise" items="${enterprises}">
        <spring:url var="projectUrl" value="/enterprise/${enterprise.registrationId}"/>
        <tr><td><a class="btn btn-outline-dark" href="${projectUrl}">${enterprise.namedItem.name}</a></td></tr>
    </c:forEach>
</table>
<spring:url value="/home" var="homeUrl" />
<a href="${homeUrl}">Главная</a>
</body>
</html>