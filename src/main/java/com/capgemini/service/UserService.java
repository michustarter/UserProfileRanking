package com.capgemini.service;

import java.util.List;
import java.util.Set;

import com.capgemini.service.dto.GameDTO;
import com.capgemini.service.dto.UserDTO;

public interface UserService {

	UserDTO getProfile(Long userId);

	void createProfile(UserDTO userDTO);

	UserDTO editProfile(UserDTO userDTO);
	
	void deleteProfile(Long userId);
	
	void deleteAvailabilityHours(Long userId);
	
	Set<UserDTO> getAllUSers();
	
	Set<GameDTO> getUserGames(Long userId);
	
	List<UserDTO> findUserByParameters(UserDTO user);
	
	void removeGame(Long userId, GameDTO removedGame);
}
		
