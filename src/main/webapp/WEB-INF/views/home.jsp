<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 26/01/19
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Warsztat samochodowy</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="SearchClientByName">
    <h3>wyszukaj klienta po nazwisku</h3>
    <form action="/" method="post" class="row">

        <div class="form-group col-md-6">
            <label for="query">wyszukaj klienta po nazwisku</label>
            <input type="text" class="form-control" id="query" name="query" required="required">
            <button type="submit" class="btn btn-primary">Szukaj</button>
        </div>
    </form>
</div>


<c:if test="${empty repairs}">
    <p>Brak zleceń w trakcie realizacji</p>
</c:if>
<c:if test="${not empty repairs}">
    <div class="repairsInProgress">
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
            <c:forEach var="repair" items="${repairs}">
                <tr>
                    <td>${repair.id}</td>
                    <td><fmt:formatDate value="${repair.arrivalDate}" pattern="dd-MM-yyyy"/></td>
                    <td><fmt:formatDate value="${repair.plannedServiceStart}" pattern="dd-MM-yyyy"/></td>
                    <td><fmt:formatDate value="${repair.serviceStart}" pattern="dd-MM-yyyy"/></td>
                    <td>${repair.problemDescription}</td>
                    <td>${repair.status}</td>
                    <td><fmt:formatDate value="${repair.repairFinished}" pattern="dd-MM-yyyy"/></td>
                    <td>
                        <a href="/repair?id=${repair.id}&vehicleId=${repair.vehicleId}&employeeId=${repair.employeeId}&home">Szczegóły</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
