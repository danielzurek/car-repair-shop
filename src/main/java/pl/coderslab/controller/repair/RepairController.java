package pl.coderslab.controller.repair;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/repairs")
public class RepairController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RepairDao repairDao = new RepairDao();
        try {
            List<RepairDao> repairs = RepairDao.findAll();
            request.setAttribute("repairs", repairs);
            List<RepairDao> allEmployees = RepairDao.findemployee();
            List<CustomerDao> allCustomers = CustomerDao.findAll();
            request.setAttribute("customers", allCustomers);
            request.setAttribute("employees", allEmployees);
            getServletContext().getRequestDispatcher("/WEB-INF/views/repair/repairList.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

