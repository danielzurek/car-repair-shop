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

@WebServlet("/employee/addedit")
public class EmployeeAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("employee", getEmployee(id));
        } catch (NumberFormatException ignored) {
        }


        getServletContext().getRequestDispatcher("/WEB-INF/views/employee/employeeAdd.jsp").forward(request, response);
    }
    private EmployeeDao getEmployee(int id) {
        try {
            return EmployeeDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }
}
