package com.example.bootfoodforce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Credential {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CRED_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "CRED_SEQ", sequenceName = "credential_seq") 
	@Column(name = "CREDENTIALID")
	private int id;
	
	private String username;
	
	private String password;
	
	
	public Credential() {
		super();
		
	}
	

	public Credential(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Credential [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
