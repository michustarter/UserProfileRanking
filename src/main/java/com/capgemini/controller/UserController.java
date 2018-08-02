package com.capgemini.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.service.UserService;
import com.capgemini.service.dto.GameDTO;
import com.capgemini.service.dto.UserDTO;

@RestController
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users")
	public Set<UserDTO> getAllUsers() {
		return userService.getAllUSers();
	}

	@GetMapping(value = "/users/user/{userId}")
	public UserDTO getUser(@PathVariable("id") Long userId) {
		return userService.getProfile(userId);
	}
	
	@PutMapping(value="/users/user")
	public UserDTO addUser(@RequestParam("newUser") UserDTO newUser) {
		userService.createProfile(newUser);
		return userService.getProfile(newUser.getId());
	}
	@PutMapping(value="/users/user")
	public UserDTO editUser(@RequestParam("updatedUser")UserDTO updatedUser) {
		return userService.editProfile(updatedUser);
	}
	
	@DeleteMapping(value="/users/user/{id}")
	public void removeUser(@PathVariable("id") Long userId) {
		userService.deleteProfile(userId);
	}
	@DeleteMapping(value="/users/{id}") 
		public void deleteAvailability(@RequestParam("id")Long userId) {
			userService.deleteAvailabilityHours(userId);
		}
	
	@GetMapping(value="/games/user/{id}")
	public Set<GameDTO> getGames(@RequestParam("id")Long userId) {
		return userService.getUserGames(userId);
	}
	@GetMapping(value = "/users")
	public List<UserDTO> searchUsers(@RequestBody UserDTO users) {
		return userService.findUserByParameters(users);
	}
	

}
