package com.managePeople.managePeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.managePeople.managePeople.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
