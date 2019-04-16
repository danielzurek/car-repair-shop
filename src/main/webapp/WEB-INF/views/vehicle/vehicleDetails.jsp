<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 07/02/19
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Dane pojazdu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="main">
    <a href="/vehicles" class="btn btn-primary" role="button">Powrót</a>
    <h3>Dane pojazdu</h3>
    <p>Marka: <b>${vehicle.brand}</b></p>
    <p>Model: <b>${vehicle.model}</b></p>
    <p>Rok produkcji: <b>${vehicle.yearOfProduction}</p></p>
    <p>Nr rejestracyjny: <b>${vehicle.registrationPlate}</b</p>
    <p>	Kolejny przegląd: <b>${vehicle.nextInspectionDate}</b</p>

</div>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>