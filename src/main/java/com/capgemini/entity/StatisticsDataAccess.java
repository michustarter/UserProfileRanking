package com.capgemini.entity;


public class StatisticsDataAccess {

	private LevelDataAccess level;
	private int points;
	private int gamesPlayed;
	private int gamesWon;
	//private int gamesDrawn;
	private int gamesLost;
	
	public StatisticsDataAccess(LevelDataAccess level, int points, int gamesPlayed, int gamesWon, int gamesDrawn, int gamesLost) {
		this.level=level;
		this.points=points;
		this.gamesPlayed=gamesPlayed;
		this.gamesWon=gamesWon;
		this.gamesLost=gamesLost;
	}

	public LevelDataAccess getLevel() {
		return level;
	}

	public void setLevel(LevelDataAccess level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGamesDrawn() {
		return gamesDrawn;
	}

	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gamesDrawn;
		result = prime * result + gamesLost;
		result = prime * result + gamesPlayed;
		result = prime * result + gamesWon;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + points;
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
		StatisticsDataAccess other = (StatisticsDataAccess) obj;
		if (gamesDrawn != other.gamesDrawn)
			return false;
		if (gamesLost != other.gamesLost)
			return false;
		if (gamesPlayed != other.gamesPlayed)
			return false;
		if (gamesWon != other.gamesWon)
			return false;
		if (level != other.level)
			return false;
		if (points != other.points)
			return false;
		return true;
	}
	
	
}
