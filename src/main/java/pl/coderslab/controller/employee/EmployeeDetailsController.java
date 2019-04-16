package pl.coderslab.controller.employee;

import pl.coderslab.dao.CustomerDao;
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

@WebServlet("/employee")
public class EmployeeDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            EmployeeDao employeeDao = EmployeeDao.findById(id).orElse(null);
            List<RepairDao> repairsInProgress = RepairDao.findByEmployeeId(id);
            List<RepairDao> repairsAll = RepairDao.findByEmployeeIdAll(id);

            request.setAttribute("employee", employeeDao);
            request.setAttribute("repairs", repairsInProgress);
            request.setAttribute("repairsAll", repairsAll);

        } catch (NumberFormatException | SQLException ignored) {
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/employee/employeeDetails.jsp").forward(request, response);
    }
}
