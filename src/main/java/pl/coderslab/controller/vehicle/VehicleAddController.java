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

@WebServlet("/vehicle/add")
public class VehicleAddController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int id = Integer.parseInt(request.getParameter("id"));
            request.setCharacterEncoding("UTF-8");
            request.setAttribute("customer", getCustomer(id));
        } catch (NumberFormatException ignored) {
        }


        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicle/vehicleAdd.jsp").forward(request, response);

    }
    private CustomerDao getCustomer(int id) {
        try {
            return CustomerDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }


    }

