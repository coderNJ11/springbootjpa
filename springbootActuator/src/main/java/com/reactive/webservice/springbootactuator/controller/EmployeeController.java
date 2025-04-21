package com.reactive.webservice.springbootactuator.controller;

import com.reactive.webservice.springbootactuator.Service.EmployeeService;
import com.reactive.webservice.springbootactuator.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;


    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

}
