package com.managePeople.managePeople.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.managePeople.managePeople.controller.AddressController;
import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.services.AddressService;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
@Execution(ExecutionMode.CONCURRENT)
public class AddressControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AddressService service;

	@InjectMocks
	private AddressController controller;


	@Test
	public void testFindAllAddress() throws Exception {
		List<Address> listAddresses = new ArrayList<>();
		Address a1 = new Address(1L, "logradouro-1", null, null, null, false, null);
		Address a2 = new Address(2L, "logradouro-2", null, null, null, false, null);
		listAddresses.add(a1);
		listAddresses.add(a2);

		when(service.findAll()).thenReturn(listAddresses);
		mvc.perform(get("/addresses")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].logradouro", is("logradouro-1")))
				.andExpect(jsonPath("$[1].logradouro", is("logradouro-2")));
	}
	
	@Test
	public void testFindById () {
		Address address = new Address(1L, null, 1234, null, null, false, null);
		service.insert(address);
		when(service.findById(1L)).thenReturn(address);
		assertThat(address.getId()).isEqualTo(1L);
		assertThat(address.getCep()).isEqualTo(1234);
	}
	

}
