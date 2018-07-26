package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.service.GameDTO;

@Component
public class GameMapper implements MapperInterface<GameEntity, GameDTO> {
	

	@Override
	public GameDTO mapToDTOfromEntity(GameEntity gameEntity) {

		if (gameEntity == null) {
			return null;
		}

		GameDTO gameDTO = new GameDTO();
		gameDTO.setId(gameEntity.getId());
		gameDTO.setTitle(gameEntity.getTitle());

		return gameDTO;

	}

	@Override
	public GameEntity mapToEntityFromDTO(GameDTO gameDTO) {

		if (gameDTO == null) {
			return null;
		}

		GameEntity gameEntity = new GameEntity();
		gameEntity.setId(gameDTO.getId());
		gameEntity.setTitle(gameEntity.getTitle());

		return gameEntity;

	}

}