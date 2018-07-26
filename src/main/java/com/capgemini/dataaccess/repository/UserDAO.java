package com.capgemini.dataaccess.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.utils.exceptions.NullUsersException;

@Repository
public class UserDAO implements CrudDAO<UserEntity, Long> {

	private final Map<Long, UserEntity> usersMap;

	@Autowired
	public UserDAO(Map<Long, UserEntity> usersMap) {
		this.usersMap = usersMap;
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		if (userEntity == null) {
			throw new NullPointerException("User cannot be null");
		}
		usersMap.put(userEntity.getId(), userEntity);
		return usersMap.get(userEntity.getId());
	}

	@Override
	public UserEntity findByID(Long userId) {
		if (!usersMap.containsKey(userId)) {
			throw new NullUsersException("Cannot find user with given id " + userId + ".");
		}
		return usersMap.get(userId);
	}

	@Override
	public UserEntity update(UserEntity updatedUser) {
		if (!usersMap.containsKey(updatedUser.getId())) {
			throw new NullUsersException(
					"Cannot createProfile user with id: " + updatedUser.getId() + ". User doesn't exist.");
		}

		long idOfUpdate = updatedUser.getId();
		UserEntity user = usersMap.get(idOfUpdate);
		if (updatedUser.getFirstName() != null) {
			user.setFirstName(updatedUser.getFirstName());
		}
		if (updatedUser.getLastName() != null) {
			user.setLastName(updatedUser.getLastName());
		}
		if (updatedUser.getEmail() != null) {
			user.setEmail(updatedUser.getEmail());
		}
		if (updatedUser.getPassword() != null) {
			user.setPassword(updatedUser.getPassword());
		}
		if (updatedUser.getLifeMotto() != null) {
			user.setLifeMotto(updatedUser.getLifeMotto());
		}
		if (updatedUser.getGamesSet() != null) {
			user.setGamesSet(updatedUser.getGamesSet());
		}
		if (updatedUser.getAvailableFrom() != user.getAvailableFrom()
				|| updatedUser.getAvailableTo() != user.getAvailableTo()
						&& !"".equals(updatedUser.getNoAvailabilityComment())) {
			user.setNoAvailabilityComment(updatedUser.getNoAvailabilityComment());
		}
		if (updatedUser.getAvailableFrom() != null && updatedUser.getAvailableFrom() != user.getAvailableFrom()) {
			user.setAvailableFrom(updatedUser.getAvailableFrom());
		}
		if (updatedUser.getAvailableTo() != null && updatedUser.getAvailableTo() != user.getAvailableTo()) {
			user.setAvailableTo(updatedUser.getAvailableTo());

		}

		return user;
	}

	@Override
	public void delete(Long userId) {
		if (!usersMap.containsKey(userId)) {
			throw new NullUsersException("User with given id " + userId + " doesn't exist.");
		}
	}

	@Override
	public List<UserEntity> findAll() {
		return null;
	}

	public void deleteAvailability(Long userID) {
		usersMap.get(userID).setAvailableFrom(null);
		usersMap.get(userID).setAvailableTo(null);
		usersMap.get(userID).setNoAvailabilityComment("Nie mam czasu.");
	}

	public Set<UserEntity> getUsers() {
		return new HashSet<>(usersMap.values());
	}

	public int usersNumber() {
		return usersMap.size();
	}

	public Set<GameEntity> getUserGames(Long userId) {
		if (!usersMap.containsKey(userId)) {
			throw new NullUsersException("elo");
		}
		return usersMap.get(userId).getGamesSet();
	}

	public void removeUserGame(Long userId, GameEntity removedGame) {
		if (!usersMap.containsKey(userId)) {
			throw new NullUsersException("Dupa");
		}

		final Set<GameEntity> gamesSet = usersMap.get(userId).getGamesSet();
		if (gamesSet == null) {
			throw new NullPointerException("User doesn't have games.");
		}
		gamesSet.remove(removedGame);
	}

	public void addNewGame(Long userId, GameEntity newGame) {
		if (!usersMap.containsKey(userId)) {
			throw new NullUsersException("User with given id " + userId + " doesn't exist.");
		}
		usersMap.get(userId).getGamesSet().add(newGame);
	}
}
