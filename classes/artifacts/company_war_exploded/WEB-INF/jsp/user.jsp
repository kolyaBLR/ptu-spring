<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spting" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>
    <c:if test="${user != null && ban == null}">
        <table>
            <tr>
                <td>Пользователь: ${user.login} &nbsp;
                    <c:if test="${currentUser}">
                        <c:url var="logoutUrl" value="/logout"/>
                        <a class="btn btn-info" href="${logoutUrl}">Выход из аккаунта</a>
                    </c:if>
                    <c:if test="${(!user.type.equals(\"admin\") && !user.type.equals(\"moderator\") && currentUserObj.type.equals(\"moderator\")) || (!user.type.equals(\"admin\") && currentUserObj.type.equals(\"admin\"))}">
                        <c:url var="banUrl" value="/user/${user.login}/ban"/>
                        <a class="btn btn-danger" href="${banUrl}">Бан</a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>ФИО: ${user.namedItem.name}</td>
            </tr>
            <tr>
                <td>Отслеживаемые проекты:
                    <ul>
                        <c:forEach var="project" items="${user.followedProjects}">
                            <c:url var="projectUrl" value="/project/${project.id}"/>
                            <li><a href="${projectUrl}">${project.namedItem.name}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </table>
        <c:if test="${currentUser && user.type.equals(\"user\")}">
            <spring:url value="/projects/create" var="createProjectUrl"/>
            <a class="btn btn-primary" href="${createProjectUrl}">Создать проект</a>
        </c:if>
        <c:if test="${currentUser && user.type.equals(\"enterpreneur\")}">
            <spring:url value="/enterprise/create" var="createEnterpriseUrl"/>
            <a class="btn btn-primary" href="${createEnterpriseUrl}">Добавить предприятие</a>
            <p>Мои предриятия:</p>
            <ul>
                <c:forEach var="enterprise" items="${enterprises}">
                    <c:url var="enterpriseUrl" value="/enterprise/${enterprise.registrationId}"/>
                    <li><a href="${enterpriseUrl}">${enterprise.namedItem.name}</a></li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${currentUser && user.type.equals(\"admin\")}">
            <spting:url value="/admin/createModer" var="createModer"/>
            <a class="btn btn-primary" href="${createModer}">Создать нового модератора</a>
        </c:if>
        <c:if test="${currentUser && user.type.equals(\"moderator\")}">
            <h2>Подтверждение запросов на добавление предприятия</h2>
            <table class="table">
                <tr>
                    <th scope="col">Название</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Регистрационный номер</th>
                    <th scope="col">Владелец</th>
                    <th scope="col">Подтвердить</th>
                    <th scope="col">Удалить</th>
                </tr>
                <c:forEach var="enterpise" items="${notApprovedEnterprises}">
                    <c:url var="enterpriseUrl" value="/enterprise/${enterpise.registrationId}"/>
                    <c:url var="approveUrl" value="/enterprise/${enterpise.registrationId}/approve"/>
                    <c:url var="deleteUrl" value="/enterprise/${enterpise.registrationId}/delete"/>
                    <c:url var="ownerUrl" value="/user/${enterpise.owner.login}"/>
                    <tr>
                        <td><a href="${enterpriseUrl}">${enterpise.namedItem.name}</a></td>
                        <td>${enterpise.namedItem.description}</td>
                        <td>${enterpise.registrationId}</td>
                        <td><a href="${ownerUrl}">${enterpise.owner.namedItem.name}</a></td>
                        <td><a href="${approveUrl}" class="btn btn-success">Подтвердить</a></td>
                        <td><a href="${deleteUrl}" class="btn btn-danger">Удалить</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </c:if>
    <c:if test="${user == null}">
        <h2>Такого пользователя не существует</h2>
    </c:if>
    <c:if test="${ban != null}">
        <h2>Пользователь заблокирован по причине: ${ban.reason}</h2>
    </c:if>
    <br/>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>