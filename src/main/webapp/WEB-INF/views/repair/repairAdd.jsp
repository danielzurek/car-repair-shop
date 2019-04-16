<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 25/02/19
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Dodawanie zlecenia</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div class = "addRepair">
    <c:if test="${empty repair.id}">
        <a href = "/customer?id=<%= request.getParameter("customerId") %>" class="btn btn-primary" role="button">Powrót</a>
        <h3>Dodaj zlecenie</h3>
        <%--<input type="hidden" name="id" value="${repair.id}"/>--%>
        <form action="/repair/save" method="post">
        <div class="form-row">
            <div class="col">
                <label for="inputArrivalDate">Data przyjęcia do naprawy</label>
                <input type="date" class="form-control" id="inputArrivalDate" placeholder="Data przyjęcia do naprawy" name="arrival_date" required="required" value="${repair.arrivalDate}">
            </div>
            <div class="col">
                <label for="inputPlannedServiceStart">Planowana data rozpoczęcia naprawy</label>
                <input type="date" class="form-control" id="inputPlannedServiceStart" placeholder="Planowana data rozpoczęcia naprawy" name="planned_service_start" required="required" value="${repair.plannedServiceStart}">
            </div>
        </div>
        <div class="col">
            <label for="inputServiceStart">Data rozpoczęcia naprawy</label>
            <input type="date" class="form-control" id="inputServiceStart" placeholder="Data rozpoczęcia naprawy" name="service_start" required="required" value = "${repair.serviceStart}">
        </div>
        <div class="form-group">
            <label for="inputProblemDescription">Opis problemu</label>
            <textarea class="form-control" id="inputProblemDescription" rows="3" name="problem_description" required="required">${repair.problemDescription}</textarea>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <select id="status" class="form-control" name="status">
                <option>Przyjęty</option>
                <option>Zatwierdzone koszty naprawy</option>
                <option>W naprawie</option>
                <option>Gotowy do odbioru</option>
                <option>Rezygnacja</option>
            </select>
        </div>
        <div class="form-group">
            <label for="vehicleId">Pojazd</label>
            <select id="vehicleId" class="form-control" name="vehicle_id">
                <c:forEach items="${vehicles}" var="vehicle">
                    <option value="${vehicle.id}">${vehicle.brand}&nbsp${vehicle.model}&nbsp${vehicle.registrationPlate}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="inputClientPrice">Koszt naprawy dla klienta</label>
            <input type="number" step="0.01" class="form-control" id="inputClientPrice" placeholder="Cena dla klienta" name="client_price" required="required" value="${repair.clientPrice}">
        </div>
        <div class="form-group">
            <label for="inputPartCost">Koszt wykorzystanych części</label>
            <input type="number" step="0.01" class="form-control" id="inputPartCost" placeholder="Koszt wykorzystanych części" name="part_cost" required="required" value="${repair.partCost}">
        </div>
        <%--<div class="form-group">--%>
            <%--<label for="inputStaffHourCost">Koszt roboczogodziny</label>--%>
            <%--<input type="number" step="0.01" class="form-control" id="inputStaffHourCost" placeholder="Koszt roboczogodziny" name="staff_hour_cost" value="${repair.staffHourCost}">${repair.staffHourCost}--%>
        <%--</div>--%>
        <div class="form-group">
            <label for="inputStaffHourAmount">Ilość roboczogodzin</label>
            <input type="number" step="0.01" class="form-control" id="inputStaffHourAmount" placeholder="Ilość roboczogodzin" name="staff_hour_amount" required="required" value="${repair.staffHourAmount}">
        </div>
        <%--<div class="col">--%>
            <%--<label for="inputRepairFinished">Data zakończenia naprawy</label>--%>
            <%--<input type="date" class="form-control" id="inputRepairFinished" placeholder="Data zakończenia naprawy" name="repair_finished" required="required" value="${repair.repairFinished}">--%>
        <%--</div>--%>
        <div class="form-group">
            <label for="employeeId">Pracownik</label>
            <select id="employeeId" class="form-control" name="employee_id">
                <c:forEach items="${employees}" var="employee">
                    <option value = "${employee.id}">${employee.name}&nbsp${employee.surname}</option>
                </c:forEach>
            </select>
        </div>
        <div class="container">
            <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
            <a href = "/customer?id=<%= request.getParameter("customerId") %>" class="btn btn-secondary mb-2"
               role="button"> Anuluj </a>
        </div>

        </form>
    </c:if>
