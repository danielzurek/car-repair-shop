<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 07/02/19
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Dodawanie pojazdu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class="addVehicle">
    <a href = "/customer?id=<%= request.getParameter("id") %>" class="btn btn-primary" role="button">Powrót</a>
    <h3>Dodaj nowy pojazd</h3>
    <form action="/vehicle/save" method="post">
        <div class="form-group">
            <label for="inputVehicle">Marka</label>
            <textarea class="form-control" id="inputVehicle" rows="1" name="brand" required="required"></textarea>
        </div>
        <div class="form-group">
            <label for="inputModel">Model</label>
            <textarea class="form-control" id="inputModel" rows="1" name="model" required="required"></textarea>
        </div>
        <div class="col">
            <label for="inputYearOfProduction">Rok produkcji</label>
            <input type="number" class="form-control" id="inputYearOfProduction" placeholder="Rok produkcji"
                   name="year_of_production" required="required">
        </div>
        <div class="form-group">
            <label for="inputRegistrationPlate">Nr rejestracyjny</label>
            <textarea class="form-control" id="inputRegistrationPlate" rows="1" name="registration_plate"
                      required="required"></textarea>
        </div>
        <div class="col">
            <label for="inputNextInspectionDate">Kolejny przegląd</label>
            <input type="date" class="form-control" id="inputNextInspectionDate" placeholder="Data kolejnego przeglądu"
                   name="next_inspection_date" required="required">
        </div>
        <input type="hidden" name="customer_id" value="${customer.id}"/>
        <div class="container">
            <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
            <a href = "/customer?id=<%= request.getParameter("id") %>" class="btn btn-secondary mb-2"
               role="button"> Anuluj </a>
        </div>
    </form>
    <%--<form action="/vehicle/save" method="post">--%>
    <%--<p>	Marka: <input type="text" name="brand" required/></p>--%>
    <%--<p>Model: <input type="text" name="model" required/></p>--%>
    <%--<p>Rok produkcji: <input type="number" name="year_of_production" required/></p>--%>
    <%--<p>Nr rejestracyjny: <input type="text" name="registration_plate" required/></p>--%>
    <%--<p>Kolejny przegląd: <input type="date" placeholder="YYYY-MM-DD" name="next_inspection_date" required/></p>--%>
    <%--<input type="hidden" name="customer_id" value="${customer.id}"/>--%>
    <%--<button type="submit" class="btn btn-success">Zapisz</button>--%>
    <%--</form>--%>
</div>


<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
