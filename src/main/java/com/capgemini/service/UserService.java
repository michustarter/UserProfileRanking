package com.capgemini.service;

import com.capgemini.service.dto.UserDTO;

public interface UserService {

	UserDTO getProfile(Long userId);

	void createProfile(UserDTO userDTO);

	UserDTO editProfile(UserDTO userDTO);
}
		
