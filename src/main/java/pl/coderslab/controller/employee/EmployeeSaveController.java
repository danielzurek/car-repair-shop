package pl.coderslab.controller.employee;

import javafx.util.converter.BigDecimalStringConverter;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/employee/save")
public class EmployeeSaveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String adddress = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
//        BigDecimal staffHour = new BigDecimalStringConverter().fromString(request.getParameter("staff_salary"));
        Double staffHour = Double.valueOf(request.getParameter("staff_hour"));



        EmployeeDao employeeDao = getOrCreateEmployee(id);
        employeeDao.setName(name);
        employeeDao.setSurname(surname);
        employeeDao.setAddress(adddress);
        employeeDao.setPhone(phone);
        employeeDao.setNote(note);
        employeeDao.setStaffHour(staffHour);



        try {
            employeeDao.save();
        } catch (SQLException ignored) {
        }

        response.sendRedirect("/employees");
    }
    private EmployeeDao getOrCreateEmployee(String textualId) {
        try {
            int id = Integer.parseInt(textualId);
            EmployeeDao employeeDao = EmployeeDao.findById(id).orElse(null);
            if (employeeDao != null) {
                return employeeDao;
            }
        } catch (NumberFormatException | SQLException ignored) {
        }
        return new EmployeeDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
