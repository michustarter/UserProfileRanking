package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.UserDTO;

@Component
public class UserMapper implements MapperInterface<UserEntity, UserDTO> {

	@Override
	public UserDTO mapToDTOfromDAO(UserEntity userEntity) {

		if (userEntity == null) {
			throw new NullPointerException();
		}

		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setLifeMotto(userEntity.getLifeMotto());

		return userDTO;

	}

	@Override
	public UserEntity mapToDAOfromDTO(UserDTO userDTO) {

		if (userDTO == null) {
			throw new NullPointerException();
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setLifeMotto(userDTO.getLifeMotto());

		return userEntity;

	}

}