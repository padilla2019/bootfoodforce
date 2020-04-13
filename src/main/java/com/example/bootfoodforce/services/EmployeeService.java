package com.example.bootfoodforce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootfoodforce.entities.Employee;
import com.example.bootfoodforce.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emplRepo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		emplRepo.findAll().forEach(employees::add);
		return employees;
		
	}
	
	public Employee addEmployee(Employee employee) {
		emplRepo.save(employee);
		return employee;
	}
	
	public Employee getById(int id) {
		//find by id is from repository not JPA Repository(CREATED BY ME)
		return emplRepo.findById(id);
		
	}
	
	public Employee updateEmployee(Employee employee, int id) {
		return emplRepo.save(employee);
	}
	
	public void deleteEmployee(int id) {
		emplRepo.deleteById(id);
	}
	

}
