package com.capgemini.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dataaccess.entity.GameEntity;
import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.exceptions.UserCouldNotBeFoundException;
import com.capgemini.dataaccess.mappers.implementations.UserMapper;
import com.capgemini.dataaccess.repository.implementation.UserDAOImpl;
import com.capgemini.service.UserService;
import com.capgemini.service.dto.GameDTO;
import com.capgemini.service.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	private UserDAOImpl userDAO;
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserDAOImpl userDAO, UserMapper userMapper) {
		this.userDAO = userDAO;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO getProfile(Long userId) {
		UserEntity user = userDAO.findByID(userId);
		return userMapper.mapToDTO(user);
	}

	@Override
	public void createProfile(UserDTO userDTO) {
		userDAO.save(userMapper.mapToEntity(userDTO));
	}

	@Override
	public UserDTO editProfile(UserDTO userDTO) {
		if (userDTO == null) {
			throw new NullPointerException("UserDTO cannot be null.");
		}
		userDAO.update(userMapper.mapToEntity(userDTO));
		return userDTO;
	}

	@Override
	public void deleteProfile(Long userId) {
		if (userId == null) {
			throw new NullPointerException("UserId cannot be null.");
		}
		userDAO.delete(userId);
	}

	@Override
	public void deleteAvailabilityHours(Long userId) {
		if (userId == null) {
			throw new NullPointerException("UserId cannot be null.");
		}
		UserEntity user = userDAO.findByID(userId);
		user.setAvailableFrom(null);
		user.setAvailableTo(null);
		user.setNoAvailabilityComment("I have no time.");

		userDAO.update(user);
	}

	@Override
	public Set<UserDTO> getAllUSers() {
		List<UserEntity> all = userDAO.findAll();

		Set<UserDTO> userSet = all.stream().map(user -> userMapper.mapToDTO(user)).collect(Collectors.toSet());

		return userSet;
	}

	@Override
	public void removeGame(Long userId, GameDTO removedGame) {
		if (userId == null) {
			throw new NullPointerException("UserId cannot be null.");
		}
		if (removedGame == null) {
			throw new NullPointerException("RemovedGame cannot be null.");
		}
		UserEntity user = userDAO.findByID(userId);
		if (!user.getGamesSet().contains(removedGame)) {
			throw new NullPointerException("User doesn't have this game!");
		}
		user.getGamesSet().remove(removedGame);
		userDAO.update(user);

	}

	public void addNewGame(Long userId, GameEntity newGame) {
		UserEntity user = userDAO.findByID(userId);

		if (user == null) {
			throw new UserCouldNotBeFoundException("User with given id " + userId + " doesn't exist.");
		}
		user.getGamesSet().add(newGame);
		userDAO.update(user);

	}

	public int userNumber() {
		return getAllUSers().size();
	}

	@Override
	public Set<GameDTO> getUserGames(Long userId) {
		if (!getAllUSers().contains(getProfile(userId))) {
			throw new UserCouldNotBeFoundException("User with given id " + userId + " doesn't exist.");
		}
		return getProfile(userId).getGamesSet();

	}

	@Override
	public List<UserDTO> findUserByParameters(UserDTO user) {

		String userFirstName = user.getFirstName();
		String userLastName = user.getLastName();
		String userEmail = user.getEmail();
		String userLifeMotto = user.getLifeMotto();
		List<UserEntity> allUsers = userDAO.findAll();
		List<UserEntity> usersFound = new ArrayList<>();

		if (!userFirstName.isEmpty()) {
			List<UserEntity> wantedUsers = new ArrayList<>();
			try {
				wantedUsers = allUsers.stream().filter(users -> users.getFirstName().contains(userFirstName))
						.collect(Collectors.toList());
				usersFound.addAll(wantedUsers);
			} catch (UserCouldNotBeFoundException e) {
			}

		}
		if (!userLastName.isEmpty()) {
			List<UserEntity> wantedUsers = new ArrayList<>();
			try {
				wantedUsers = allUsers.stream().filter(users -> users.getLastName().contains(userLastName))
						.collect(Collectors.toList());
				if (usersFound.size() == 0) {
					usersFound.addAll(wantedUsers);
				} else {
					usersFound.retainAll(wantedUsers);
				}
			} catch (UserCouldNotBeFoundException e) {
			}

		}
		if (!userEmail.isEmpty()) {
			List<UserEntity> wantedUsers = new ArrayList<>();
			try {
				wantedUsers = allUsers.stream().filter(users -> users.getEmail().contains(userEmail))
						.collect(Collectors.toList());
				if (usersFound.size() == 0) {
					usersFound.addAll(wantedUsers);
				} else {
					usersFound.retainAll(wantedUsers);
				}
			} catch (UserCouldNotBeFoundException e) {
			}
		}
		if (!userLifeMotto.isEmpty()) {
			List<UserEntity> wantedUsers = new ArrayList<>();
			try {
				wantedUsers = allUsers.stream().filter(users -> users.getLifeMotto().contains(userLifeMotto))
						.collect(Collectors.toList());
				if (usersFound.size() == 0) {
					usersFound.addAll(wantedUsers);
				} else {
					usersFound.retainAll(wantedUsers);
				}
			} catch (UserCouldNotBeFoundException e) {
			}
		}
		return usersFound.stream().map(users -> userMapper.mapToDTO(users)).collect(Collectors.toList());
	}

}
