<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="/logout" var="logoutUrl"/>
<spring:url value="company/create" var="createCompanyUrl"/>
<spring:url value="company/show" var="showCompanyUrl"/>
<spring:url value="/files" var="fileUrl"/>
<head>
    <script type="text/javascript">
        ${graphScript}

        ${usersGraphScript}
    </script>
</head>
<body>
<div class="container">
    <div>
        <h2>Привет ${activeUser.login} <a href="${createCompanyUrl}">add company</a></h2>
        <div align="right"><a href="${logoutUrl}">logout</a></div>
    </div>
    <h3>Мои компании</h3>
    <table>
        <jsp:useBean id="companies" scope="request" type="java.util.List"/>
        <c:forEach var="company" items="${companies}">
            <tr>
                <form:form method="post" action="home" modelAttribute="company">
                    <td>
                        <a href="${showCompanyUrl}/${company.id}">${company.name}</a> стоит ${company.cost}
                    </td>
                    <td>
                        <a href="${fileUrl}/${company.id}">Скачать файлом</a>
                    </td>
                    <td>
                        <input type="submit" value="удалить"/>
                    </td>
                    <input name="id" value="${company.id}" type="hidden"/>
                </form:form>
            </tr>
        </c:forEach>
    </table>
    <h3>Все компании</h3>
    <table>
        <c:forEach var="comnpany1" items="${allCompanies}">
            <tr>
                <td>
                    <div> ${comnpany1.name} </div>
                </td>
                <td>
                    <div> ${comnpany1.cost} </div>
                </td>
                <td>
                    <div> ${comnpany1.userLogin} </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3>Пользователи</h3>
    <table>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <div>-> ${user.login}</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="chart_div"></div>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
