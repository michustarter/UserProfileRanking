package com.capgemini.utils.enums;

public enum Level {
	NEWBIE(0, 0.0), WEAKLING(1, 0.5), BEGINNER(2, 1.0), MIDDLEBROW(3, 1.5), EXPERIENCED_MIDDLEBORW(4, 2.0), ADVANCED(5,
			2.5), MASTER(6, 3.0);

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

	@Override
	public String toString() {
		return "Level{" + " value = " + value + ", winRate = " + winRate + " }";
	}
}
