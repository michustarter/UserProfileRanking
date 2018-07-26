package com.capgemini.mappers;

import org.springframework.stereotype.Component;

import com.capgemini.service.PlayedGameDTO;

@Component
public class PlayedGameMapper implements MapperInterface<PlayedGameEntity, PlayedGameDTO> {

	@Override
	public PlayedGameDTO mapToDTOfromEntity(PlayedGameEntity playedGameEntity) {

		if (playedGameEntity == null) {
			return null;
		}

		PlayedGameDTO playedGameDTO = new PlayedGameDTO();
		playedGameDTO.setId(playedGameEntity.getId());
		playedGameDTO.setGame(playedGameEntity.getGame());
		playedGameDTO.setWinner(playedGameEntity.getWinner());
		playedGameDTO.setLost(playedGameEntity.getLost());
		playedGameDTO.setWinnerLevel(playedGameEntity.getWinnerLevel());
		playedGameDTO.setLostLevel(playedGameEntity.getLostLevel());

		return playedGameDTO;

	}

	@Override
	public PlayedGameEntity mapToEntityFromDTO(PlayedGameDTO playedGameDTO) {

		if (playedGameDTO == null) {
			return null;
		}

		PlayedGameEntity playedGameEntity = new PlayedGameEntity();
		playedGameEntity.setId(playedGameDTO.getId());
		playedGameEntity.setGame(playedGameDTO.getGame());
		playedGameEntity.setWinner(playedGameDTO.getWinner());
		playedGameEntity.setLost(playedGameDTO.getLost());
		playedGameEntity.setWinnerLevel(playedGameDTO.getWinnerLevel());
		playedGameEntity.setLostLevel(playedGameDTO.getLostLevel());
		return playedGameEntity;

	}

}