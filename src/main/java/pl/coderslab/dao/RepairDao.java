package pl.coderslab.dao;

import pl.coderslab.database.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RepairDao {

    Integer id;
    private Integer vehicleId;
    private Integer employeeId;
    private java.sql.Date arrivalDate;
    private java.sql.Date plannedServiceStart;
    private java.sql.Date serviceStart;
    private String problemDescription;
    private String status;
    private Double clientPrice;
    private Double partCost;
    private Double staffHourCost;
    private Integer staffHourAmount;
    private java.sql.Date repairFinished;
    private String customerName;
    private String customerSurname;
    private java.sql.Date customerDateOfBirth;
    String vehicleBrand;
    String vehicleModel;
    private Integer vehicleYearOfProduction;
    private String vehicleRegistrationPlate;
    private Date vehicleNextInspectionDate;
    private Integer vehicleCustomerId;
    private String employeeName;
    private String employeeSurname;

    public RepairDao() {
    }

    public RepairDao(Integer id, Integer vehicleId, Integer employeeId, java.sql.Date arrivalDate, java.sql.Date plannedServiceStart, java.sql.Date serviceStart, String problemDescription, String status, Double clientPrice, Double partCost, Double staffHourCost, Integer staffHourAmount, java.sql.Date repairFinished, String customerName, String customerSurname, java.sql.Date customerDateOfBirth, String vehicleBrand, String vehicleModel, Integer vehicleYearOfProduction, String vehicleRegistrationPlate, Date vehicleNextInspectionDate, Integer vehicleCustomerId, String employeeName, String employeeSurname) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.employeeId = employeeId;
        this.arrivalDate = arrivalDate;
        this.plannedServiceStart = plannedServiceStart;
        this.serviceStart = serviceStart;
        this.problemDescription = problemDescription;
        this.status = status;
        this.clientPrice = clientPrice;
        this.partCost = partCost;
        this.staffHourCost = staffHourCost;
        this.staffHourAmount = staffHourAmount;
        this.repairFinished = repairFinished;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerDateOfBirth = customerDateOfBirth;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleYearOfProduction = vehicleYearOfProduction;
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
        this.vehicleNextInspectionDate = vehicleNextInspectionDate;
        this.vehicleCustomerId = vehicleCustomerId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public java.sql.Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(java.sql.Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public java.sql.Date getPlannedServiceStart() {
        return plannedServiceStart;
    }

    public void setPlannedServiceStart(java.sql.Date plannedServiceStart) {
        this.plannedServiceStart = plannedServiceStart;
    }

    public java.sql.Date getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(java.sql.Date serviceStart) {
        this.serviceStart = serviceStart;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(Double clientPrice) {
        this.clientPrice = clientPrice;
    }

    public Double getPartCost() {
        return partCost;
    }

    public void setPartCost(Double partCost) {
        this.partCost = partCost;
    }

    public Double getStaffHourCost() {
        return staffHourCost;
    }

    public void setStaffHourCost(Double staffHourCost) {
        this.staffHourCost = staffHourCost;
    }

    public Integer getStaffHourAmount() {
        return staffHourAmount;
    }

    public void setStaffHourAmount(Integer staffHourAmount) {
        this.staffHourAmount = staffHourAmount;
    }

    public java.sql.Date getRepairFinished() {
        return repairFinished;
    }

    public void setRepairFinished(java.sql.Date repairFinished) {
        this.repairFinished = repairFinished;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public java.sql.Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(java.sql.Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleYearOfProduction() {
        return vehicleYearOfProduction;
    }

    public void setVehicleYearOfProduction(Integer vehicleYearOfProduction) {
        this.vehicleYearOfProduction = vehicleYearOfProduction;
    }

    public String getVehicleRegistrationPlate() {
        return vehicleRegistrationPlate;
    }

    public void setVehicleRegistrationPlate(String vehicleRegistrationPlate) {
        this.vehicleRegistrationPlate = vehicleRegistrationPlate;
    }

    public Date getVehicleNextInspectionDate() {
        return vehicleNextInspectionDate;
    }

    public void setVehicleNextInspectionDate(Date vehicleNextInspectionDate) {
        this.vehicleNextInspectionDate = vehicleNextInspectionDate;
    }

    public Integer getVehicleCustomerId() {
        return vehicleCustomerId;
    }

    public void setVehicleCustomerId(Integer vehicleCustomerId) {
        this.vehicleCustomerId = vehicleCustomerId;
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

    //    public static List<RepairDao> findAll() throws SQLException {
//        List<RepairDao> repairs = new ArrayList<>();
//        try (Connection connection = DbUtil.getConnection()) {
//            String sql = "SELECT * FROM repair_order";
//            try (Statement statement = connection.createStatement()) {
//                ResultSet rs = statement.executeQuery(sql);
//                while (rs.next()) {
//                    RepairDao repairDao = new RepairDao();
//                    repairDao.id = rs.getInt("id");
//                    repairDao.vehicleId = rs.getInt("vehicle_id");
//                    repairDao.employeeId = rs.getInt("employee_id");
//                    repairDao.arrivalDate = rs.getDate("arrival_date");
//                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
//                    repairDao.serviceStart = rs.getDate("service_start");
//                    repairDao.problemDescription = rs.getString("problem_description");
//                    repairDao.status  = rs.getString("status");
//                    repairDao.clientPrice = rs.getDouble("client_price");
//                    repairDao.partCost = rs.getDouble("part_cost");
//                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
//                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
//                    repairDao.repairFinished = rs.getDate("repair_finished");
//
//                    repairs.add(repairDao);
//                }
//            }
//        }
//        return repairs;
//    }

    public static List<RepairDao> findAll() throws SQLException {
        List<RepairDao> repairs = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order \n" +
                    " INNER JOIN vehicle \n" +
                    " ON vehicle.id = repair_order.vehicle_id";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = rs.getInt("id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.arrivalDate = rs.getDate("arrival_date");
                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.status = rs.getString("status");
                    repairDao.clientPrice = rs.getDouble("client_price");
                    repairDao.partCost = rs.getDouble("part_cost");
                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
                    repairDao.repairFinished = rs.getDate("repair_finished");
//                    repairDao.customerName = rs.getString("name");
//                    repairDao.customerSurname = rs.getString("surname");
//                    repairDao.customerDateOfBirth = rs.getDate("date_of_birth");
                    repairDao.vehicleBrand = rs.getString("brand");
                    repairDao.vehicleModel = rs.getString("model");
//                    repairDao.vehicleYearOfProduction = rs.getInt("year_of_production");
//                    repairDao.vehicleRegistrationPlate  = rs.getString("registration_plate");
//                    repairDao.vehicleNextInspectionDate  = rs.getDate("next_inspection_date");
                    repairDao.vehicleCustomerId = rs.getInt("customer_id");

                    repairs.add(repairDao);

                }


            }
        }
        return repairs;
    }

    public static List<RepairDao> findAllInProgress() throws SQLException {
        List<RepairDao> repairs = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order WHERE status = 'W naprawie'";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = rs.getInt("id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.arrivalDate = rs.getDate("arrival_date");
                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.status = rs.getString("status");
                    repairDao.clientPrice = rs.getDouble("client_price");
                    repairDao.partCost = rs.getDouble("part_cost");
                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
                    repairDao.repairFinished = rs.getDate("repair_finished");

                    repairs.add(repairDao);

                }
            }

            return repairs;
        }
    }

    public static List<RepairDao> findemployee() throws SQLException {
        List<RepairDao> employee = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "  SELECT * FROM repair_order \n" +
                    " INNER JOIN employee \n" +
                    " ON employee.id = repair_order.employee_id;";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = rs.getInt("id");
                    repairDao.employeeName = rs.getString("name");
                    repairDao.employeeSurname = rs.getString("surname");


                    employee.add(repairDao);

                }


            }
        }
        return employee;
    }

    public static Optional<RepairDao> findById(int id) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = id;
                    repairDao.id = rs.getInt("id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.arrivalDate = rs.getDate("arrival_date");
                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.status = rs.getString("status");
                    repairDao.clientPrice = rs.getDouble("client_price");
                    repairDao.partCost = rs.getDouble("part_cost");
                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
                    repairDao.repairFinished = rs.getDate("repair_finished");
                    return Optional.of(repairDao);
                } else {
                    return Optional.empty();
                }
            }


        }
    }

    public static List<RepairDao> findByVehicleId(int vehicleId) throws SQLException {
        List<RepairDao> repairs = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT service_start, problem_description, employee_id, vehicle_id, id FROM repair_order\n" +
                    "WHERE vehicle_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, vehicleId);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.vehicleId = vehicleId;
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.id = rs.getInt("id");
                    repairs.add(repairDao);
                }
            }
            return repairs;
        }

    }


    public static List<RepairDao> findByEmployeeId(int id) throws SQLException {
        List<RepairDao> repairs = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order WHERE employee_id = ? AND status = 'W naprawie'";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = id;
                    repairDao.id = rs.getInt("id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.arrivalDate = rs.getDate("arrival_date");
                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.status = rs.getString("status");
                    repairDao.clientPrice = rs.getDouble("client_price");
                    repairDao.partCost = rs.getDouble("part_cost");
                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
                    repairDao.repairFinished = rs.getDate("repair_finished");

                    repairs.add(repairDao);

                }
            }

            return repairs;
        }

    }

    public static List<RepairDao> findByEmployeeIdAll(int id) throws SQLException {
        List<RepairDao> repairs = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order WHERE employee_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = id;
                    repairDao.id = rs.getInt("id");
                    repairDao.vehicleId = rs.getInt("vehicle_id");
                    repairDao.employeeId = rs.getInt("employee_id");
                    repairDao.arrivalDate = rs.getDate("arrival_date");
                    repairDao.plannedServiceStart = rs.getDate("planned_service_start");
                    repairDao.serviceStart = rs.getDate("service_start");
                    repairDao.problemDescription = rs.getString("problem_description");
                    repairDao.status = rs.getString("status");
                    repairDao.clientPrice = rs.getDouble("client_price");
                    repairDao.partCost = rs.getDouble("part_cost");
                    repairDao.staffHourCost = rs.getDouble("staff_hour_cost");
                    repairDao.staffHourAmount = rs.getInt("staff_hour_amount");
                    repairDao.repairFinished = rs.getDate("repair_finished");

                    repairs.add(repairDao);

                }
            }

            return repairs;
        }

    }

    public RepairDao save() throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            if (id == null) {
                String sql = "INSERT INTO repair_order (vehicle_id, employee_id, arrival_date, planned_service_start, service_start, problem_description, status, client_price, part_cost, staff_hour_cost, staff_hour_amount) VALUES\n" +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String[] generatedColumns = {"ID"};
                try (PreparedStatement statement = connection.prepareStatement(sql, generatedColumns)) {
                    statement.setInt(1, this.vehicleId);
                    statement.setInt(2, this.employeeId);
                    statement.setDate(3, this.arrivalDate);
                    statement.setDate(4, this.plannedServiceStart);
                    statement.setDate(5, this.serviceStart);
                    statement.setString(6, this.problemDescription);
                    statement.setString(7, this.status);
                    statement.setDouble(8, this.clientPrice);
                    statement.setDouble(9, this.partCost);
                    statement.setDouble(10, this.staffHourCost);
                    statement.setInt(11, this.staffHourAmount);
                    if (statement.executeUpdate() > 0) {
                        ResultSet rs = statement.getGeneratedKeys();
                        if (rs.next()) {
                            this.id = rs.getInt(1);
                        }
                    }
                }
            } else {
                String sql = "UPDATE repair_order SET vehicle_id = ?, employee_id = ?, arrival_date = ?, planned_service_start = ?, service_start = ?, problem_description = ?, status = ?, client_price = ?, part_cost = ?, staff_hour_cost = ?, staff_hour_amount = ?, repair_finished = ? \n" +
                        "WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, this.vehicleId);
                    statement.setInt(2, this.employeeId);
                    statement.setDate(3, this.arrivalDate);
                    statement.setDate(4, this.plannedServiceStart);
                    statement.setDate(5, this.serviceStart);
                    statement.setString(6, this.problemDescription);
                    statement.setString(7, this.status);
                    statement.setDouble(8, this.clientPrice);
                    statement.setDouble(9, this.partCost);
                    statement.setDouble(10, this.staffHourCost);
                    statement.setInt(11, this.staffHourAmount);
                    statement.setDate(12, this.repairFinished);
                    statement.setInt(13, this.id);
                    statement.executeUpdate();
//                }
                }
            }
            return this;
        }

    }

    public void delete() throws SQLException {
        if (this.id != null) {
            try (Connection connection = DbUtil.getConnection()) {
                String sql = "DELETE FROM repair_order WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    this.id = null;
                }
            }
        }
    }
}