package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private Integer id;
    private String fullName;
    private Integer enteringYear;
    private Integer salaryLimits;
    private Integer personalId;

    @Override
    public int compareTo(Employee o) {
        if (this.enteringYear == o.enteringYear)
            return Integer.compare(this.salaryLimits, o.salaryLimits);
        else if (this.enteringYear < o.enteringYear)
            return 1;
        else return -1;
    }
}
