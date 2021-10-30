package ir.maktab;

import ir.maktab.model.Employee;
import ir.maktab.service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static EmployeeService employeeService;

    static {
        try {
            employeeService = new EmployeeService();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }

    private static List<Employee> returnEmployeesByYear(List<Employee> employees, int year) {
        List<Employee> employeesOfYear = new ArrayList<>();
        for (Employee employee : employeesOfYear) {
            if (employee.getEnteringYear() == year)
                employeesOfYear.add(employee);
        }
        return employeesOfYear;
    }
}
