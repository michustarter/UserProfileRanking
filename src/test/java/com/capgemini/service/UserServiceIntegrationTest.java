package com.capgemini.service;

import com.capgemini.service.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;

	@Test
	public void shouldSaveUser() throws Exception {
		// given
		UserDTO user = new UserDTO(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.now(), Instant.now(), "");

		// when
		userService.createProfile(user);

		// then
		assertThat(user).isEqualTo(userService.getProfile(user.getId()));
	}
}
