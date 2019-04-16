package pl.coderslab.controller.employee;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/employee/delete")
public class EmployeeDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDao.findById(id).ifPresent(employeeDao -> {
                try {
                    employeeDao.delete();
                } catch (SQLException ignored) {
                }
            });
        } catch (NumberFormatException | SQLException ignored) {
        }

        response.sendRedirect("/employees");
    }
}
