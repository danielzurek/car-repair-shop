<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 23/02/19
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Szczegóły zlecenia</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="main">
    <a href="/repairs" class="btn btn-primary" role="button">Powrót</a>
    <h3>Szczegóły zlecenia</h3>
    <p>ID naprawy: <b>${repair.id}</b></p>
    <p>Data przyjęcia do naprawy: <b><fmt:formatDate value="${repair.arrivalDate}" pattern="dd-MM-yyyy"/></b></p>
    <p>Planowana data rozpoczęcia naprawy: <b><fmt:formatDate value="${repair.plannedServiceStart}" pattern="dd-MM-yyyy"/></b></p>
    <p>Data rozpoczęcia naprawy: <b><fmt:formatDate value="${repair.serviceStart}" pattern="dd-MM-yyyy"/></b></p>
    <p>Opis problemu: <b>${repair.problemDescription}</b</p>
    <p>Staus: <b>${repair.status}</b></p>
    <p>Pojazd: <b>${vehicle.brand} ${vehicle.model}</b></p>
    <p>Koszt wykorzystanych części: <b>${repair.partCost}</b></p>
    <p>Koszt roboczogodziny: <b>${repair.staffHourCost}</b</p>
    <p>Ilosc roboczogodzin: <b>${repair.staffHourAmount}</b</p>
    <p>Cena dla klienta: <b>${repair.clientPrice}</b</p>
    <p>Data zakończenia naprawy: <b>${repair.repairFinished}</b</p>
    <p>Pracownik: <b>${employee.name} ${employee.surname}</b</p>
</div>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
