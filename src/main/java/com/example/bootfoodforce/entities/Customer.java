package com.example.bootfoodforce.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator= "CUST_SEQ")
	@SequenceGenerator(allocationSize = 1,name = "CUST_SEQ", sequenceName = "customer_seq" )
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CREDENTIALID")
	private Credential credential;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(int id, String firstName, String lastName, Credential credential) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.credential = credential;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFristName() {
		return firstName;
	}
	public void setFristName(String fristName) {
		this.firstName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", fristName=" + firstName + ", lastName=" + lastName + ", credential="
				+ credential + "]";
	}
	
	

}
