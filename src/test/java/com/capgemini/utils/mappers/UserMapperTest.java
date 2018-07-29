package com.capgemini.utils.mappers;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.dto.UserDTO;
import com.capgemini.utils.mappers.implementations.GameMapper;
import com.capgemini.utils.mappers.implementations.UserMapper;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserMapperTest {

	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		userMapper = new UserMapper(new GameMapper());
	}

	@Test
	public void shouldMapUserDtoToUserEntity() throws Exception {
		// given
		UserEntity userEntity = createUserEntity();
		UserDTO expectedResult = createUserDto();

		// when
		UserDTO result = userMapper.mapToDTO(userEntity);

		// then
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	public void shouldMapUserEntityToUserDto() throws Exception {
		// given
		UserDTO userDto = createUserDto();
		UserEntity expectedResult = createUserEntity();

		// when
		UserEntity result = userMapper.mapToEntity(userDto);

		// then
		assertThat(result).isEqualTo(expectedResult);
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
