<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="fragments/head.jsp"/>
<body>
    <jsp:include page="fragments/header.jsp"/>
    <p>
        <spring:url var="regUrl" value="/register"/>
        <spring:url var="logUrl" value="/login"/>
        <spring:url var="projUrl" value="/projects"/>
        <spring:url var="prodUrl" value="/products"/>
        <spring:url var="enterprisesUrl" value="/enterprises"/>
        <a class="btn btn-primary" href="${regUrl}">Регистрация</a>
        <a class="btn btn-primary" href="${logUrl}">Вход</a>
        <a class="btn btn-primary" href="${projUrl}">Проекты</a>
        <a class="btn btn-primary" href="${prodUrl}">Продукты</a>
        <a class="btn btn-primary" href="${enterprisesUrl}">Предприятия</a>
    </p>
    <br/>
    <h2>Интересные проекты:</h2>
    <ul>
        <c:forEach var="project" items="${topProjects}">
            <c:url var="projectUrl" value="/project/${project.id}"/>
            <li><a href="${projectUrl}">${project.namedItem.name}</a></li>
        </c:forEach>
    </ul>

</body>
</html>
