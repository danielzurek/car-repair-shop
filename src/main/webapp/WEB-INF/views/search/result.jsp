<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 08/03/19
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Wynik wyszukiwania</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class name="searchResult">
    <a href="/" class="btn btn-success" role="button">Powrót</a>
    <div class="table-responsive">
        <c:if test="${empty result}">
            <h3>Brak wyników wyszukiwania.</h3>
        </c:if>
        <c:if test="${not empty result}">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Data urodzenia</th>
                    <th>Akcje</th>
                    <th colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${result}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.surname}</td>
                        <td><fmt:formatDate value="${customer.dateOfBirth}" pattern="dd-MM-yyyy"/></td>
                        <td><a href="/customer?id=${customer.id}&home">Szczegóły</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>