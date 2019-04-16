<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 15/02/19
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Lista zleceń</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>

<div class="table-responsive">
    <c:if test="${empty repairs}">
        <h3>Brak zleceń.</h3>
    </c:if>
    <c:if test="${not empty repairs}">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>ID</th>
                <th>Data przyjęcia do naprawy</th>
                <th>Planowana data rozpoczęcia naprawy</th>
                <th>Data rozpoczęcia naprawy</th>
                <th>Opis problemu</th>
                <th>Status</th>
                <th>Pojazd</th>
                <%--<th>Koszt naprawy dla klienta</th>--%>
                <%--<th>Koszt wykorzystanych części</th>--%>
                <%--<th>Koszt roboczogodziny</th>--%>
                <%--<th>Ilość roboczogodzin</th>--%>
                <th>Data zakończenia naprawy</th>
                <%--<th>Pracownik</th>--%>
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
                    <td>${repair.vehicleBrand} ${repair.vehicleModel}</td>
                    <%--<td>${repair.clientPrice}</td>--%>
                    <%--<td>${repair.partCost}</td>--%>
                    <%--<td>${repair.staffHourCost}</td>--%>
                    <%--<td>${repair.staffHourAmount}</td>--%>
                    <td><fmt:formatDate value="${repair.repairFinished}" pattern="dd-MM-yyyy"/></td>
                    <td><a href="/repair?id=${repair.id}&vehicleId=${repair.vehicleId}&employeeId=${repair.employeeId}&home">Szczegóły</a> <a href="/repair/addedit?id=${repair.id}&customerId=${repair.vehicleCustomerId}">Edytuj</a> <a href="/repair/delete?id=${repair.id}">Usuń</a></td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </c:if>
</div>




<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