</div>
<div class = "editRepair">
    <c:if test="${not empty repair.id}">
        <a href = "/repairs" class="btn btn-primary" role="button">Powrót</a>
        <h3>Edycja zlecenia</h3>
        <form action="/repair/save" method="post">
            <input type="hidden" name="id" value="${repair.id}"/>
            <div class="form-row">
                <div class="col">
                    <label for="inputArrivalDate">Data przyjęcia do naprawy</label>
                    <input type="date" class="form-control" id="inputArrivalDate" placeholder="Data przyjęcia do naprawy" name="arrival_date" required="required" value="${repair.arrivalDate}"/>
                </div>
                <div class="col">
                    <label for="inputPlannedServiceStart">Planowana data rozpoczęcia naprawy</label>
                    <input type="date" class="form-control" id="inputPlannedServiceStart" placeholder="Planowana data rozpoczęcia naprawy" name="planned_service_start" required="required" value="${repair.plannedServiceStart}">
                </div>
            </div>
            <div class="col">
                <label for="inputServiceStart">Data rozpoczęcia naprawy</label>
                <input type="date" class="form-control" id="inputServiceStart" placeholder="Data rozpoczęcia naprawy" name="service_start" required="required" value="${repair.serviceStart}">
            </div>
            <div class="form-group">
                <label for="inputProblemDescription">Opis problemu</label>
                <textarea class="form-control" id="inputProblemDescription" rows="3" name="problem_description" required="required">${repair.problemDescription}</textarea>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <select id="status" class="form-control" name="status">
                    <option>Przyjęty</option>
                    <option>Zatwierdzone koszty naprawy</option>
                    <option>W naprawie</option>
                    <option>Gotowy do odbioru</option>
                    <option>Rezygnacja</option>
                </select>
            </div>
            <div class="form-group">
                <label for="vehicleId">Pojazd</label>
                <select id="vehicleId" class="form-control" name="vehicle_id">
                    <c:forEach items="${vehicles}" var="vehicle">
                        <option value="${vehicle.id}">${vehicle.brand}&nbsp${vehicle.model}&nbsp${vehicle.registrationPlate}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="inputClientPrice">Koszt naprawy dla klienta</label>
                <input type="number" step="0.01" class="form-control" id="inputClientPrice" placeholder="Cena dla klienta" name="client_price" required="required" value="${repair.clientPrice}">
            </div>
            <div class="form-group">
                <label for="inputPartCost">Koszt wykorzystanych części</label>
                <input type="number" step="0.01" class="form-control" id="inputPartCost" placeholder="Koszt wykorzystanych części" name="part_cost" required="required" value="${repair.partCost}">
            </div>
            <div class="form-group">
                <label for="inputStaffHourCost">Koszt roboczogodziny</label>
                <input type="number" step="0.01" class="form-control" id="inputStaffHourCost" placeholder="Koszt roboczogodziny" name="staff_hour_cost" required="required" value="${repair.staffHourCost}">
            </div>
            <div class="form-group">
                <label for="inputStaffHourAmount">Ilość roboczogodzin</label>
                <input type="number" step="0.01" class="form-control" id="inputStaffHourAmount" placeholder="Ilość roboczogodzin" name="staff_hour_amount" required="required" value="${repair.staffHourAmount}">
            </div>
            <div class="col">
                <label for="inputRepairFinished">Data zakończenia naprawy</label>
                <input type="date" class="form-control" id="inputRepairFinished" placeholder="Data zakończenia naprawy" name="repair_finished" required="required" value="${repair.repairFinished}">
            </div>
            <div class="form-group">
                <label for="employeeId">Pracownik</label>
                <select id="employeeId" class="form-control" name="employee_id">
                    <c:forEach items="${employees}" var="employee">
                        <option value = "${employee.id}">${employee.name}&nbsp${employee.surname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="container">
                <button type="submit" class="btn btn-primary mb-2">Zapisz</button>
                <a href = "/repairs" class="btn btn-secondary mb-2"
                   role="button"> Anuluj </a>
            </div>

        </form>
    </c:if>
</div>



<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
