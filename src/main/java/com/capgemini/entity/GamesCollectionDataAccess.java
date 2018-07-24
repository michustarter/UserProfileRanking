package com.capgemini.entity;

/**
 * reprezentacja gier planszowych
 *
 */
public class GamesCollectionDataAccess {
/*
 * jaką grę ma użytkownik, ok, ale po co ilośc wygranych punktow tutaj? to moze dac w rozgrywkach? to lepiej rozbić...
 *  --- TO SOBIE ZAPISZĘ NA mapę gier wszystkich userów - 1 user - to klucz - value - to zbiór set - najpierw dla danego uzytkownika daję zbiór gier 
 *  ---> tworzę Set, tam doddaje gry a potem tworzę mapę jako klucz userID i jako value zbiór Set...
 */
	//private String userID;
	private String title;
	

	public GamesCollectionDataAccess(/*String userID, */String title) {
		//this.userID = userID;
		this.title = title;
	}

/*	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
