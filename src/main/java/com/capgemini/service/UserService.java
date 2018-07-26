package com.capgemini.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dataaccess.entity.BoardGameEntity;
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
			UserEntity userEntity = userDAO.findByID(userID);
			return userMapper.mapToDTOfromEntity(userEntity);
		} catch (NullUsersException e) {
			throw new NullUsersException();
		}
	}

	public void saveModificationsInUserProfile(UserDTO userDTO) {
		userDAO.save(userMapper.mapToEntityFromDTO(userDTO));
	}

	public UserDTO editMyProfileInformation(UserDTO userDTO) {
			
		if (userDTO == null) {
			return null;
		}
		userDAO.update(userMapper.mapToEntityFromDTO(userDTO));
		
		saveModificationsInUserProfile(userDTO);
		return userDTO;
	}
}
		
