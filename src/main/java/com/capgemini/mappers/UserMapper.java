package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.UserDTO;

@Component
public class UserMapper implements MapperInterface<UserEntity, UserDTO> {

	@Override
	public UserDTO mapToDTOfromEntity(UserEntity userEntity) {

		if (userEntity == null) {
			return null;
		}

		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setLifeMotto(userEntity.getLifeMotto());
		userDTO.setGamesSet(userEntity.getGames());
		userDTO.setAvailableFrom(userEntity.getAvailableFrom());
		userDTO.setAvailableTo(userEntity.getAvailableTo());

		return userDTO;

	}

	@Override
	public UserEntity mapToEntityFromDTO(UserDTO userDTO) {

		if (userDTO == null) {
			return null;
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setLifeMotto(userDTO.getLifeMotto());
		userEntity.setGames(userDTO.getGamesSet());
		userEntity.setAvailableFrom(userDTO.getAvailableFrom());
		userEntity.setAvailableTo(userDTO.getAvailableTo());
		userEntity.setNoAvailabilityComment(userDTO.getNoAvailabilityComment());
		return userEntity;

	}

}