<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 14/02/19
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Dodawanie pracownika</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class = "addEmployee">
    <a href="/employees" class="btn btn-primary" role="button">Powrót</a>
    <c:if test="${empty employee.id}">
        <h3>Dodaj nowego pracownika</h3>
        <form action="/employee/save" method="post">
            <div class="form-row">
                <div class="col">
                    <label for="inputName">Imię</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Imię" name="name" required="required" >
                </div>
                <div class="col">
                    <label for="inputSurname">Nazwisko</label>
                    <input type="text" class="form-control" id="inputSurname" placeholder="Nazwisko" name="surname" required="required">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Adres</label>
                <textarea class="form-control" id="inputAddress" rows="3" name="address"> </textarea>
            </div>
            <div class="form-group">
                <label for="inputPhone">Nr telefonu.</label>
                <input type="text" class="form-control" id="inputPhone" placeholder="Nr telefonu" name="phone" required="required">
            </div>
            <div class="form-group">
                <label for="inputAnnotation">Notatka</label>
                <textarea class="form-control" id="inputAnnotation" rows="3" name="note"></textarea>
            </div>
            <div class="form-group">
                <label for="inputStaffSalary">Stawka godzinoway</label>
                <input type="number" step="0.01" class="form-control" id="inputStaffSalary" placeholder="Stawka godzinowa" name="staff_hour" required="required">
            </div>
            <div class="container">
                <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
                <a class="btn btn-secondary mb-2"
                   href="<c:url value="/employees"/>"
                   role="button"> Anuluj </a>
            </div>

        </form>
    </c:if>
    <c:if test="${not empty employee.id}">
        <h3>Edycja pracownika</h3>
        <form action="/employee/save" method="post">
            <input type="hidden" name="id" value="${employee.id}"/>
            <div class="form-row">
                <div class="col">
                    <label for="inputName">Imię</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Imię" name="name" required="required" value="${employee.name}">
                </div>
                <div class="col">
                    <label for="inputSurname">Nazwisko</label>
                    <input type="text" class="form-control" id="inputSurname" placeholder="Nazwisko" name="surname" required="required" value="${employee.surname}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Adres</label>
                <textarea class="form-control" id="inputAddress" rows="3" name="address"> ${employee.address} </textarea>
            </div>
            <div class="form-group">
                <label for="inputPhone">Nr telefonu</label>
                <input type="text" class="form-control" id="inputPhone" placeholder="Nr telefonu" name="phone" required="required" value="${employee.phone}">
            </div>
            <div class="form-group">
                <label for="inputNote">Notatka</label>
                <textarea class="form-control" id="inputNote" rows="3" name="note">${employee.note}</textarea>
            </div>
            <div class="form-group">
                <label for="inputStaffSalary">Stawka godzinowa</label>
                <input type="number" step="0.01" class="form-control" id="inputStaffSalary" placeholder="Stawka godzinowa" name="staff_hour" required="required" value="${employee.staffHour}">
            </div>
            <div class="container">
                <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
                <a href = "/employees" class="btn btn-secondary mb-2"
                   role="button"> Anuluj </a>
            </div>

        </form>
        </form>
    </c:if>
</div>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>