package ir.maktab.service;

import ir.maktab.dao.EmployeeDao;
import ir.maktab.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    int thisYear = 1400;

    public EmployeeService() throws SQLException, ClassNotFoundException {
    }

    public List<Employee> getEmployees() throws SQLException {
        return employeeDao.readEmployeesFromDataBase();
    }

    public List<Integer> returnFindAllAvailableYears() throws SQLException {
        return employeeDao.FindAllAvailableYears(thisYear);
    }
}
