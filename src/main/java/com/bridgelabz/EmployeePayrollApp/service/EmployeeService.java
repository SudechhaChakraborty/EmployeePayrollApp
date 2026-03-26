package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    // Get all employees
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    // Get employee by id
    public Employee getEmployeeById(Long id){
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Create employee
    public Employee addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO);
        employeeList.add(employee);
        return employee;
    }

    // Update employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO){

        Employee employee = getEmployeeById(id);

        if(employee != null){
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
        }

        return employee;
    }

    // Delete employee
    public void deleteEmployee(Long id){

        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}