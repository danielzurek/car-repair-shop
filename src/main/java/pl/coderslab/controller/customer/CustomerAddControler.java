package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/customer/addedit")
public class CustomerAddControler extends HttpServlet {

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


        getServletContext().getRequestDispatcher("/WEB-INF/views/customer/customerAdd.jsp").forward(request, response);

    }
    private CustomerDao getCustomer(int id) {
        try {
            return CustomerDao.findById(id).orElse(null);
        } catch (SQLException e) {
            return null;
        }
    }
}
