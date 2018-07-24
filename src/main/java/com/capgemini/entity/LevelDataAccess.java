package com.capgemini.entity;


public enum LevelDataAccess {
	NEWBIE(0.0),
	WEAKLING(0.5),
	BEGINNER(1.0),
	EXPERIENCED_BEGINNER(1.5),
	MIDDLEBROW(2.0),
	EXPERIENCED_MIDDLEBORW(2.5),
	ADVANCED(3.0),
	PROFESSIONAL(3.5),
	MASTER(4.0);
/* gdzieś musze zliczać ilośc granych gier... dać pole INT gdzies... i ilosc wygranych..*/ 
	private final double gamesWon;

	LevelDataAccess(double  gamesWon) {
		this.gamesWon=gamesWon;
	}

	public double getGamesWon() {
		return gamesWon;
	}


}

