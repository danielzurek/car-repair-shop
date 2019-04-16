package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.RepairDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String query = request.getParameter("query");
            if (query != null){
                List<CustomerDao> queryResult = CustomerDao.findBySurname(query);
                request.setAttribute("result", queryResult);
                request.getRequestDispatcher("/WEB-INF/views/search/result.jsp").forward(request, response); }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);

        try {
            List<RepairDao> repairsInProgress = RepairDao.findAllInProgress();
            request.setAttribute("repairs", repairsInProgress);
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}