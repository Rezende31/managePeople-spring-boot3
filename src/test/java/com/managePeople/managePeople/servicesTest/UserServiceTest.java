package com.managePeople.managePeople.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.repositories.UserRepository;
import com.managePeople.managePeople.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserService.class)
public class UserServiceTest {

//	@Autowired
//	private MockMvc mvc;

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;

//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testeFindAllUser() {
		List<User> users = new ArrayList<>();
		User u1 = new User(1L, "@test-1", null);
		users.add(u1);
		User u2 = new User(2L, "@test-2", null);
		users.add(u2);

		when(service.findAll()).thenReturn(users);
		
		assertThat(users.get(0).equals(u1));
		assertThat(users.get(1).equals(u2));
	}
}
