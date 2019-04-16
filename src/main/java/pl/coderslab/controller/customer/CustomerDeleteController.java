package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/customer/delete")
public class CustomerDeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CustomerDao.findById(id).ifPresent(customerDao -> {
                try {
                    customerDao.delete();
                } catch (SQLException ignored) {
                }
            });
        } catch (NumberFormatException | SQLException ignored) {
        }

        response.sendRedirect("/customers");
    }
}
