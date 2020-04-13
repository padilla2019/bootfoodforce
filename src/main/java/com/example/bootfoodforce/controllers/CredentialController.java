package com.example.bootfoodforce.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootfoodforce.entities.Credential;
import com.example.bootfoodforce.services.CredentialService;

@RestController
@CrossOrigin
@RequestMapping(value = "/credential")
public class CredentialController {
	
	@Autowired
	private CredentialService credService;
	
	@GetMapping(value = "/login/{username}/{password}")
	public ResponseEntity<?> getCredentials(@PathVariable String username,@PathVariable String password){
		Credential credentials = credService.getCredentials(username, password);
		System.out.println(credentials);
		if(credentials == null) {
			return new ResponseEntity<>("No user found under those credentials",HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(credentials,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Credential>> getAllCredentials(){
//		if(credentials == null) {
//			return new ResponseEntity<>("No user found under those credentials",HttpStatus.BAD_REQUEST);
//		}else {
			return new ResponseEntity<>(credService.getAllCredentials(),HttpStatus.OK);
		//}
		
	}

}
