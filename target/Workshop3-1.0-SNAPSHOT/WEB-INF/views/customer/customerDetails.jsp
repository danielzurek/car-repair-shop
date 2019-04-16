<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 05/02/19
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Dane klienta</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="main">
    <a href="/customers" class="btn btn-primary" role="button">Powrót</a>
    <h3>Dane klienta</h3>
    <p>Imię i nazwisko: <b>${customer.name} ${customer.surname}</b></p>
    <p>Data urodzenia: <b><fmt:formatDate value="${customer.dateOfBirth}" pattern="dd-MM-yyyy"/></b></p>
</div>
<div class="editCustomer">
    <%--<div class="card-header">--%>
    <%--<a class="btn btn-success float-right"--%>
    <%--href="<c:url value="/vehicle/add"/>?id=${customer.id}"--%>
    <%--role="button"> Dodaj pojazd </a>--%>
    <%--</div>--%>
    <a href="/customer/addedit?id=${customer.id}" class="btn btn-warning" role="button">Edycja klienta</a>
    <a href="/customer/delete?id=${customer.id}" class="btn btn-danger" role="button">Usuń klienta</a>

</div>
<div class="addVehicle">
    <a href="/vehicle/add?id=${customer.id}" class="btn btn-success" role="button">Dodaj pojazd</a>
</div>
<div class="addRepair">
    <a href="/repair/addedit?customerId=${customer.id}&id=0" class="btn btn-success" role="button">Dodaj zlecenie</a>
</div>
<h3>Pojazdy należące do klienta</h3>
<div class="table-responsive">
    <c:if test="${empty vehicles}">
        <h4>Brak pojazdów.</h4>
    </c:if>
    <c:if test="${not empty vehicles}">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>ID</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Rok produkcji</th>
            <th>Nr rejestracyjny</th>
            <th>Kolejny przegląd</th>
            <th>Akcje</th>
            <th colspan="2"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vehicle" items="${vehicles}">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.brand}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.yearOfProduction}</td>
                <td>${vehicle.registrationPlate}</td>
                <td><fmt:formatDate value="${vehicle.nextInspectionDate}" pattern="dd-MM-yyyy"/></td>
                <td>${vehicle.name} ${vehicle.surname}</td>
                <td><a href="/vehicle?id=${vehicle.id}&home">Szczegóły</a>&nbsp<a
                        href="/vehicle/edit?id=${vehicle.id}&customerId=${vehicle.customerId}">Edytuj</a>&nbsp<a
                        href="/vehicle/delete?id=${vehicle.id}">Usuń</a>&nbsp
                    <a href="vehicle/repairs?id=${vehicle.id}&home">Historia napraw</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</c:if>
<%--<h3>Dane pojazdu</h3>--%>
<%--<p>Marka: <b>${vehicle.brand}</b></p>--%>
<%--<p>Model: <b>${vehicle.model}</b></p>--%>
<%--<p>Rok produkcji: <b>${vehicle.yearOfProduction}</p></p>--%>
<%--<p>Nr rejestracyjny: <b>${vehicle.registrationPlate}</b</p>--%>
<%--<p>	Kolejny przegląd: <b>${vehicle.nextInspectionDate}</b</p>--%>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
