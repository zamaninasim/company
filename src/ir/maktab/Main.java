package ir.maktab;

import ir.maktab.model.Employee;
import ir.maktab.service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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

    private static void showInfoInTable() throws SQLException {
        List<Employee> allEmployees = sortEmployeesBySalaryLimits(employeeService.getEmployees());
        List<Integer> years = employeeService.returnFindAllAvailableYears();
        System.out.printf("%20s %20s %20s %20s", "enteringYear", "salaryLimits", "personalId", "full name");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Integer year : years) {
            List<Employee> employeesWithThisYear = returnEmployeesByYear(allEmployees, year);
            printSortedEmployee(1, 5, employeesWithThisYear);
            printSortedEmployee(5, 10, employeesWithThisYear);
            printSortedEmployee(10, 100, employeesWithThisYear);
        }
    }

    private static void printSortedEmployee(int min, int max, List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getSalaryLimits() > min && employee.getSalaryLimits() <= max) {
                System.out.format("%20s %20s %20s %20s", employee.getEnteringYear(), employee.getSalaryLimits(), employee.getPersonalId(), employee.getFullName());
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }
    }

    private static List<Employee> sortEmployeesBySalaryLimits(List<Employee> employees) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });
        return employees;
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
