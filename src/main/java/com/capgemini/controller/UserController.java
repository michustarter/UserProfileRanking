package com.capgemini.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dataaccess.exceptions.UserCouldNotBeFoundException;
import com.capgemini.service.UserService;
import com.capgemini.service.dto.GameDTO;
import com.capgemini.service.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public Set<UserDTO> getAllUsers() {
		return userService.getAllUSers();
	}

	@GetMapping(value = "/{id}")
	public UserDTO getUser(@PathVariable("id") Long userId) {
		return userService.getProfile(userId);
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUser) {
		userService.createProfile(newUser);
		UserDTO createdUser = userService.getProfile(newUser.getId());
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO updatedUser) {
		UserDTO editedUser = userService.editProfile(updatedUser);
		return new ResponseEntity<>(editedUser, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeUser(@PathVariable("id") Long userId) {
		userService.deleteProfile(userId);
	}

	@DeleteMapping(value = "/availability/{userId}")
	public void deleteAvailability(@PathVariable("userId") Long userId) {
		userService.deleteAvailabilityHours(userId);
	}

	@GetMapping(value = "/games/{userId}")
	public Set<GameDTO> getGames(@PathVariable("userId") Long userId) {
		return userService.getUserGames(userId);
	}

	@GetMapping(value = "/search")
	public List<UserDTO> searchUsers(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "lifeMotto") String lifeMotto
	) 
	{
		UserDTO searchUsersParams = new UserDTO();
		searchUsersParams.setFirstName(firstName);
		searchUsersParams.setLastName(lastName);
		searchUsersParams.setEmail(email);
		searchUsersParams.setLifeMotto(lifeMotto);
		return userService.findUserByParameters(searchUsersParams);
	}
	
	@ExceptionHandler(UserCouldNotBeFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String userCouldNotBeFoundException(Exception e) {
		LOGGER.error("An error has occurred: ", e);
		return e.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String userHandleException(Exception e) {
		LOGGER.error("An error has occurred: ", e);
		return e.getMessage();
	}
}

