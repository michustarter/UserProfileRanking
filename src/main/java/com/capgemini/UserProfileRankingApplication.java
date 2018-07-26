package com.capgemini;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.dataaccess.entity.UserEntity;

@SpringBootApplication
public class UserProfileRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileRankingApplication.class, args);
	}

	@Bean
	public Map<Long, UserEntity> usersMap() {
		return new HashMap<>();
	}

	@PostConstruct
	public void createUsers() {

		Map<Integer, GameEntity> gamesMap = new HashMap<>();
		gamesMap.put(Integer.valueOf(0), new GameEntity(1L, "Pytaki"));
		gamesMap.put(Integer.valueOf(1), new GameEntity(2L, "Chess"));
		gamesMap.put(Integer.valueOf(2), new GameEntity(3L, "Eurobusiness"));
		gamesMap.put(Integer.valueOf(3), new GameEntity(4L, "Dixit"));
		gamesMap.put(Integer.valueOf(4), new GameEntity(5L, "Dobble"));
		gamesMap.put(Integer.valueOf(5), new GameEntity(6L, "Cortex"));

		Set<GameEntity> set0 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set0.add(gamesMap.get(Integer.valueOf(i)));
		}
		Set<GameEntity> set1 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set1.add(gamesMap.get(Integer.valueOf(i)));
		}
		Set<GameEntity> set2 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set2.add(gamesMap.get(Integer.valueOf(i)));
		}
		Set<GameEntity> set3 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set3.add(gamesMap.get(Integer.valueOf(i)));
		}
		Set<GameEntity> set4 = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			set4.add(gamesMap.get(Integer.valueOf(i)));
		}
		Instant t1 = Instant.now();
		long hours = 1;
		long minutes = 20;
		Instant t2 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);
		Instant t3 = t1.minus(hours, ChronoUnit.HOURS).minus(minutes, ChronoUnit.MINUTES);
		Instant t4 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);
		Instant t5 = t1.minus(hours, ChronoUnit.HOURS).minus(minutes, ChronoUnit.MINUTES);
		Instant t6 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);
		Instant t7 = t1.minus(hours, ChronoUnit.HOURS).minus(minutes, ChronoUnit.MINUTES);
		Instant t8 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);
		Instant t9 = t1.minus(hours, ChronoUnit.HOURS).minus(minutes, ChronoUnit.MINUTES);
		Instant t10 = t1.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);

		//dodanie userów
		UserEntity user0 = new UserEntity(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2",
				"Jestem zwyciezca!", set0, t1, t2, "");

		UserEntity user1 = new UserEntity(2L, "Monika", "Stróżewska", "monika@interia.pl", "gvcdgf04040",
				"Walczę do końca!", set1, t3, t4, "");
		UserEntity user2 = new UserEntity(3L, "Jakub", "Jasiński", "jakub@gmail.com", "ergdse54", "Do boju!", set2, t5,
				t6, "");
		UserEntity user3 = new UserEntity(4L, "Jacek", "Placek", "jaca@wpw.pl", "234rtgvd", "Aaaaaaa!", set3, t7, t8,
				"");
		UserEntity user4 = new UserEntity(5L, "Jan", "Matejko", "matejko@fof.pl", "rthvc23432", "Oooo!", set4, t9, t10,
				"");

		// lista nowych gier:
		List<GameEntity> gameList = new ArrayList<>();
		gameList.add(new GameEntity(8L, "Zwierzaki"));
		gameList.add(new GameEntity(9L, "Snake"));
		gameList.add(new GameEntity(11L, "Jumanji"));
		gameList.add(new GameEntity(23L, "Heros"));

	}

}
