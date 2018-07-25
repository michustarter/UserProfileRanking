package com.capgemini.dataaccess.repository;

import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.BoardGameEntity;

@Repository
public class BoardGamesDAO {
	
	private BoardGameEntity boardGameEntity;

	HashSet<BoardGameEntity> gamesSet = new HashSet<>();

}
