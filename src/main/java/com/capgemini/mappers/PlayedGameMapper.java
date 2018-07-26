package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.PlayedGameEntity;
import com.capgemini.service.PlayedGameDTO;

@Component
public class PlayedGameMapper implements MapperInterface<PlayedGameEntity, PlayedGameDTO> {

	private GameMapper gameMapper;
	private UserMapper userMapper;

	@Override
	public PlayedGameDTO mapToDTOfromEntity(PlayedGameEntity playedGameEntity) {

		if (playedGameEntity == null) {
			return null;
		}

		PlayedGameDTO playedGameDTO = new PlayedGameDTO();
		playedGameDTO.setId(playedGameEntity.getId());
		playedGameDTO.setGame(gameMapper.mapToDTOfromEntity(playedGameEntity.getGame()));
		playedGameDTO.setWinner(userMapper.mapToDTOfromEntity(playedGameEntity.getWinner()));
		playedGameDTO.setLost(userMapper.mapToDTOfromEntity(playedGameEntity.getLost()));

		return playedGameDTO;

	}

	@Override
	public PlayedGameEntity mapToEntityFromDTO(PlayedGameDTO playedGameDTO) {

		if (playedGameDTO == null) {
			return null;
		}

		PlayedGameEntity playedGameEntity = new PlayedGameEntity();
		playedGameEntity.setId(playedGameDTO.getId());
		playedGameEntity.setGame(gameMapper.mapToEntityFromDTO(playedGameDTO.getGame()));
		playedGameEntity.setWinner(userMapper.mapToEntityFromDTO(playedGameDTO.getWinner()));
		playedGameEntity.setLost(userMapper.mapToEntityFromDTO(playedGameDTO.getLost()));
		return playedGameEntity;

	}

}