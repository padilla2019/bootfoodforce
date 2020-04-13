package com.example.bootfoodforce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootfoodforce.entities.Credential;
import com.example.bootfoodforce.entities.Employee;
import com.example.bootfoodforce.repositories.CredentialRepository;

@Service
public class CredentialService {
	
	@Autowired
	CredentialRepository credRepo;
	
	public Credential getCredentials(String username,String password){
		return credRepo.findByUsernameAndPassword(username, password);
	}
	
	public List<Credential> getAllCredentials(){
		List<Credential> credentials = new ArrayList<>();
		credRepo.findAll().forEach(credentials::add);
		return credentials;
	}
	
}
