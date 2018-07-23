package com.capgemini.repository;

import java.util.HashSet;

import com.capgemini.dataAccess.BoardGamesDataAccess;

public class BoardGamesRepository {

	HashSet<BoardGamesDataAccess> gamesSet = new HashSet<>();

	public void createGamesSet() { // to jednak w dataAccess ??? ale muszé to dac do metody ?? 
		gamesSet.add(new BoardGamesDataAccess("Chess", 10, 2));
		gamesSet.add(new BoardGamesDataAccess("Monopoly", 16, 5));
		gamesSet.add(new BoardGamesDataAccess("Splendor", 8, 1));
		gamesSet.add(new BoardGamesDataAccess("Cortex", 12, 3));
		gamesSet.add(new BoardGamesDataAccess("Dixit", 20, 4));
	}

	/*
	 * czemu nie moge tu dodac sobie na sztywno elementów do zbioru..?
	 * gamesSet.add...
	 */

	// gamesSet.add(new B)

}
