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

@WebServlet("/vehicle/edit")
public class VehicleEditController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("vehicle", getVehicle(id));


        } catch (NumberFormatException ignored) {
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle/vehicleEdit.jsp").forward(request, response);
    }
    private VehicleDao getVehicle(int id) {
        try {
            return VehicleDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }
}