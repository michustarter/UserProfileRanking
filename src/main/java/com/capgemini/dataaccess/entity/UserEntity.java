package com.capgemini.dataaccess.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserEntity {

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

	public UserEntity() {
	}

	public UserEntity(Long id, String firstName, String lastName, String email, String password, String lifeMotto,
			Set<GameEntity> gamesSet, Instant availableFrom, Instant availableTo, String noAvailabilityComment) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserEntity that = (UserEntity) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
			return false;
		if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null)
			return false;
		if (email != null ? !email.equals(that.email) : that.email != null)
			return false;
		if (password != null ? !password.equals(that.password) : that.password != null)
			return false;
		if (lifeMotto != null ? !lifeMotto.equals(that.lifeMotto) : that.lifeMotto != null)
			return false;
		if (gamesSet != null ? !gamesSet.equals(that.gamesSet) : that.gamesSet != null)
			return false;
		if (availableFrom != null ? !availableFrom.equals(that.availableFrom) : that.availableFrom != null)
			return false;
		if (availableTo != null ? !availableTo.equals(that.availableTo) : that.availableTo != null)
			return false;
		return noAvailabilityComment != null ? noAvailabilityComment.equals(that.noAvailabilityComment)
				: that.noAvailabilityComment == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (lifeMotto != null ? lifeMotto.hashCode() : 0);
		result = 31 * result + (gamesSet != null ? gamesSet.hashCode() : 0);
		result = 31 * result + (availableFrom != null ? availableFrom.hashCode() : 0);
		result = 31 * result + (availableTo != null ? availableTo.hashCode() : 0);
		result = 31 * result + (noAvailabilityComment != null ? noAvailabilityComment.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserEntity{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", password='" + password + '\'' + ", lifeMotto='" + lifeMotto + '\''
				+ ", games=" + gamesSet.size() + ", availableFrom=" + availableFrom + ", availableTo=" + availableTo
				+ ", noAvailabilityComment='" + noAvailabilityComment + '\'' + '}';
	}
}
