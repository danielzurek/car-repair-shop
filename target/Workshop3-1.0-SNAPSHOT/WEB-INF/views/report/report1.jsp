<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 06/03/19
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Raport godzinowy wszystkich pracowników</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<a href="/report/hours" class="btn btn-primary" role="button">Powrót</a>
<div class="report">
    <h3>Raport roboczogodzin</h3>
    <h4>Wybrany zakres: ${dateFrom} - ${dateTo}</h4>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>Imię i nazwisko pracownika</th>
            <th>Ilość roboczogodzin</th>
            <th colspan="10"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hour" items="${hours}">
            <tr>
                <td>${hour.employeeName}&nbsp${hour.employeeSurname}</td>
                <td>${hour.staffHour}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>