package com.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
