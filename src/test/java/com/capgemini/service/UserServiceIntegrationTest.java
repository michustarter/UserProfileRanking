package com.capgemini.service;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.dto.UserDTO;
import com.capgemini.utils.exceptions.NullUsersException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;

	@Test
	public void shouldSaveUser() throws Exception {
		// given
		UserDTO userToSave = createUserDto();

		// when
		userService.createProfile(userToSave);

		// then
		assertThat(userToSave).isEqualTo(userService.getProfile(userToSave.getId()));
	}

	@Test
	public void shouldFindById() {
		// given
		UserDTO expectedUser = createUserDto();
		userService.createProfile(expectedUser);

		// when
		UserDTO result = userService.getProfile(expectedUser.getId());

		// then
		assertThat(result).isEqualTo(expectedUser);
	}

	@Test
	public void shouldUpdateUser() {
		// given
		UserDTO user = createUserDto();
		userService.createProfile(user);

		user.setEmail("new.email@gmail.com");

		// when
		UserDTO updatedUser = userService.editProfile(user);

		// then
		assertThat(updatedUser).isEqualTo(user);
	}

	@Test(expected = NullUsersException.class)
	public void shouldDeleteUser() {
		// given
		UserDTO userToDelete = createUserDto();
		userService.createProfile(userToDelete);

		// when
		userService.deleteProfile(userToDelete.getId());

		// then
		userService.getProfile(userToDelete.getId());
	}

	@Test
	public void shouldDeleteAvailability() {
		// given
		UserDTO user = createUserDto();
		userService.createProfile(user);

		// when
		userService.deleteAvailabilityHours(user.getId());

		UserDTO updateUser = userService.getProfile(user.getId());

		// then
		assertNull(updateUser.getAvailableFrom());
		assertNull(updateUser.getAvailableTo());
		assertThat(updateUser.getNoAvailabilityComment()).isEqualTo("I have no time.");
	}

	@Test
	public void shouldReturnAllUsers() {
		// given
		UserDTO user1 = createUserDto();
		user1.setEmail("user1@gmail.com");
		UserDTO user2 = createUserDto();
		user2.setId(2L);
		user2.setEmail("user2@gmail.com");

		userService.createProfile(user1);
		userService.createProfile(user2);

		// when
		Set<UserDTO> users = userService.getAllUSers();

		// then
		assertThat(users).contains(user1, user2);
		assertThat(users).hasSize(2);
	}

	@Test
	public void removeUserGame() {

	}

	private UserDTO createUserDto() {
		return new UserDTO(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.ofEpochMilli(1000), Instant.ofEpochMilli(1000), "");
	}

	private UserEntity createUserEntity() {
		return new UserEntity(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.ofEpochMilli(1000), Instant.ofEpochMilli(1000), "");
	}
}
