package com.capgemini.service;

import com.capgemini.enums.Level;

public class UserDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private Level level;

	public UserDTO() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.lifeMotto = "";
		this.level = Level.NEWBIE;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	

}