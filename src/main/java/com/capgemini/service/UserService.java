package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.repository.UserDAO;
import com.capgemini.exceptions.NullUsersException;
import com.capgemini.mappers.UserMapper;

@Service
public class UserService {

	private UserDAO userDAO;
	private UserMapper userMapper;

	@Autowired
	public UserService(UserDAO userDAO, UserMapper userMapper) {
		this.userDAO = userDAO;
		this.userMapper = userMapper;
	}

	public UserDTO checkMyProfile(String email) throws NullUsersException {
		/* konstrukcja wyjątku - ok? */
		try {
			UserEntity userEntity = userDAO.findUserByEmail(email);
			return userMapper.mapToDTOfromDAO(userEntity);
		} catch (NullUsersException e) {
			throw new NullUsersException();
		}
	}

	public void saveModificationsInUserProfile(UserDTO userDTO) {
		userDAO.modifyUserEntity(userMapper.mapToDAOfromDTO(userDTO));
	}

	public UserDTO editMyProfileInformation(UserDTO userDTO, String firstName, String lastName, String email,
			String oldPassword, String newPassword, String lifeMotto) {
		if (userDTO == null) {
			throw new NullUsersException();
		}

		if (firstName != null) {
			userDTO.setFirstName(firstName);
		}
		if (lastName != null) {
			userDTO.setLastName(lastName);
		}
		if (email != null) {
			userDTO.setEmail(email);
		}
		if (newPassword != null && userDTO.getPassword().equals(oldPassword)) {
			userDTO.setPassword(newPassword);
		}
		if (lifeMotto != null) {
			userDTO.setLifeMotto(lifeMotto);
		}

		saveModificationsInUserProfile(userDTO);
		return userDTO;
	}
}
