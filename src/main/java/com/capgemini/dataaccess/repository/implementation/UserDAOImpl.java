package com.capgemini.dataaccess.repository.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.exceptions.UserCouldNotBeFoundException;
import com.capgemini.dataaccess.repository.CrudDAO;

@Repository
public class UserDAOImpl implements CrudDAO<UserEntity, Long> {

	private final Map<Long, UserEntity> usersMap;

	@Autowired
	public UserDAOImpl(Map<Long, UserEntity> usersMap) {
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
			throw new UserCouldNotBeFoundException("Cannot find user with given id " + userId + ".");
		}
		return usersMap.get(userId);
	}

	@Override
	public UserEntity update(UserEntity updatedUser) {
		if (!usersMap.containsKey(updatedUser.getId())) {
			throw new UserCouldNotBeFoundException(
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
			throw new UserCouldNotBeFoundException("User with given id " + userId + " doesn't exist.");
		}
		usersMap.remove(userId);
	}

	@Override
	public List<UserEntity> findAll() {
		return new ArrayList<>(usersMap.values());
	}

}
