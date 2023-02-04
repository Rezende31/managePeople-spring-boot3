package com.managePeople.managePeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managePeople.managePeople.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
