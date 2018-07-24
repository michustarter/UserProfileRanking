package com.capgemini.dataaccess.repository;

import org.springframework.stereotype.Component;

import com.capgemini.dataaccess.entity.BoardGameEntity;
import com.capgemini.dataaccess.entity.UserEntity;

@Component
public class PlayedGamesDAO {

	private UserEntity winner;
	private UserEntity lost;
	private BoardGameEntity game;

	public PlayedGamesDAO(UserEntity winner, UserEntity lost, BoardGameEntity game) {
		this.winner = winner;
		this.lost = lost;
		this.game = game;
	}

	public UserEntity getWinner() {
		return winner;
	}

	public void setWinner(UserEntity winner) {
		this.winner = winner;
	}

	public UserEntity getLost() {
		return lost;
	}

	public void setLost(UserEntity lost) {
		this.lost = lost;
	}

	public BoardGameEntity getGame() {
		return game;
	}
		
		

	public void setGame(BoardGameEntity game) {
		this.game = game;
	}
	

}
