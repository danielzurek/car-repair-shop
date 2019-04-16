<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 06/02/19
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Lista pojazdów</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>

<div class="table-responsive">
    <c:if test="${empty vehicles}">
        <h3>Brak pojazdów.</h3>
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
                <th>Właściciel</th>
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
                    <td><a href="/vehicle?id=${vehicle.id}&home">Szczegóły</a> <a href="/vehicle/edit?id=${vehicle.id}&customerId=${vehicle.customerId}">Edytuj</a> <a href="/vehicle/delete?id=${vehicle.id}">Usuń</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>




<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
