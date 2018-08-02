package com.capgemini.repository;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.exceptions.UserCouldNotBeFoundException;
import com.capgemini.dataaccess.repository.implementation.UserDAOImpl;;

public class UserDaoTest {

	private UserDAOImpl userDAO;
	private Map<Long, UserEntity> storage;

	@Before
	public void setUp() throws Exception {
		storage = new HashMap<>();
		userDAO = new UserDAOImpl(storage);
	}

	@Test
	public void shouldSaveUser() throws Exception {
		// given
		UserEntity userToSave = createUserEntity();

		// when
		UserEntity saved = userDAO.save(userToSave);

		// then
		assertThat(saved).isEqualTo(userToSave);
		assertThat(userDAO.findAll()).hasSize(1);
	}

	@Test
	public void shouldFindUser() throws Exception {
		// given

	}

	@Test
	public void shouldUpdateUser() {
		// given
		UserEntity userToUpdate = createUserEntity();
		userDAO.save(userToUpdate);
		// when
		userToUpdate.setFirstName("Janusz");
		userDAO.save(userToUpdate);
		// then
		assertThat(userDAO.findByID(userToUpdate.getId()).getFirstName()).isEqualTo("Janusz");

	}

	@Test(expected = UserCouldNotBeFoundException.class)
	public void shouldDeleteUser() {
		// given
		UserEntity userToDelete = createUserEntity();
		userDAO.save(userToDelete);
		// when
		userDAO.delete(userToDelete.getId());

		// then
		userDAO.findByID(userToDelete.getId());
	}

	@Test
	public void shouldFindAll() {
		// given
		UserEntity oneUser = createUserEntity();
		userDAO.save(oneUser);
		// when
		List<UserEntity> list = userDAO.findAll();
		// then
		assertThat(list.size() == 1);

	}

	private UserEntity createUserEntity() {
		return new UserEntity(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.ofEpochMilli(1000), Instant.ofEpochMilli(1000), "");
	}
}
