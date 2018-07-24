package com.capgemini.entity;

import java.time.LocalTime;

public class PlayabilityDataAccess {

	private LocalTime fromHour;
	private LocalTime upToHour;
	private String userID;
	private String comment;
	
	public PlayabilityDataAccess(String userID, LocalTime fromHour, LocalTime upToHour, String comment) {
		this.userID = userID;
		this.fromHour = fromHour;
		this.upToHour = upToHour;
		this.comment = comment;
	}

	public LocalTime getFromHour() {
		return fromHour;
	}

	public void setFromHour(LocalTime fromHour) {
		this.fromHour = fromHour;
	}

	public LocalTime getUpToHour() {
		return upToHour;
	}

	public void setUpToHour(LocalTime upToHour) {
		this.upToHour = upToHour;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}