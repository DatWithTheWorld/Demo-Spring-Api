package com.springboot.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.app.exeption.ResourceNotFoundExeption;
import com.springboot.app.model.Employee;
import com.springboot.app.repository.EmployeeRepository;
import com.springboot.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println(employee.getFirstName());
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundExeption("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Employee", "Id", id));
		
	}



	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		Employee existingE = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundExeption("Employee", "id", id));
		
		existingE.setFirstName(employee.getFirstName());
		existingE.setLastName(employee.getLastName());
		existingE.setEmail(employee.getEmail());
		
		employeeRepository.save(existingE);
		return existingE;
		
	}



	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}
