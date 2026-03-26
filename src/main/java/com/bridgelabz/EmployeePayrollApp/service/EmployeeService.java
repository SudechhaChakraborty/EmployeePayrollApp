package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.Employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    private Long empIdCounter = 1L;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Long id) {

        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found"));

    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {

        Employee emp = new Employee(empIdCounter++,
                employeeDTO.getName(),
                employeeDTO.getSalary());

        employeeList.add(emp);

        return emp;
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {

        Employee emp = getEmployeeById(id);

        emp.setName(employeeDTO.getName());
        emp.setSalary(employeeDTO.getSalary());

        return emp;
    }

    public void deleteEmployee(Long id) {

        Employee emp = getEmployeeById(id);

        employeeList.remove(emp);

    }

}