package com.capgemini.service;

import java.util.HashSet;
import java.util.Set;

import com.capgemini.dataaccess.entity.GameTypeEntity;
import com.capgemini.dataaccess.entity.PlayedGameEntity;

public class GameDTO {

	private Long id;
	private GameTypeEntity gameType;
	private Set<PlayedGameEntity> playedGames;

	public GameDTO() {
		this.id=null;
		this.gameType=null;
		this.playedGames=new HashSet<>(); //tu tak czy lepiej =null?
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameTypeEntity getGameType() {
		return gameType;
	}

	public void setGameType(GameTypeEntity gameType) {
		this.gameType = gameType;
	}

	public Set<PlayedGameEntity> getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(Set<PlayedGameEntity> playedGames) {
		this.playedGames = playedGames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameType == null) ? 0 : gameType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((playedGames == null) ? 0 : playedGames.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDTO other = (GameDTO) obj;
		if (gameType == null) {
			if (other.gameType != null)
				return false;
		} else if (!gameType.equals(other.gameType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (playedGames == null) {
			if (other.playedGames != null)
				return false;
		} else if (!playedGames.equals(other.playedGames))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameEntity{" + "id=" + id + ", gameType=" + gameType.getTitle() + ", playedGames=" + playedGames.size()
				+ '}';
	}
}
