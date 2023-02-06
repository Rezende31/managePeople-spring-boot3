package com.managePeople.managePeople.controllerTest;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.managePeople.managePeople.controller.UserController;
import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@Execution(ExecutionMode.CONCURRENT)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Test
	public void testFindAllUsers() throws Exception {
		List<User> users = Arrays.asList(new User(1L, "John Doe", null),
				new User(2L, "Jane Doe", null));
		
		when(userService.findAll()).thenReturn(users);

		mvc.perform(get("/users")).andExpect(status().isOk())
				//andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("John Doe")))
				.andExpect(jsonPath("$[0].date", is(null)))
				.andExpect(jsonPath("$[1].name", is("Jane Doe")))
				.andExpect(jsonPath("$[1].date", is(null)));
	}

}
