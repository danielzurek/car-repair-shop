package pl.coderslab.dao;

import pl.coderslab.database.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao {
   private Integer id;
   private String name;
   private String surname;
   private String address;
   private String phone;
   private String note;
   private Double staffHour;

    public EmployeeDao(Integer id, String name, String surname, String address, String phone, String note, Double staffHour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.staffHour = staffHour;
    }

    public EmployeeDao() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getStaffHour() {
        return staffHour;
    }

    public void setStaffHour(Double staffHour) {
        this.staffHour = staffHour;
    }

    @Override
    public String toString() {
        return "EmployeeDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", staffHour=" + staffHour +
                '}';
    }

    public static List<EmployeeDao> findAll() throws SQLException {
        List<EmployeeDao> employees = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM employee";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    EmployeeDao employeeDao = new EmployeeDao();
                    employeeDao.id = rs.getInt("id");
                    employeeDao.name = rs.getString("name");
                    employeeDao.surname = rs.getString("surname");
                    employeeDao.address = rs.getString("address");
                    employeeDao.phone = rs.getString("phone");
                    employeeDao.note = rs.getString("note");
                    employeeDao.staffHour = rs.getDouble("staff_hour");
                    employees.add(employeeDao);
                }
            }
        }
        return employees;
    }


    public static Optional<EmployeeDao> findById(int id) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM employee WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    EmployeeDao employeeDao = new EmployeeDao();
                    employeeDao.id = id;
                    employeeDao.name = rs.getString("name");
                    employeeDao.surname = rs.getString("surname");
                    employeeDao.address = rs.getString("address");
                    employeeDao.phone = rs.getString("phone");
                    employeeDao.note = rs.getString("note");
                    employeeDao.staffHour = rs.getDouble("staff_hour");
                    return Optional.of(employeeDao);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public static Double findByIdHourCost(int id){
        String sql = "SELECT * FROM employee WHERE id=?";
        EmployeeDao employee = new EmployeeDao();
        try(Connection connection = DbUtil.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    employee.staffHour = rs.getDouble("staff_hour");

                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return employee.staffHour;
    }


    public EmployeeDao save() throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            if (id == null) {
                String sql = "INSERT INTO employee(name, surname, address, phone, note, staff_hour) VALUES(?, ?, ?, ?, ?, ?)";
                String[] generatedColumns = {"ID"};
                try (PreparedStatement statement = connection.prepareStatement(sql, generatedColumns)) {
                    statement.setString(1, this.name);
                    statement.setString(2, this.surname);
                    statement.setString(3, this.address);
                    statement.setString(4, this.phone);
                    statement.setString(5, this.note);
                    statement.setDouble(6, this.staffHour);
                    if (statement.executeUpdate() > 0) {
                        ResultSet rs = statement.getGeneratedKeys();
                        if (rs.next()) {
                            this.id = rs.getInt(1);
                        }
                    }
                }
            } else {
                String sql = "UPDATE employee SET name = ?, surname = ?, address = ?, phone = ?, note = ?, staff_hour = ? WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, this.name);
                    statement.setString(2, this.surname);
                    statement.setString(3, this.address);
                    statement.setString(4, this.phone);
                    statement.setString(5, this.note);
                    statement.setDouble(6, this.staffHour);
                    statement.setInt(7, this.id);
                    statement.executeUpdate();
                }
            }
        }
        return this;
    }

    public void delete() throws SQLException {
        if (this.id != null) {
            try (Connection connection = DbUtil.getConnection()) {
                String sql = "DELETE FROM employee WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    this.id = null;
                }
            }
        }
    }



}
