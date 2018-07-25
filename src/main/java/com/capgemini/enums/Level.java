package com.capgemini.enums;

public enum Level {
	NEWBIE(1, 0.0), WEAKLING(2, 0.5), BEGINNER(3, 1.0), EXPERIENCED_BEGINNER(4, 1.5), MIDDLEBROW(5,
			2.0), EXPERIENCED_MIDDLEBORW(6, 2.5), ADVANCED(7, 3.0), MASTER(8, 3.5);

	private final int value;
	private final double winRate;

	Level(int value, double winRate) {
		this.value = value;
		this.winRate = winRate;
	}

	public int getValue() {
		return value;
	}

	public double getWinRate() {
		return winRate;
	}

	public static Level getLevelByValue(int value) {
		for (Level level : Level.values()) {
			if (level.getValue() == value) {
				return level;
			}
		}
		return null;
	}
}
