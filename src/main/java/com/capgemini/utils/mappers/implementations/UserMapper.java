package com.capgemini.utils.mappers.implementations;

import java.util.HashSet;
import java.util.Set;

import com.capgemini.utils.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.dto.GameDTO;
import com.capgemini.service.dto.UserDTO;

@Component
public class UserMapper implements Mapper<UserEntity, UserDTO> {

	private final GameMapper gameMapper;

	@Autowired
	public UserMapper(GameMapper gameMapper) {
		this.gameMapper = gameMapper;
	}

	@Override
	public UserDTO mapToDTO(UserEntity userEntity) {
		if (userEntity == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		Set<GameDTO> gamesDTO = new HashSet<>();
		userEntity.getGamesSet().forEach(gameEntity -> {
			final GameDTO gameDTO = gameMapper.mapToDTO(gameEntity);
			gamesDTO.add(gameDTO);
		});

		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setLifeMotto(userEntity.getLifeMotto());
		userDTO.setGamesSet(gamesDTO);
		userDTO.setAvailableFrom(userEntity.getAvailableFrom());
		userDTO.setAvailableTo(userEntity.getAvailableTo());
		userDTO.setNoAvailabilityComment(userEntity.getNoAvailabilityComment());
		return userDTO;
	}

	@Override
	public UserEntity mapToEntity(UserDTO userDTO) {
		if (userDTO == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		Set<GameEntity> gameEntities = new HashSet<>();
		userDTO.getGamesSet().forEach(gameDTO -> {
			final GameEntity gameEntity = gameMapper.mapToEntity(gameDTO);
			gameEntities.add(gameEntity);
		});

		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setLifeMotto(userDTO.getLifeMotto());
		userEntity.setGamesSet(gameEntities);
		userEntity.setAvailableFrom(userDTO.getAvailableFrom());
		userEntity.setAvailableTo(userDTO.getAvailableTo());
		userEntity.setNoAvailabilityComment(userDTO.getNoAvailabilityComment());
		return userEntity;
	}

}