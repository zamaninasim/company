package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String fullName;
    private Integer enteringYear;
    private Integer salaryLimits;
    private Integer personalId;
}
