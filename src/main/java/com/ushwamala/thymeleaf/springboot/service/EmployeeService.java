package com.ushwamala.thymeleaf.springboot.service;

import com.ushwamala.thymeleaf.springboot.entity.Employee;


import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    void deleteEmployee(int employeeId);

    void updateEmployee(int employeeId, Employee employee);

    List<Employee> searchBy(String theName);
}
