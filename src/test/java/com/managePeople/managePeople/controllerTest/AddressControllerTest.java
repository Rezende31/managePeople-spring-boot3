package com.managePeople.managePeople.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.managePeople.managePeople.controller.AddressController;
import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.services.AddressService;


public class AddressControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private AddressService service;
	
	@InjectMocks
	private AddressController controller;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateAddress() {
		
		Address address = new Address(null, "Teste", 1, null, null, false, null);
		
		when(service.insert(address)).thenReturn(address);
		assertEquals(controller.insert(address), address);
		
	}
}
