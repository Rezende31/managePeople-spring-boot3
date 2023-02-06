package com.managePeople.managePeople.servicesTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.managePeople.managePeople.repositories.UserRepository;
import com.managePeople.managePeople.services.UserService;

public class UserServiceTest {
	
	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testeFindAllUser() {
		
	}
}
