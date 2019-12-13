<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/head.jsp"/>
<body>
    <table>
        <tr>
            <td>Проект: ${project.namedItem.name}</td>
        </tr>
        <tr>
            <td>Описание: ${project.namedItem.description}</td>
        </tr>
        <tr>
            <td>
                <div class="progress"> Люди:
                    <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <div class="progress"> Ресурсы:
                    <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
                <div class="progress"> Деньги:
                    <div class="progress-bar bg-warning" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </td>
        </tr>
        <tr>
            <td>Количество подписчиков: ${project.followers.size()} &nbsp;
                <c:if test="${currentUser != null && !project.followers.contains(currentUser)}">
                    <c:url var="followUrl" value="/project/${project.id}/follow"/>
                    <a class="btn btn-success" href="${followUrl}">Отслеживать</a>
                </c:if>
                <c:if test="${currentUser != null && project.followers.contains(currentUser)}">
                    <c:url var="unfollowUrl" value="/project/${project.id}/unfollow"/>
                    <a class="btn btn-danger" href="${unfollowUrl}">Не отслеживать</a>
                </c:if>
            </td>
        </tr>
    </table>
    <c:if test="${currentUser != null && currentUser.type.equals(\"admin\")}">
        <div>
            <c:url var="placeUrl" value="/project/${project.id}/place/"/>
            <button class="btn btn-warning" onclick="window.location='${placeUrl}' + document.getElementById('place').value">Разместить на главной странице на позиции: </button>
            <select id="place">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
        </div>
    </c:if>
    <div>
        QR code: <img src="https://api.qrserver.com/v1/create-qr-code/?data=${requestScope['javax.servlet.forward.request_uri']}&amp;size=100x100" alt="QR"/>
    </div>
    <spring:url value="/home" var="homeUrl" />
    <a href="${homeUrl}">Главная</a>
</body>
</html>