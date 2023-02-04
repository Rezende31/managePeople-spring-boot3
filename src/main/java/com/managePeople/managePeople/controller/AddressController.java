package com.managePeople.managePeople.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {
	
	@Autowired
	private AddressService service;

	@GetMapping
	public ResponseEntity<List<Address>> findAll(){
		List<Address> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
