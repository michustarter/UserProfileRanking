package com.capgemini.service.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private Set<GameDTO> gamesSet;
	private Instant availableFrom;
	private Instant availableTo;
	private String noAvailabilityComment;

	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email, String password, String lifeMotto,
			Set<GameDTO> gamesSet, Instant availableFrom, Instant availableTo, String noAvailabilityComment) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.gamesSet = new HashSet<>();
		this.availableFrom = availableFrom;
		this.availableTo = availableTo;
		this.noAvailabilityComment = noAvailabilityComment;
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

	public Set<GameDTO> getGamesSet() {
		return gamesSet;
	}

	public void setGamesSet(Set<GameDTO> gamesSet) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableFrom == null) ? 0 : availableFrom.hashCode());
		result = prime * result + ((availableTo == null) ? 0 : availableTo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gamesSet == null) ? 0 : gamesSet.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lifeMotto == null) ? 0 : lifeMotto.hashCode());
		result = prime * result + ((noAvailabilityComment == null) ? 0 : noAvailabilityComment.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (availableFrom == null) {
			if (other.availableFrom != null)
				return false;
		} else if (!availableFrom.equals(other.availableFrom))
			return false;
		if (availableTo == null) {
			if (other.availableTo != null)
				return false;
		} else if (!availableTo.equals(other.availableTo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gamesSet == null) {
			if (other.gamesSet != null)
				return false;
		} else if (!gamesSet.equals(other.gamesSet))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lifeMotto == null) {
			if (other.lifeMotto != null)
				return false;
		} else if (!lifeMotto.equals(other.lifeMotto))
			return false;
		if (noAvailabilityComment == null) {
			if (other.noAvailabilityComment != null)
				return false;
		} else if (!noAvailabilityComment.equals(other.noAvailabilityComment))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", lifeMotto=" + lifeMotto + ", gamesSet=" + gamesSet + ", availableFrom="
				+ availableFrom + ", availableTo=" + availableTo + ", noAvailabilityComment=" + noAvailabilityComment
				+ "]";
	}

}