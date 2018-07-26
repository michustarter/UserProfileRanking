package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.dataaccess.repository.UserDAO;
import com.capgemini.service.dto.UserDTO;
import com.capgemini.utils.mappers.implementations.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserDAO userDAO, UserMapper userMapper) {
		this.userDAO = userDAO;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO getProfile(Long userId) {
		final UserEntity user = userDAO.findByID(userId);
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
}
