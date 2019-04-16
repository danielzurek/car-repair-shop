package pl.coderslab.controller.repair;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/repair/delete")
public class RepairDeleteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            RepairDao.findById(id).ifPresent(repairDao -> {
                try {
                    repairDao.delete();
                } catch (SQLException ignored) {
                }
            });
        } catch (NumberFormatException | SQLException ignored) {
        }

        response.sendRedirect("/repairs");
    }
}
