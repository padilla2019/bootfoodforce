package com.example.bootfoodforce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator= "employeeSequence")
	@SequenceGenerator(allocationSize = 1, name = "employeeSequence", sequenceName = "employee_seq")
	@Column(name = "EMPLOYEEID")
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int reportsTo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CREDENTIALID")
	private Credential credential;
	
	
	
	
	public Employee() {
		super();
		
	}
	public Employee(int id, String firstName, String lastName, int reportsTo, Credential credential) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reportsTo = reportsTo;
		this.credential = credential;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", reportsTo=" + reportsTo
				+ ", credential=" + credential + "]";
	}
	
	
	
	

}
