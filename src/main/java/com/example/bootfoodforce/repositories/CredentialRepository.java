package com.example.bootfoodforce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootfoodforce.entities.Credential;

public interface CredentialRepository extends JpaRepository<Credential,Integer>{
	
	Credential findByUsernameAndPassword(String username, String password);

}
