package com.capgemini.dataaccess.entity;

import org.springframework.stereotype.Component;

@Component
public class PlayedGamesEntity {

	private UserEntity winner; // dawać tu UserEntity czy jednak String winnerID..?
	private UserEntity lost;
	private BoardGameEntity game;

	public PlayedGamesEntity(UserEntity winner, UserEntity lost, BoardGameEntity game) {
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
