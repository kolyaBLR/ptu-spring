<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
    <h2>Проекты:</h2>
    <table>
        <c:forEach var="project" items="${projects}">
            <spring:url var="projectUrl" value="/project/${project.id}"/>
            <tr><td><a class="btn btn-outline-dark" href="${projectUrl}">${project.namedItem.name}</a></td></tr>
        </c:forEach>
    </table>
    <spring:url value="/home" var="homeUrl" />
    <a href="${homeUrl}">Главная</a>
</body>
</html>