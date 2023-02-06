package com.managePeople.managePeople.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.managePeople.managePeople.controller.AddressController;
import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.services.AddressService;


public class AddressControllerTest {

//	@Autowired
//	private MockMvc mvc;

	@Mock
	private AddressService service;
	
	@InjectMocks
	private AddressController controller;
	
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void testCreateAddress() {
		
		User user = new User(null, "@test", null);
		Address address = new Address(null, "Teste", 1, null, null, false, user);
		
		
		when(service.insert(address)).thenReturn(address);
		assertEquals(controller.insert(address), address);
		
	}
}
