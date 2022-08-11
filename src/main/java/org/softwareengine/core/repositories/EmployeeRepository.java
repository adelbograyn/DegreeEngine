package org.softwareengine.core.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.softwareengine.core.model.Employee;
import org.softwareengine.utils.services.DatabaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepository {
    public ObservableList<Employee> getAll() {
        ObservableList<Employee> list = FXCollections.observableArrayList();
        String sql = "select * from employee";
        try {
            DatabaseService.openConnection();
            Statement statement = DatabaseService.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("degree")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void insert(Employee employee) {
        String sql = "INSERT INTO employee (id , name, degree) VALUES (?,?,?)";

        try {
            DatabaseService.openConnection();
            PreparedStatement ps = DatabaseService.connection.prepareStatement(sql);

            ps.setInt(1,employee.id());
            ps.setString(2,employee.name());
            ps.setInt(3, employee.degree());

            ps.executeUpdate();
            DatabaseService.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
