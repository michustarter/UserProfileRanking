package com.capgemini.utils.mappers.implementations;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.service.dto.GameDTO;
import com.capgemini.utils.mappers.Mapper;

@Component
public class GameMapper implements Mapper<GameEntity, GameDTO> {

	@Override
	public GameDTO mapToDTO(GameEntity gameEntity) {
		if (gameEntity == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		GameDTO gameDTO = new GameDTO();
		gameDTO.setId(gameEntity.getId());
		gameDTO.setTitle(gameEntity.getTitle());
		return gameDTO;
	}

	@Override
	public GameEntity mapToEntity(GameDTO gameDTO) {
		if (gameDTO == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		GameEntity gameEntity = new GameEntity();
		gameEntity.setId(gameDTO.getId());
		gameEntity.setTitle(gameEntity.getTitle());
		return gameEntity;
	}
}