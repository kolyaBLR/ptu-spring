<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>
    <h2>Вход</h2>
    <form:form method="post" action="login" modelAttribute="loginModel">
        <table>
            <tr>
                <td><form:label path="login">Логин</form:label></td>
                <td><form:input path="login"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Пароль</form:label></td>
                <td><form:input path="password" type="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
        <spring:url value="/home" var="homeUrl" />
        <a href="${homeUrl}">Главная</a>
    </form:form>
</body>
</html>