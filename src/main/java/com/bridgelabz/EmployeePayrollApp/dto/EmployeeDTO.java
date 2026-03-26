package com.bridgelabz.EmployeePayrollApp.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",
            message = "Employee name must start with capital letter and have minimum 3 characters")
    private String name;

    @Min(value = 500, message = "Salary must be more than 500")
    private double salary;

}