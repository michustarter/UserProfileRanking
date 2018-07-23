package com.capgemini.dataAccess;

public class UserDataAccess { /*
								 * user ma PIERWSZEŃSTWO a dopiero po tym
								 * inicjuję pola Statistics i Playablity... albo
								 * odwrotnie? że muszą być one już gotowe od
								 * razu..?
								 */
	private UserPersonalDataAccess personalData;
	private UserLoginDataAccess loginData;

	private StatisticsDataAccess player;
	private PlayabilityDataAccess availability;

	public UserDataAccess(UserPersonalDataAccess personalData, UserLoginDataAccess loginData,
			StatisticsDataAccess player, PlayabilityDataAccess availability) {
		
	this.personalData=personalData;
	this.loginData=loginData;
	this.player=player;
	this.availability=availability;
	}

	public UserPersonalDataAccess getPersonalData() {
		return personalData;
	}

	public void setPersonalData(UserPersonalDataAccess personalData) {
		this.personalData = personalData;
	}

	public UserLoginDataAccess getLoginData() {
		return loginData;
	}

	public void setLoginData(UserLoginDataAccess loginData) {
		this.loginData = loginData;
	}

	public StatisticsDataAccess getPlayer() {
		return player;
	}

	public void setPlayer(StatisticsDataAccess player) {
		this.player = player;
	}

	public PlayabilityDataAccess getAvailability() {
		return availability;
	}

	public void setAvailability(PlayabilityDataAccess availability) {
		this.availability = availability;
	}

	
}
