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

@WebServlet("/repair/addedit")
public class RepairAddControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            List<VehicleDao> vehicles = VehicleDao.findByCustomerId(customerId);
            List<EmployeeDao> employees = EmployeeDao.findAll();
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("repair", getRepair(id));
            request.setAttribute("vehicles", vehicles);
            request.setAttribute("employees", employees);
        } catch (NumberFormatException | SQLException ignored) {
        }


        getServletContext().getRequestDispatcher("/WEB-INF/views/repair/repairAdd.jsp").forward(request, response);
    }

    private RepairDao getRepair(int id) {
        try {
            return RepairDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }
}
