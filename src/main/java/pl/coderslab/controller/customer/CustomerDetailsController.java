package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
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

@WebServlet("/customer")
public class CustomerDetailsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            CustomerDao customerDao = CustomerDao.findById(id).orElse(null);
            List<VehicleDao> vehicles = VehicleDao.findByCustomerId(id);


            request.setAttribute("customer", customerDao);
            request.setAttribute("vehicles", vehicles);

        } catch (NumberFormatException | SQLException ignored) {
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/customerDetails.jsp").forward(request, response);
    }

    private VehicleDao getVehicle(int id) {
        try {
            return VehicleDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }
}
