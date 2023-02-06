package com.managePeople.managePeople.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.repositories.AddressRepository;
import com.managePeople.managePeople.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)) ;
	}
	
	public Address insert( Address address) {
		
		if(address.isMain()) {
			this.isMain(address);
		}
		
		return repository.save(address);
	}
	
	private void isMain(Address address) {
		List<Address> listAddresses = repository.findAll();
		Long idUser = address.getOwner().getId();
		
		for(int i=0; i<listAddresses.size(); i++ ) {
			if(listAddresses.get(i).getOwner().getId() == idUser) {
				listAddresses.get(i).setMain(false);
			}
		}
		
		
	}
}
