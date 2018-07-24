package com.capgemini.dataaccess.repository;

import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.BoardGameEntity;

@Repository
public class BoardGamesDAO {
	
	private BoardGameEntity boardGameEntity;

	HashSet<BoardGameEntity> gamesSet = new HashSet<>();

	/*
	public void createGamesSet() {
		gamesSet.add(new BoardGameEntity("Chess", 10, 2));
		gamesSet.add(new BoardGameEntity("Monopoly", 16, 5));
		gamesSet.add(new BoardGameEntity("Splendor", 8, 1));
		gamesSet.add(new BoardGameEntity("Cortex", 12, 3));
		gamesSet.add(new BoardGameEntity("Dixit", 20, 4));
	}
	*/
	
	/* 
	 * z BOARD GAME ENTITY:
	 * 
	 * /*
 * 
 *  --- TO SOBIE ZAPISZĘ NA mapę gier wszystkich userów - 1 user - to klucz - value - to zbiór set - najpierw dla danego uzytkownika daję zbiór gier 
 *  ---> tworzę Set, tam doddaje gry a potem tworzę mapę jako klucz userID i jako value zbiór Set...
 */
	//private String userID;
	 


}
