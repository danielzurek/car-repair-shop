package pl.coderslab.dao;

import pl.coderslab.database.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReportDao {

    private int employeeId;
    private int staffHour;
    private Date dateFrom;
    private Date dateTo;
    private String employeeName;
    private String employeeSurname;
    private double profit;

    public ReportDao(int employeeId, int staffHour, Date dateFrom, Date dateTo, String employeeName, String employeeSurname) {
        this.employeeId = employeeId;
        this.staffHour = staffHour;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public ReportDao(int employeeId, int staffHour, Date dateFrom, Date dateTo, String employeeName, String employeeSurname, double profit) {
        this.employeeId = employeeId;
        this.staffHour = staffHour;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.profit = profit;
    }

    public ReportDao() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getStaffHour() {
        return staffHour;
    }

    public void setStaffHour(int staffHour) {
        this.staffHour = staffHour;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "ReportDao{" +
                "employeeId=" + employeeId +
                ", staffHour=" + staffHour +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", profit=" + profit +
                '}';
    }

    public static List<ReportDao> allHoursReport(Date dateFrom, Date dateTo) throws SQLException {
        List<ReportDao> allHours = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT name,surname,\n" +
                    "SUM(staff_hour_amount)\n" +
                    "FROM repair_order\n" +
                    "INNER JOIN employee\n" +
                    "ON employee.id = repair_order.employee_id WHERE repair_order.service_start>= ? AND repair_order.service_start<= ?\n" +
                    "GROUP BY employee_id";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, dateFrom);
                statement.setDate(2, dateTo);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    ReportDao reportDao = new ReportDao();
                    reportDao.dateFrom = dateFrom;
                    reportDao.dateTo = dateTo;
                    reportDao.employeeName = rs.getString("name");
                    reportDao.employeeSurname = rs.getString("surname");
                    reportDao.staffHour = rs.getInt("SUM(staff_hour_amount)");

                    allHours.add(reportDao);
                }
            }
            return allHours;
        }

    }

    public static Optional<ReportDao> profitReport(Date dateFrom, Date dateTo) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT SUM(client_price) - SUM(part_cost) - SUM(staff_hour_amount * staff_hour_cost)     \n" +
                    "FROM repair_order\n" +
                    "WHERE repair_finished >= ? AND repair_finished <= ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, dateFrom);
                statement.setDate(2, dateTo);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                   ReportDao reportDao = new ReportDao();
                    reportDao.profit = rs.getDouble("SUM(client_price) - SUM(part_cost) - SUM(staff_hour_amount * staff_hour_cost)");
                    return Optional.of(reportDao);
                } else {
                    return Optional.empty();
                }
            }


        }
    }

}
