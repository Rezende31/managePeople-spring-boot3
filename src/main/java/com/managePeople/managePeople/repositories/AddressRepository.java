package com.managePeople.managePeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.managePeople.managePeople.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	

}
