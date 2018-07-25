package com.capgemini.dataaccess.entity;

import org.springframework.stereotype.Component;

@Component
public class ChallengeEntity {

	private UserEntity challengeThrownFrom;
	private UserEntity receivedChallenge;
	private BoardGameEntity boardGame;

	public ChallengeEntity(UserEntity challengeThrownFrom, UserEntity receivedChallenge, BoardGameEntity boardGame) {
		this.challengeThrownFrom = challengeThrownFrom;
		this.receivedChallenge = receivedChallenge;
		this.boardGame = boardGame;
	}

	public UserEntity getChallengeThrownFrom() {
		return challengeThrownFrom;
	}

	public void setChallengeThrownFrom(UserEntity challengeThrownFrom) {
		this.challengeThrownFrom = challengeThrownFrom;
	}

	public UserEntity getReceivedChallenge() {
		return receivedChallenge;
	}

	public void setReceivedChallenge(UserEntity receivedChallenge) {
		this.receivedChallenge = receivedChallenge;
	}

	public BoardGameEntity getBoardGame() {
		return boardGame;
	}

	public void setBoardGame(BoardGameEntity boardGame) {
		this.boardGame = boardGame;
	}

}
