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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.repositories.UserRepository;
import com.managePeople.managePeople.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserService.class)
@Execution(ExecutionMode.CONCURRENT)
public class UserServiceTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserRepository userRepository;

	@Mock
	private UserService service;


	@Test
	public void testFindAllUser() {

		List<User> users = Arrays.asList(new User(1L, "@Test", null),
				new User(2L, "@Test1", null));
		
		when(userRepository.findAll()).thenReturn(users);
		
		assertThat(users.get(0).getName()).isEqualTo("@Test");
		assertThat(users.get(1).getName()).isEqualTo("@Test1");
	}
	
	@Test
	public void testFindById() {
		User user = new User(1L, "name_test", null);
		userRepository.save(user);
		when(service.findById(1L)).thenReturn(user);
		assertThat(user.getId()).isEqualTo(1L);
		assertThat(user.getName()).isEqualTo("name_test");
	}
}
