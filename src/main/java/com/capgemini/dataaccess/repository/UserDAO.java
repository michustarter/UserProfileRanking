package com.capgemini.dataaccess.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.exceptions.NullUsersException;

@Repository
public class UserDAO {

	private Map<String, UserEntity> usersMap;

	public UserDAO() {
		usersMap = new HashMap<>();

	}

	public void createUsers() {

		usersMap.put("michal@wp.pl", new UserEntity("Michal", "Rataj", "michal@wp.pl", "qwerty12", "Wstawaj i walcz!"));
		usersMap.put("krzysiek@onet.pl",
				new UserEntity("Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!"));
		usersMap.put("monika@interia.pl",
				new UserEntity("Monika", "Stróżewska", "monika@interia.pl", "gvcdgf04040", "Walczę do końca!"));
		usersMap.put("jakub@gmail.com", new UserEntity("Jakub", "Jasiński", "jakub@gmail.com", "ergdse54", "Do boju!"));
		usersMap.put("jaca@wpw.pl", new UserEntity("Jacek", "Placek", "jaca@wpw.pl", "234rtgvd", "Aaaaaaaaa!!!"));
	}

	public Set<UserEntity> getUsersEntity() {
		return usersMap.values().stream().collect(Collectors.toSet());
	}

	public UserEntity findUserByEmail(String email) throws NullUsersException {
		if (!(usersMap.keySet().contains(email))) {
			throw new NullUsersException();
		}

		return usersMap.get(email);
	}

	public int checkNumberOfUsers() {
		return usersMap.size();
	}

	public void modifyUserEntity(UserEntity user) {
		usersMap.put(user.getEmail(), user);
	}

	public void addNewUserEntity(UserEntity user) {
		usersMap.put(user.getEmail(), user);
	}
}
