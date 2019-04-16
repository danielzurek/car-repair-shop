package pl.coderslab.controller.repair;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import static pl.coderslab.dao.EmployeeDao.findById;

@WebServlet("/repair/save")
public class RepairSaveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int vehicleId = Integer.parseInt(request.getParameter("vehicle_id"));
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        Date arrivalDate = Date.valueOf(request.getParameter("arrival_date"));
        Date plannedServiceStart = Date.valueOf(request.getParameter("planned_service_start"));
        Date serviceStart = Date.valueOf(request.getParameter("service_start"));
        String problemDescription = request.getParameter("problem_description");
        String status = request.getParameter("status");
        double clientPrice = Double.parseDouble(request.getParameter("client_price"));
        double partCost = Double.parseDouble(request.getParameter("part_cost"));
        double staffHourCost = Double.parseDouble(String.valueOf(EmployeeDao.findByIdHourCost(employeeId)));
        int staffHourAmount = Integer.parseInt(request.getParameter("staff_hour_amount"));
//        Date repairFinished = Date.valueOf(request.getParameter("repair_finished"));



        RepairDao repairDao = getOrCreateRepair(id);
        if (id != null){


                repairDao.setVehicleId(vehicleId);
                repairDao.setEmployeeId(employeeId);
                repairDao.setArrivalDate(arrivalDate);
                repairDao.setPlannedServiceStart(plannedServiceStart);
                repairDao.setServiceStart(serviceStart);
                repairDao.setProblemDescription(problemDescription);
                repairDao.setStatus(status);
                repairDao.setClientPrice(clientPrice);
                repairDao.setPartCost(partCost);
                repairDao.setStaffHourCost(Double.valueOf(request.getParameter("staff_hour_cost")));
                repairDao.setStaffHourAmount(staffHourAmount);
                repairDao.setRepairFinished(Date.valueOf(request.getParameter("repair_finished")));


        } else {

            repairDao.setVehicleId(vehicleId);
            repairDao.setEmployeeId(employeeId);
            repairDao.setArrivalDate(arrivalDate);
            repairDao.setPlannedServiceStart(plannedServiceStart);
            repairDao.setServiceStart(serviceStart);
            repairDao.setProblemDescription(problemDescription);
            repairDao.setStatus(status);
            repairDao.setClientPrice(clientPrice);
            repairDao.setPartCost(partCost);
            repairDao.setStaffHourCost(staffHourCost);
            repairDao.setStaffHourAmount(staffHourAmount);
        }

        try {
            repairDao.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/repairs");
    }
    private RepairDao getOrCreateRepair(String textualId) {
        try {
            int id = Integer.parseInt(textualId);
            RepairDao repairDao = RepairDao.findById(id).orElse(null);
            if (repairDao != null) {
                return repairDao;
            }
        } catch (NumberFormatException | SQLException ignored) {
        }
        return new RepairDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  ;



    }
}
