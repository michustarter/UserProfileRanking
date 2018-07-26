package com.capgemini;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.repository.BoardGameDAO;

@SpringBootApplication
public class UserProfileRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileRankingApplication.class, args);
	}

	@PostConstruct
	public void createUsers() {
		final BoardGameDAO boardGamesDAO = new BoardGameDAO(new HashMap<>());

		Set<BoardGameEntity> set0 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set0.add(boardGamesDAO.getGamesMap().get(Integer.valueOf(i)));
		}
		Set<BoardGameEntity> set1 = new HashSet<>();
		for (int i = 1; i < 4; i++) {
			set1.add(boardGamesDAO.getGamesMap().get(Integer.valueOf(i)));
		}
		Set<BoardGameEntity> set2 = new HashSet<>();
		for (int i = 2; i < 5; i++) {
			set2.add(boardGamesDAO.getGamesMap().get(Integer.valueOf(i)));
		}
		Set<BoardGameEntity> set3 = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			set3.add(boardGamesDAO.getGamesMap().get(Integer.valueOf(i)));
		}
		Set<BoardGameEntity> set4 = new HashSet<>();
		for (int i = 1; i < 5; i++) {
			set4.add(boardGamesDAO.getGamesMap().get(Integer.valueOf(i)));
		}

		usersMap.put("krzysiek@onet.pl",
				new UserEntity("Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!", set1));
		usersMap.put("monika@interia.pl",
				new UserEntity("Monika", "Stróżewska", "monika@interia.pl", "gvcdgf04040", "Walczę do końca!", set2));
		usersMap.put("jakub@gmail.com",
				new UserEntity("Jakub", "Jasiński", "jakub@gmail.com", "ergdse54", "Do boju!", set3));
		usersMap.put("jaca@wpw.pl", new UserEntity("Jacek", "Placek", "jaca@wpw.pl", "234rtgvd", "Aaaaaaa!", set4));
	}

}
