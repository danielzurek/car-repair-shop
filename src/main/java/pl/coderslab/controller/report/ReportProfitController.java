package pl.coderslab.controller.report;

import pl.coderslab.dao.ReportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/report/profit")
public class ReportProfitController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Date dateFrom = Date.valueOf(request.getParameter("dateFrom"));
            Date dateTo = Date.valueOf(request.getParameter("dateTo"));
            ReportDao reportDao = ReportDao.profitReport(dateFrom, dateTo).orElse(null);
            request.setAttribute("profit", reportDao);
            request.setAttribute("dateFrom", dateFrom);
            request.setAttribute("dateTo", dateTo);
            getServletContext().getRequestDispatcher("/WEB-INF/views/report/report2.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/report/reportProfit.jsp").forward(request, response);
    }
}
