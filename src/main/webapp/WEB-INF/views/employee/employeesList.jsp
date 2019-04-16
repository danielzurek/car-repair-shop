<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 14/02/19
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Pracownicy</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class name = "addEmployee">
    <a href="/employee/addedit" class="btn btn-success" role="button">Dodaj</a>
</div>

<div class="table-responsive">
    <c:if test="${empty employees}">
        <h3>Lista jest pusta.</h3>
    </c:if>
    <c:if test="${not empty employees}">
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>ID</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Adres</th>
                <th>Nr telefonu</th>
                <th>Notatka</th>
                <th>Stawka godzinowa</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.note}</td>
                    <td>${employee.staffHour}</td>
                    <td><a href="/employee?id=${employee.id}&home">Szczegóły</a> <a href="/employee/addedit?id=${employee.id}">Edytuj</a> <a href="/employee/delete?id=${employee.id}">Usuń</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
    </c:if>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>