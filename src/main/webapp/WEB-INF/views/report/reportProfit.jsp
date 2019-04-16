<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 08/03/19
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Raport zysków</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<a href="/" class="btn btn-primary" role="button">Powrót</a>
<div class="Report">
    <h3>wybierz przedział czasowy</h3>
    <form action="/report/profit" method="post" class="row">

        <div class="form-group col-md-6">
            <label for="dateFrom">od</label>
            <input type="date" class="form-control" id="dateFrom" name="dateFrom" required="required">
        </div>

        <div class="form-group col-md-6">
            <label for="dateTo">do</label>
            <input type="date" class="form-control" id="dateTo" name="dateTo" required="required">
        </div>


        <button type="submit" class="btn btn-primary">Wyślij</button>
    </form>
</div>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>