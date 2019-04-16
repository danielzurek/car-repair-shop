package pl.coderslab.dao;

import pl.coderslab.database.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao {

   private Integer id;
   private String name;
   private String surname;
   private Date dateOfBirth;

    public CustomerDao(Integer id, String name, String surname, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerDao() {
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

    @Override
    public String toString() {
        return "CustomerDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + dateOfBirth +
                '}';
    }


    public static List<CustomerDao> findAll() throws SQLException {
        List<CustomerDao> customers = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM customer";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    CustomerDao customerDao = new CustomerDao();
                    customerDao.id = rs.getInt("id");
                    customerDao.name = rs.getString("name");
                    customerDao.surname = rs.getString("surname");
                    customerDao.dateOfBirth = rs.getDate("date_of_birth");
                    customers.add(customerDao);
                }
            }
        }
        return customers;
    }


    public static Optional<CustomerDao> findById(int id) throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * FROM customer WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    CustomerDao customerDao = new CustomerDao();
                    customerDao.id = id;
                    customerDao.name = rs.getString("name");
                    customerDao.surname = rs.getString("surname");
                    customerDao.dateOfBirth = rs.getDate("date_of_birth");
                    return Optional.of(customerDao);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public static List<CustomerDao> findBySurname(String surname) throws SQLException {
        List<CustomerDao> clientsBySurname = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            String sql = "SELECT * \n" +
                    "FROM customer\n" +
                    "WHERE CONCAT( name,  ' ', surname ) LIKE  ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + surname + "%" );
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    CustomerDao customerDao = new CustomerDao();
                    customerDao.surname = surname;
                    customerDao.id = rs.getInt("id");
                    customerDao.name = rs.getString("name");
                    customerDao.surname = rs.getString("surname");
                    customerDao.dateOfBirth = rs.getDate("date_of_birth");
                    clientsBySurname.add(customerDao);
                }
            }
            return clientsBySurname;
        }

    }

    public CustomerDao save() throws SQLException {
        try (Connection connection = DbUtil.getConnection()) {
            if (id == null) {
                String sql = "INSERT INTO customer(name, surname, date_of_birth) VALUES(?, ?, ?)";
                String[] generatedColumns = {"ID"};
                try (PreparedStatement statement = connection.prepareStatement(sql, generatedColumns)) {
                    statement.setString(1, this.name);
                    statement.setString(2, this.surname);
                   statement.setDate(3, this.dateOfBirth);
                    if (statement.executeUpdate() > 0) {
                        ResultSet rs = statement.getGeneratedKeys();
                        if (rs.next()) {
                            this.id = rs.getInt(1);
                        }
                    }
                }
            } else {
                String sql = "UPDATE customer SET name = ?, surname = ?, date_of_birth = ? WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, this.name);
                    statement.setString(2, this.surname);
                    statement.setDate(3, this.dateOfBirth);
                    statement.setInt(4, this.id);
                    statement.executeUpdate();
                }
            }
        }
        return this;
    }

    public void delete() throws SQLException {
        if (this.id != null) {
            try (Connection connection = DbUtil.getConnection()) {
                String sql = "DELETE FROM customer WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    this.id = null;
                }
            }
        }
    }
////prawdopodobnie zbędne
//    public Optional <CustomerDao> getCustomer() throws SQLException {
//        return CustomerDao.findById(this.id);
//    }
}
