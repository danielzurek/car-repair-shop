package pl.coderslab.dao;

import pl.coderslab.database.DbUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleDao {

    private Integer id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String brand;
    private String model;
    private Integer yearOfProduction;
    private String registrationPlate;
    private Date nextInspectionDate;
    private Integer customerId;

    public VehicleDao(Integer id, String name, String surname, Date dateOfBirth, String brand, String model, Integer yearOfProduction, String registrationPlate, Date nextInspectionDate, Integer customerId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.registrationPlate = registrationPlate;
        this.nextInspectionDate = nextInspectionDate;
        this.customerId = customerId;
    }

    public VehicleDao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public Date getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(Date nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "VehicleDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", registrationPlate='" + registrationPlate + '\'' +
                ", nextInspectionDate=" + nextInspectionDate +
                ", customerId=" + customerId +
                '}';
    }

    public static List<VehicleDao> findAll() throws SQLException {
        List<VehicleDao> vehicles = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = " SELECT * FROM vehicle \n" +
                    "       INNER JOIN customer \n" +
                    "          ON customer.id = vehicle.customer_id WHERE customer.id";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    VehicleDao vehicleDao = new VehicleDao();
                    vehicleDao.id = rs.getInt("id");
                    vehicleDao.name = rs.getString("name");
                    vehicleDao.surname = rs.getString("surname");
                    vehicleDao.dateOfBirth = rs.getDate("date_of_birth");
                    vehicleDao.brand = rs.getString("brand");
                    vehicleDao.model = rs.getString("model");
                    vehicleDao.yearOfProduction = rs.getInt("year_of_production");
                    vehicleDao.registrationPlate = rs.getString("registration_plate");
                    vehicleDao.nextInspectionDate = rs.getDate("next_inspection_date");
                    vehicleDao.customerId = rs.getInt("customer_id");
                    vehicles.add(vehicleDao);
                }
            }
        }
        return vehicles;
    }


    //
    public static Optional<VehicleDao> findById(int id) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM vehicle \n" +
                    " INNER JOIN customer \n" +
                    " ON customer.id = vehicle.customer_id WHERE vehicle.id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    VehicleDao vehicleDao = new VehicleDao();
                    vehicleDao.id = id;
                    vehicleDao.name = rs.getString("name");
                    vehicleDao.surname = rs.getString("surname");
                    vehicleDao.dateOfBirth = rs.getDate("date_of_birth");
                    vehicleDao.brand = rs.getString("brand");
                    vehicleDao.model = rs.getString("model");
                    vehicleDao.yearOfProduction = rs.getInt("year_of_production");
                    vehicleDao.registrationPlate = rs.getString("registration_plate");
                    vehicleDao.nextInspectionDate = rs.getDate("next_inspection_date");
                    vehicleDao.customerId = rs.getInt("customer_id");
                    return Optional.of(vehicleDao);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public static Optional<RepairDao> loadVehicleId(int id) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM repair_order\n" +
                    "INNER JOIN vehicle\n" +
                    "ON vehicle.id = repair_order.vehicle_id";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    RepairDao repairDao = new RepairDao();
                    repairDao.id = id;
                    repairDao.vehicleBrand = rs.getString("brand");
                    repairDao.vehicleModel = rs.getString("model");
                    return Optional.of(repairDao);
                } else {
                    return Optional.empty();
                }
            }


        }
    }

    public static List<VehicleDao> findByCustomerId(int id) throws SQLException {
        List<VehicleDao> vehicles = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM vehicle WHERE customer_id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    VehicleDao vehicleDao = new VehicleDao();
                    vehicleDao.id = id;
                    vehicleDao.id = rs.getInt("id");
                    vehicleDao.brand = rs.getString("brand");
                    vehicleDao.model = rs.getString("model");
                    vehicleDao.yearOfProduction = rs.getInt("year_of_production");
                    vehicleDao.registrationPlate = rs.getString("registration_plate");
                    vehicleDao.nextInspectionDate = rs.getDate("next_inspection_date");
                    vehicleDao.customerId = rs.getInt("customer_id");
                    vehicles.add(vehicleDao);
                }
            }
            return vehicles;
        }

    }

    public VehicleDao save() throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            if (id == null) {
                String sql = "INSERT INTO vehicle (brand, model, year_of_production, registration_plate, next_inspection_date, customer_id)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                String[] generatedColumns = {"ID"};
                try (PreparedStatement statement = connection.prepareStatement(sql, generatedColumns)) {
                    statement.setString(1, this.brand);
                    statement.setString(2, this.model);
                    statement.setInt(3, this.yearOfProduction);
                    statement.setString(4, this.registrationPlate);
                    statement.setDate(5, this.nextInspectionDate);
                    statement.setInt(6, this.customerId);
                    if (statement.executeUpdate() > 0) {
                        ResultSet rs = statement.getGeneratedKeys();
                        if (rs.next()) {
                            this.id = rs.getInt(1);
                        }
                    }
                }
            } else {
                String sql = "UPDATE vehicle SET brand = ?, model = ?, year_of_production = ?, registration_plate = ?, next_inspection_date = ?  WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, this.brand);
                    statement.setString(2, this.model);
                    statement.setInt(3, this.yearOfProduction);
                    statement.setString(4, this.registrationPlate);
                    statement.setDate(5, this.nextInspectionDate);
                    statement.setInt(6, this.id);
                    statement.executeUpdate();
                }
            }
        }
        return this;
    }

    public void delete() throws SQLException {
        if (this.id != null) {
            try (Connection connection = DbUtil.getConnection()) {
                String sql = "DELETE FROM vehicle WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    this.id = null;
                }
            }
        }
    }


}
