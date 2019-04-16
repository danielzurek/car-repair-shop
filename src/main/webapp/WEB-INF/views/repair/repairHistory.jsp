<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 08/03/19
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Historia napraw pojazdu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<h4>Historia napraw pojazdu</h4>
<c:if test="${empty repairs}">
    <h4>Brak pojazdów.</h4>
</c:if>
<c:if test="${not empty repairs}">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>Data rozpoczęcia naprawy</th>
            <th>Opis problemu</th>
            <th>Akcje</th>
            <th colspan="2"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="repair" items="${repairs}">
            <tr>
                <td>${repair.serviceStart}</td>
                <td>${repair.problemDescription}</td>
                <td><a href="/repair?id=${repair.id}&vehicleId=${repair.vehicleId}&employeeId=${repair.employeeId}&home">Szczegóły</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
