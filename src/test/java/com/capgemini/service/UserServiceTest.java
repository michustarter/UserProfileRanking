package com.capgemini.service;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.repository.UserDAO;
import com.capgemini.service.dto.UserDTO;
import com.capgemini.utils.mappers.implementations.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class UserServiceTest {

	private UserService userService;
	private UserDAO userDAO;
	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		userDAO = Mockito.mock(UserDAO.class);
		userMapper = Mockito.mock(UserMapper.class);
		userService = new UserServiceImpl(userDAO, userMapper);
	}

	@Test
	public void shouldFindUser() throws Exception {
		// given
		UserDTO user = new UserDTO(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.now(), Instant.now(), "");

		UserEntity userEntity = new UserEntity(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2",
				"Jestem zwyciezca!", new HashSet<>(), Instant.now(), Instant.now(), "");

		when(userDAO.findByID(anyLong())).thenReturn(userEntity);

		when(userMapper.mapToDTO(any(UserEntity.class))).thenReturn(user);

		// when
		UserDTO result = userService.getProfile(user.getId());

		// then
		assertThat(result).isEqualTo(user);
	}
}
