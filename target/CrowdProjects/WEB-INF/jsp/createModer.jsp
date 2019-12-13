<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <jsp:include page="fragments/head.jsp"/>
<body>
    <div class="container">
        <h2>Создание нового модератора</h2>
        <form:form method="post" action="" modelAttribute="userModel">
            <div class="form-group">
                <form:label path="password.login">Логин</form:label>
                <form:input path="password.login" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="password.login" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="password.password">Пароль</form:label>
                <form:input path="password.password" type="password" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="password.password" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="email">Почта</form:label>
                <form:input path="email" type="email" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="email" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="namedItem.name">Имя</form:label>
                <form:input path="namedItem.name" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="namedItem.name" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="surname">Фамилия</form:label>
                <form:input path="surname" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="surname" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="birthDay">День рождения</form:label>
                <form:input path="birthDay" type="datetime-local" class="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="birthDay" element="div" class="invalid-feedback"/>
            </div>
            <div class="form-group">
                <form:label path="type">Тип пользователя</form:label>
                <form:select path="type" class="form-control" cssErrorClass="form-control is-invalid">
                    <form:option value="moderator">Модератор</form:option>
                </form:select>
                <form:errors path="type" element="div" class="invalid-feedback"/>
            </div>

            <button class="btn btn-success" type="submit">Регистрация!</button>
        </form:form>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
