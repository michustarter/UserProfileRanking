package com.capgemini.dataaccess.entity;

public class PlayedGameEntity {

	private Long id;
	private GameEntity game;
	private UserEntity winner;
	private UserEntity lost;

	public PlayedGameEntity() {
	}

	public PlayedGameEntity(Long id, GameEntity game, UserEntity winner, UserEntity lost) {
		this.id = id;
		this.game = game;
		this.winner = winner;
		this.lost = lost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameEntity getGame() {
		return game;
	}

	public void setGame(GameEntity game) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lost == null) ? 0 : lost.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
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
		PlayedGameEntity other = (PlayedGameEntity) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lost == null) {
			if (other.lost != null)
				return false;
		} else if (!lost.equals(other.lost))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayedGameEntity [id=" + id + ", game=" + game + ", winner=" + winner + ", lost=" + lost + "]";
	}

}
