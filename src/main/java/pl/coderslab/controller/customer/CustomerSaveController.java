package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/customer/save")
public class CustomerSaveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Date dateOfBirth = Date.valueOf(request.getParameter("date_of_birth"));



        CustomerDao customerDao = getOrCreateCustomer(id);
        customerDao.setName(name);
        customerDao.setSurname(surname);
        customerDao.setDateOfBirth(dateOfBirth);


        try {
            customerDao.save();
        } catch (SQLException ignored) {
        }

        response.sendRedirect("/customers");
    }

    private CustomerDao getOrCreateCustomer(String textualId) {
        try {
            int id = Integer.parseInt(textualId);
            CustomerDao customerDao = CustomerDao.findById(id).orElse(null);
            if (customerDao != null) {
                return customerDao;
            }
        } catch (NumberFormatException | SQLException ignored) {
        }
        return new CustomerDao();
    }


}
