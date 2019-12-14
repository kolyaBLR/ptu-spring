<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>
    <div class="container">
        <h2>Регистрация нового пользователя</h2>
        <form:form method="post" action="register" modelAttribute="userModel">
            <div class="form-group">
                <form:label path="login">Логин</form:label>
                <form:input path="login" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="login" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="password">Пароль</form:label>
                <form:input path="password" type="password" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="password" element="div" class="invalid-feedback"/>
            </div>
            <button class="btn btn-success" type="submit">Регистрация!</button>
        </form:form>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
