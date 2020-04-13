package com.example.bootfoodforce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootfoodforce.entities.Employee;
import com.example.bootfoodforce.services.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Get all Employees
	@GetMapping(value= "/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
			return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
		}
	
	//Get employee by id
	@GetMapping(value= "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
			Employee employee = employeeService.getById(id);
			if(employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}
	
	@PostMapping(value = "/createEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		
		Employee createdEmployee = employeeService.addEmployee(employee);
		if(createdEmployee != null) {
			return new ResponseEntity<>("Successfully created " + employee.getFirstName() + " " + employee.getLastName(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Failed to create" + employee + " as Employee",HttpStatus.BAD_REQUEST);
			}
		}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		
		}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Deleted employee with id: " + id, HttpStatus.OK);
			}
	
			
	}

