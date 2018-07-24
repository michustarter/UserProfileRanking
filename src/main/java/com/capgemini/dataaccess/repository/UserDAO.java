package com.capgemini.dataaccess.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.UserEntity;

@Repository
public class UserDAO {

	private UserEntity userEntity;

	private Set<UserEntity> userSet;// = new HashSet<>();

	@Autowired
	public UserDAO(UserEntity userEntity) {
		this.userEntity = userEntity;
		userSet = new HashSet<>();
		userSet.add(new UserEntity("Jakub", "Jasiński", "jakub@gmail.com", "ergdse54", "Do boju!"));
	}

	// public czy private?
	public void createUsers() {
		userSet.add(new UserEntity("Michal", "Rataj", "michal@wp.pl", "qwerty12", "Wstawaj i walcz!"));
		userSet.add(new UserEntity("Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!"));
		userSet.add(new UserEntity("Monika", "Stróżewska", "monika@interia.pl", "gvcdgf04040", "Walczę do końca!"));
		// userSet.add(new UserEntity("Jakub", "Jasiński", "jakub@gmail.com",
		// "ergdse54", "Do boju!"));

	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Set<UserEntity> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserEntity> userSet) {
		this.userSet = userSet;
	}

}
