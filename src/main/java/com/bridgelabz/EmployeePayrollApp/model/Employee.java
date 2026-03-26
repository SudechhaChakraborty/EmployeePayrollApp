package com.bridgelabz.EmployeePayrollApp.model;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;

public class Employee {

    private static long counter = 1;

    private Long id;
    private String name;
    private double salary;

    public Employee(EmployeeDTO employeeDTO){
        this.id = counter++;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}