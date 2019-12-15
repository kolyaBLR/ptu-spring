<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<spring:url value="/logout" var="logoutUrl"/>
<spring:url value="company/create" var="createCompanyUrl"/>
<spring:url value="company/show" var="showCompanyUrl"/>
<body>
<div class="container">
    <div>
        <h2>Привет ${user.login}</h2>
        <div align="right"><a href="${logoutUrl}">logout</a></div>
    </div>
    <div><a href="${createCompanyUrl}">add company</a></div>
    <table>
        <jsp:useBean id="companies" scope="request" type="java.util.List"/>
        <c:forEach var="company" items="${companies}">
            <tr>
                <form:form method="post" action="home" modelAttribute="company">
                    <td>
                        <div><a href="${showCompanyUrl}/${company.id}">${company.name}</a> стоит ${company.cost}</div>
                        <input name="id" value="${company.id}" type="hidden"/>
                        <input type="submit" value="удалить"/>
                    </td>
                </form:form>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
