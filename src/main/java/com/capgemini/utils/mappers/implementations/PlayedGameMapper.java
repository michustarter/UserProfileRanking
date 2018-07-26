package com.capgemini.utils.mappers.implementations;

import com.capgemini.utils.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.PlayedGameEntity;
import com.capgemini.service.dto.PlayedGameDTO;

@Component
public class PlayedGameMapper implements Mapper<PlayedGameEntity, PlayedGameDTO> {

	private final GameMapper gameMapper;
	private final UserMapper userMapper;

	@Autowired
	public PlayedGameMapper(GameMapper gameMapper, UserMapper userMapper) {
		this.gameMapper = gameMapper;
		this.userMapper = userMapper;
	}

	@Override
	public PlayedGameDTO mapToDTO(PlayedGameEntity playedGameEntity) {
		if (playedGameEntity == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		PlayedGameDTO playedGameDTO = new PlayedGameDTO();
		playedGameDTO.setId(playedGameEntity.getId());
		playedGameDTO.setGame(gameMapper.mapToDTO(playedGameEntity.getGame()));
		playedGameDTO.setWinner(userMapper.mapToDTO(playedGameEntity.getWinner()));
		playedGameDTO.setLost(userMapper.mapToDTO(playedGameEntity.getLost()));
		return playedGameDTO;
	}

	@Override
	public PlayedGameEntity mapToEntity(PlayedGameDTO playedGameDTO) {
		if (playedGameDTO == null) {
			throw new NullPointerException("Cannot map null object.");
		}

		PlayedGameEntity playedGameEntity = new PlayedGameEntity();
		playedGameEntity.setId(playedGameDTO.getId());
		playedGameEntity.setGame(gameMapper.mapToEntity(playedGameDTO.getGame()));
		playedGameEntity.setWinner(userMapper.mapToEntity(playedGameDTO.getWinner()));
		playedGameEntity.setLost(userMapper.mapToEntity(playedGameDTO.getLost()));
		return playedGameEntity;
	}
}