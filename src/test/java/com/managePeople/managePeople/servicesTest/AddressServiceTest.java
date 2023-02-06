package com.managePeople.managePeople.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.repositories.AddressRepository;
import com.managePeople.managePeople.services.AddressService;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressService.class)
@Execution(ExecutionMode.CONCURRENT)
public class AddressServiceTest {
	
	@MockBean
	private AddressRepository repository;
	
	@Mock
	private AddressService service;
	
	@Test
	public void testFindAllAddresses() {
		List<Address> addresses = Arrays.asList(new Address(1L, null, 1234, null, null, false, null),
				new Address(2L, null, 12345, null, null, false, null));
		when(repository.findAll()).thenReturn(addresses);
		assertThat(addresses.get(0).getId()).isEqualTo(1L);
		assertThat(addresses.get(1).getId()).isEqualTo(2L);
		assertThat(addresses.get(0).getCep()).isEqualTo(1234);
	}
	
	@Test
	public void testFindById() {
		Address address = new Address(1L, null, 123, null, null, false, null);
		repository.save(address);
		when(service.findById(1L)).thenReturn(address);
		assertThat(address.getId()).isEqualTo(1L);
		assertThat(address.getCep()).isEqualTo(123);
	}

}
