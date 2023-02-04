package com.managePeople.managePeople.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findAll(){
		Address testAdress = new Address();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		User test = new User(1L,"teste" , null, testAdress);
		
		return ResponseEntity.ok().body(test);
	}
}
