package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/vehicles")
public class VehicleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehicleDao vehicleDao = new VehicleDao();

        try {
            List<VehicleDao> allVehicles = VehicleDao.findAll();
            request.setAttribute("vehicles", allVehicles);
            request.getParameter("customer_id");
            getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle/vehicleList.jsp").forward(request,response);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
