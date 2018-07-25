package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dataaccess.repository.UserDAO;

@Service
public class UserService {
	
	private UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	
	
	public void addAvailabilityHours(UserDAO userDAO) { //DTO==== np user o nazwie Michal1234 dodaję tutaj
	//	us
		
	}
}
