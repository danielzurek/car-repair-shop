package pl.coderslab.controller.repair;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.RepairDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/repair")
public class RepairDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));

            RepairDao repairDao = RepairDao.findById(id).orElse(null);
            EmployeeDao employeeDao = EmployeeDao.findById(employeeId).orElse(null);
            VehicleDao vehicleDao = VehicleDao.findById(vehicleId).orElse(null);
            request.setAttribute("repair", repairDao);
            request.setAttribute("employee", employeeDao);
            request.setAttribute("vehicle", vehicleDao);



        } catch (NumberFormatException | SQLException ignored) {
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/repair/repairDetails.jsp").forward(request, response);

    }
}
