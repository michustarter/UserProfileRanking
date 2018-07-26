package com.capgemini.service;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.dataaccess.entity.GameEntity;

public class UserDTO { // bez adnotacji tutaj!!
	
	private Long id;
	private String firstName;                                                  
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private Set<GameEntity> gamesSet;
	private Instant availableFrom;
    private Instant availableTo;
    private String noAvailabilityComment;
	

	public UserDTO() {
		this.id=null;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.lifeMotto = "";
		this.gamesSet = new HashSet<>();
		this.availableFrom=null;
		this.availableTo=null;
		this.noAvailabilityComment="";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getLifeMotto() {
		return lifeMotto;
	}


	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}


	public Set<GameEntity> getGamesSet() {
		return gamesSet;
	}


	public void setGamesSet(Set<GameEntity> gamesSet) {
		this.gamesSet = gamesSet;
	}


	public Instant getAvailableFrom() {
		return availableFrom;
	}


	public void setAvailableFrom(Instant availableFrom) {
		this.availableFrom = availableFrom;
	}


	public Instant getAvailableTo() {
		return availableTo;
	}


	public void setAvailableTo(Instant availableTo) {
		this.availableTo = availableTo;
	}


	public String getNoAvailabilityComment() {
		return noAvailabilityComment;
	}


	public void setNoAvailabilityComment(String noAvailabilityComment) {
		this.noAvailabilityComment = noAvailabilityComment;
	}

}