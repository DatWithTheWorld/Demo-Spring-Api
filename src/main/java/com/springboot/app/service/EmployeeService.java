package com.springboot.app.service;

import java.util.List;

import com.springboot.app.model.Employee;

public interface EmployeeService {
     Employee saveEmployee(Employee employee);
     
     List<Employee> getAllEmployees();
     
     Employee getEmployeeById(int id);
     
     Employee updateEmployee(Employee employee, int id);
     
     void deleteEmployee(int id);
}
