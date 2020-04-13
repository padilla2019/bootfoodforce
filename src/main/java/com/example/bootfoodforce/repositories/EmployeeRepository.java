package com.example.bootfoodforce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootfoodforce.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	 List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
	 
	 Employee findById(int id);
	

}
