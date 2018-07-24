package com.capgemini.dataaccess.entity;

import org.springframework.stereotype.Component;

@Component
public class UserEntity {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	
	public UserEntity(String firstName, String lastName, String email, String password, String lifeMotto) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.password=password;
		this.lifeMotto = lifeMotto;
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
	
}
