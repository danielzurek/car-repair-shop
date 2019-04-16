package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet ("/vehicle/save")
public class VehicleSaveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        Integer yearOfProduction = Integer.valueOf(request.getParameter("year_of_production"));
        String registrationPlate = request.getParameter("registration_plate");
        Date nextInspectionDate = Date.valueOf(request.getParameter("next_inspection_date"));
        Integer customerId = Integer.parseInt(request.getParameter("customer_id"));





       VehicleDao vehicleDao = getOrCreateVehicle(id);
       vehicleDao.setBrand(brand);
       vehicleDao.setModel(model);
       vehicleDao.setYearOfProduction(yearOfProduction);
       vehicleDao.setRegistrationPlate(registrationPlate);
       vehicleDao.setNextInspectionDate(nextInspectionDate);
       vehicleDao.setCustomerId(customerId);


        try {
            vehicleDao.save();
        } catch (SQLException ignored) {
        }

        response.sendRedirect("/vehicles");
    }

    private VehicleDao getOrCreateVehicle(String textualId) {
        try {
            int id = Integer.parseInt(textualId);
            VehicleDao vehicleDao = VehicleDao.findById(id).orElse(null);
            if (vehicleDao != null) {
                return vehicleDao;
            }
        } catch (NumberFormatException | SQLException ignored) {
        }
        return new VehicleDao();
    }


}