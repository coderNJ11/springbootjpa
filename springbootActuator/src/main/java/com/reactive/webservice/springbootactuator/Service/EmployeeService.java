package com.reactive.webservice.springbootactuator.Service;

import com.reactive.webservice.springbootactuator.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
        employeeList.add(new Employee("1", "Suresh", "YKsdfsdfs@example.com"));
        employeeList.add(new Employee("2", "xyz", "YKsdfsdfsf@example.com"));
        employeeList.add(new Employee("3", "Bharat", "YKZQsdf@example.com"));
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Employee getEmployee(String id) {
        return employeeList.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
