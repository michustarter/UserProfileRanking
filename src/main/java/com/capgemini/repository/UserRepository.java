package com.capgemini.repository;

import com.capgemini.dataAccess.UserLoginDataAccess;
import com.capgemini.dataAccess.UserPersonalDataAccess;

public class UserRepository {

	public UserPersonalDataAccess setPersonalData(String firstName, String lastName, String lifeMotto) {

		UserPersonalDataAccess userData = new UserPersonalDataAccess(firstName, lastName, lifeMotto);

		return userData;
	}

	public UserLoginDataAccess setLoginData(String email, String password) {
		UserLoginDataAccess loginData = new UserLoginDataAccess(email, password);
		return loginData;
	}
	
	//public StatisticsDataAccess setUserStatistics() {
		
	//}

	/*
	 * tutaj nowych uzytkowników tworzyć, 2-3 na poczatek zeby bylo z czego /
	 * wybierać tutaj dodaje tzn ustawiam availiilityh hours?
	 */

}
