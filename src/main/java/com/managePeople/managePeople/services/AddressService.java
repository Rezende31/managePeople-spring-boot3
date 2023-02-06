package com.managePeople.managePeople.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.get();
	}
	
	public Address insert( Address address) {
		return repository.save(address);
	}
}
