<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 05/02/19
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Dodawanie klienta</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="addUser">
    <a href="/customers" class="btn btn-primary" role="button">Powrót</a>
    <c:if test="${empty customer.id}">
    <h3>Dodaj nowego klienta</h3>
        <%--<form action="/customer/save" method="post">--%>
        <%--<p>Imię: <input type="text" name="name" required/></p>--%>
        <%--<p>Naziwsko: <input type="text" name="surname" required/></p>--%>
        <%--<p>Data urodzenia: <input type="date" placeholder="YYYY-MM-DD" name="date_of_birth" required/></p>--%>
        <%--<button type="submit" class="btn btn-success">Zapisz</button>--%>
        <%--</form>--%>
    <form action="/customer/save" method="post">
        <div class="form-group">
            <label for="inputName">Imię</label>
            <textarea class="form-control" id="inputName" rows="1" name="name" required="required"></textarea>
        </div>
        <div class="form-group">
            <label for="inputSurname">Nazwisko</label>
            <textarea class="form-control" id="inputSurname" rows="1" name="surname" required="required"></textarea>
        </div>
        <div class="col">
            <label for="inputDateOfBirth">Data urodzenia</label>
            <input type="date" class="form-control" id="inputDateOfBirth" placeholder="Data urodzenia"
                   name="date_of_birth" required="required">
        </div>
        <div class="container">
            <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
            <a href="/customers" class="btn btn-secondary mb-2"
               role="button"> Anuluj </a>
        </div>
    </form>
</div>
<div class="editUser">
    </c:if>
    <c:if test="${not empty customer.id}">
        <h3>Edycja klienta</h3>
        <%--<form action="/customer/save" method="post">--%>
        <%--<p>Imię: <input type="text" name="name" placeholder="${customer.name}" required/></p>--%>
        <%--<p>Naziwsko: <input type="text" name="surname" placeholder="${customer.surname}" required/></p>--%>
        <%--<p>Data urodzenia: <input type="date" placeholder="<fmt:formatDate value="${customer.dateOfBirth}" pattern="dd-MM-yyyy"/>" name="date_of_birth" required/></p>--%>
        <%--<input type="hidden" name="id" value="${customer.id}"/>--%>
        <%--<button type="submit" class="btn btn-success">Zapisz</button>--%>
        <%--</form>--%>
        <form action="/customer/save" method="post">
                <input type="hidden" name="id" value="${customer.id}"/>
            <div class="form-group">
                <label for="inputName">Imię</label>
                <textarea class="form-control" id="inputName" rows="1" name="name"
                          required="required">${customer.name}</textarea>
            </div>
            <div class="form-group">
                <label for="inputSurname">Nazwisko</label>
                <textarea class="form-control" id="inputSurname" rows="1" name="surname"
                          required="required">${customer.surname}</textarea>
            </div>
            <div class="col">
                <label for="inputDateOfBirth">Data urodzenia</label>
                <input type="date" class="form-control" id="inputDateOfBirth" placeholder="Data urodzenia"
                       name="date_of_birth" required="required" value="${customer.dateOfBirth}">
            </div>
            <div class="container">
                <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
                <a href="/customers" class="btn btn-secondary mb-2"
                   role="button"> Anuluj </a>
            </div>
        </form>
    </c:if>
</div>


<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
