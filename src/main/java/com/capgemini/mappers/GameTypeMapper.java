package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.GameTypeEntity;
import com.capgemini.service.GameTypeDTO;

@Component
public class GameTypeMapper implements MapperInterface<GameTypeEntity, GameTypeDTO> {

	@Override
	public  GameTypeDTO mapToDTOfromEntity(GameTypeEntity gameTypeEntity) {

		if (gameTypeEntity == null) {
			return null;
		}

		 GameTypeDTO gameTypeDTO = new  GameTypeDTO();
		 gameTypeDTO.setId(gameTypeEntity.getId());
		 gameTypeDTO.setTitle(gameTypeEntity.getTitle());
		
		return gameTypeDTO;

	}

	@Override
	public GameTypeEntity mapToEntityFromDTO(GameTypeDTO gameTypeDTO) {

		if (gameTypeDTO == null) {
			return null;
		}

		GameTypeEntity gameTypeEntity = new GameTypeEntity();
		gameTypeEntity.setId(gameTypeDTO.getId());
		gameTypeEntity.setTitle(gameTypeDTO.getTitle());
		return gameTypeEntity;

	}

}