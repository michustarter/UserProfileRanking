package com.capgemini.dataaccess.entity;

public enum Level {
	NEWBIE(0.0), WEAKLING(0.5), BEGINNER(1.0), EXPERIENCED_BEGINNER(1.5), MIDDLEBROW(2.0), EXPERIENCED_MIDDLEBORW(
			2.5), ADVANCED(3.0), PROFESSIONAL(3.5), MASTER(4.0);
	
	private final double winRate;

	Level(double winRate) {
		this.winRate = winRate;
	}

	public double getWinRate() {
		return winRate;
	}

}
