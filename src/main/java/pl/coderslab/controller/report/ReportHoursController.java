package pl.coderslab.controller.report;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.ReportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/report/hours")
public class ReportHoursController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            Date dateFrom = Date.valueOf(request.getParameter("dateFrom"));
            Date dateTo = Date.valueOf(request.getParameter("dateTo"));
            List<ReportDao> hours = ReportDao.allHoursReport(dateFrom, dateTo);
            request.setAttribute("hours", hours);
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            getServletContext().getRequestDispatcher("/WEB-INF/views/report/report1.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/report/reportHours.jsp").forward(request, response);
    }
}
