package com.capgemini.repository;

import java.util.HashSet;

import com.capgemini.entity.GamesCollectionDataAccess;

public class BoardGamesRepository {

	HashSet<GamesCollectionDataAccess> gamesSet = new HashSet<>();

	public void createGamesSet() { // to jednak w dataAccess ??? ale muszé to dac do metody ?? 
		gamesSet.add(new GamesCollectionDataAccess("Chess", 10, 2));
		gamesSet.add(new GamesCollectionDataAccess("Monopoly", 16, 5));
		gamesSet.add(new GamesCollectionDataAccess("Splendor", 8, 1));
		gamesSet.add(new GamesCollectionDataAccess("Cortex", 12, 3));
		gamesSet.add(new GamesCollectionDataAccess("Dixit", 20, 4));
	}

	/*
	 * czemu nie moge tu dodac sobie na sztywno elementów do zbioru..?
	 * gamesSet.add...
	 */

	// gamesSet.add(new B)

}
