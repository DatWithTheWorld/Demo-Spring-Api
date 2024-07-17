package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Employee;
import com.springboot.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee.toString());
		Employee saveEmployee = employeeService.saveEmployee(employee);
		System.out.println(saveEmployee.toString());
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
	   return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int ids){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(ids), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int it){
		employeeService.deleteEmployee(it);
		return new ResponseEntity<String>("Employee deleted successfully !", HttpStatus.OK);
	
}
}
