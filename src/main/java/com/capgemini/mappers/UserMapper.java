package com.capgemini.mappers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.GameDTO;
import com.capgemini.service.UserDTO;

@Component
public class UserMapper implements MapperInterface<UserEntity, UserDTO> {
	
	private GameMapper gameMapper = new GameMapper();

	@Override
	public UserDTO mapToDTOfromEntity(UserEntity userEntity) {

		if (userEntity == null) {
			return null;
		}
		
		Set<GameDTO> setFromGameEntity= new HashSet<>();
		Iterator<GameEntity> iterator=userEntity.getGamesSet().iterator();
		while(iterator.hasNext()) {
			setFromGameEntity.add(gameMapper.mapToDTOfromEntity(iterator.next()));
		}
		

		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setLifeMotto(userEntity.getLifeMotto());
		userDTO.setGamesSet(setFromGameEntity);
		userDTO.setAvailableFrom(userEntity.getAvailableFrom());
		userDTO.setAvailableTo(userEntity.getAvailableTo());
		userDTO.setNoAvailabilityComment(userEntity.getNoAvailabilityComment());

		return userDTO;

	}

	@Override
	public UserEntity mapToEntityFromDTO(UserDTO userDTO) {

		if (userDTO == null) {
			return null;
		}
		Set<GameEntity> setFromGameDTO= new HashSet<>();
		Iterator<GameDTO> iterator=userDTO.getGamesSet().iterator();
		while(iterator.hasNext()) {
			setFromGameDTO.add(gameMapper.mapToEntityFromDTO(iterator.next()));
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setLifeMotto(userDTO.getLifeMotto());
		userEntity.setGamesSet(setFromGameDTO);
		userEntity.setAvailableFrom(userDTO.getAvailableFrom());
		userEntity.setAvailableTo(userDTO.getAvailableTo());
		userEntity.setNoAvailabilityComment(userDTO.getNoAvailabilityComment());
		return userEntity;

	}

}