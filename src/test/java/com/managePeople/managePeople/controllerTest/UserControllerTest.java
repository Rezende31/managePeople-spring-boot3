package com.managePeople.managePeople.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.managePeople.managePeople.controller.UserController;
import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.repositories.UserRepository;
import com.managePeople.managePeople.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@Execution(ExecutionMode.CONCURRENT)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;

	@Test
	public void testFindAllUsers() throws Exception {
		List<User> users = Arrays.asList(new User(1L, "@Test", null),
				new User(2L, "@Test1", null));
		
		when(userService.findAll()).thenReturn(users);

		mvc.perform(get("/users")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is("@Test")))
				.andExpect(jsonPath("$[1].name", is("@Test1")));
	}
	
	@Test
	public void testFindById() throws Exception{
		User user = new User(1L, "name_test", null);
		userService.insert(user);
		when(userService.findById(1L)).thenReturn(user);
		assertThat(user.getId()).isEqualTo(1L);
		assertThat(user.getName()).isEqualTo("name_test");
	}
	
	@Test
	public void testInsertUser() {
		User user = new User(null, "@test", null);
		when(userService.insert(user)).thenReturn(user);
		assertThat(user.getName()).isEqualTo("@test");
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User(1L, "@testUpdate", null);
		when(userService.insert(user)).thenReturn(user);
		when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
		
		
		assertThat(user).isNotNull();
		assertThat(user.getId()).isEqualTo(1L);
	}

}
