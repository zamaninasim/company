package ir.maktab.dao;

import ir.maktab.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends BaseDao {
    public EmployeeDao() throws ClassNotFoundException, SQLException {
    }

    public List<Employee> readEmployeesFromDataBase() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("full_name"),
                        resultSet.getInt("entering_year"), resultSet.getInt("salary_Limit"), resultSet.getInt("personal_id"));
                employees.add(employee);
            }
        }
        return employees;
    }

    public List<Integer> FindAllAvailableYears(int now) throws SQLException {
        List<Integer> years = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT DISTINCT entering_year from employee ORDER BY entering_year;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                if(resultSet.getInt(1)> now-5)
                    years.add(resultSet.getInt(1));
        }
        return years;
    }
}
