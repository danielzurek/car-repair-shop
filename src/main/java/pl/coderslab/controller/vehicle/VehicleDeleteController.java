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

@WebServlet("/vehicle/delete")
public class VehicleDeleteController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            VehicleDao.findById(id).ifPresent(vehicleDao -> {
                try {
                    vehicleDao.delete();
                } catch (SQLException ignored) {
                }
            });
        } catch (NumberFormatException | SQLException ignored) {
        }

        response.sendRedirect("/vehicles");
    }

}