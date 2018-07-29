package com.capgemini.service;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.repository.UserDAO;
import com.capgemini.service.dto.UserDTO;
import com.capgemini.utils.mappers.implementations.UserMapper;

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
		UserEntity expectedUserEntity = createUserEntity();
		UserDTO expectedUserDto = createUserDto();

		when(userDAO.findByID(eq(expectedUserEntity.getId()))).thenReturn(expectedUserEntity);

		when(userMapper.mapToDTO(eq(expectedUserEntity))).thenReturn(expectedUserDto);

		// when
		UserDTO result = userService.getProfile(expectedUserDto.getId());

		// then
		assertThat(result).isEqualTo(expectedUserDto);
	}

	@Test
	public void shouldSaveUser() {
		// given
		UserEntity expectedUserEntity = createUserEntity();
		UserDTO expectedUserDto = createUserDto();

		when(userDAO.save(eq(expectedUserEntity))).thenReturn(expectedUserEntity);

		when(userMapper.mapToDTO(eq(expectedUserEntity))).thenReturn(expectedUserDto);

		// when
		userService.createProfile(expectedUserDto);
		UserDTO result = userService.getProfile(expectedUserDto.getId());

		// then
		assertThat(userService.getProfile(expectedUserDto.getId())).isEqualTo(result);
	}

	//

	private UserDTO createUserDto() {
		return new UserDTO(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.now(), Instant.now(), "");
	}

	private UserEntity createUserEntity() {
		return new UserEntity(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
				new HashSet<>(), Instant.now(), Instant.now(), "");
	}
}
