package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // GET employee by id
    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    // POST create employee
    @PostMapping("/create")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    // PUT update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody EmployeeDTO employeeDTO){

        return employeeService.updateEmployee(id, employeeDTO);
    }

    // DELETE employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}