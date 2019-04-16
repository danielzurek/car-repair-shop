<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 14/02/19
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Dane pracownika</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="main">
    <a href="/employees" class="btn btn-primary" role="button">Powrót</a>
    <h3>Dane pracownika</h3>
    <p>Imię i nazwisko: <b>${employee.name} ${employee.surname}</b></p>
    <p>Adres: <b>${employee.address}</b></p>
    <p>Nr telefonu: <b>${employee.phone}</b></p>
    <p>Notatka: <b>${employee.note}</b></p>
    <p>Stawka godzinowa: <b>${employee.staffHour}</b></p>

</div>
<div class="editEmployee">
    <a href="/employee/addedit?id=${employee.id}" class="btn btn-warning" role="button">Edytuj</a>
    <a href="/employee/delete?id=${employee.id}" class="btn btn-danger" role="button">Usuń</a>

</div>
<h3>Lista aktualnie wykonywanych zleceń pracownika</h3>
<div class="employeeRepairs">
    <table class="table table-striped table-sm">
        <c:if test="${empty repairs}">
            <h4>Brak zleceń</h4>
        </c:if>
        <c:if test="${not empty repairs}">

        <thead>
        <tr>
            <th>ID</th>
            <th>Data przyjęcia do naprawy</th>
            <th>Planowana data rozpoczęcia naprawy</th>
            <th>Data rozpoczęcia naprawy</th>
            <th>Opis problemu</th>
            <th>Status</th>
            <th>Data zakończenia naprawy</th>
            <th>Akcje</th>
            <th colspan="10"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="repair" items="${repairs}">
        <tr>
            <td>${repair.id}</td>
            <td><fmt:formatDate value="${repair.arrivalDate}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${repair.plannedServiceStart}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${repair.serviceStart}" pattern="dd-MM-yyyy"/></td>
            <td>${repair.problemDescription}</td>
            <td>${repair.status}</td>
            <td><fmt:formatDate value="${repair.repairFinished}" pattern="dd-MM-yyyy"/></td>
            <td><a href="/repair?id=${repair.id}&vehicleId=${repair.vehicleId}&employeeId=${repair.employeeId}&home">Szczegóły</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${empty repairsAll}">
    <h4>Brak historii zleceń</h4>
</c:if>
<c:if test="${not empty repairsAll}">
    <h3>Historia zleceń</h3>
    <table class="table table-striped table-sm">
    <thead>
    <tr>
    <th>ID</th>
    <th>Data przyjęcia do naprawy</th>
    <th>Planowana data rozpoczęcia naprawy</th>
    <th>Data rozpoczęcia naprawy</th>
    <th>Opis problemu</th>
    <th>Status</th>
    <th>Data zakończenia naprawy</th>
    <th>Akcje</th>
    <th colspan="10"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="repair" items="${repairsAll}">
        <tr>
            <td>${repair.id}</td>
            <td><fmt:formatDate value="${repair.arrivalDate}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${repair.plannedServiceStart}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${repair.serviceStart}" pattern="dd-MM-yyyy"/></td>
            <td>${repair.problemDescription}</td>
            <td>${repair.status}</td>
            <td><fmt:formatDate value="${repair.repairFinished}" pattern="dd-MM-yyyy"/></td>
            <td><a href="/repair?id=${repair.id}&vehicleId=${repair.vehicleId}&employeeId=${repair.employeeId}&home">Szczegóły</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
</c:if>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
