package com.capgemini.dataAccess;

public class BoardGamesDataAccess { /*
									 * to ma być gotowe przed już na starcie
									 * przed którymi innymi obiektami?
									 */

	private String title;
	private int winnerPoints;
	private int drawPoints;

	public BoardGamesDataAccess(String title, int winnerPoints, int drawPoints) {
		this.title = title;
		this.winnerPoints = winnerPoints;
		this.drawPoints = drawPoints;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWinnerPoints() {
		return winnerPoints;
	}

	public void setWinnerPoints(int winnerPoints) {
		this.winnerPoints = winnerPoints;
	}

	public int getDrawPoints() {
		return drawPoints;
	}

	public void setDrawPoints(int drawPoints) {
		this.drawPoints = drawPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drawPoints;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + winnerPoints;
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
		BoardGamesDataAccess other = (BoardGamesDataAccess) obj;
		if (drawPoints != other.drawPoints)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (winnerPoints != other.winnerPoints)
			return false;
		return true;
	}

}
