package com.capgemini.dataaccess.entity;

import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class PlayabilityEntity {

	private Instant fromHour;
	private Instant upToHour;
	private UserEntity gamer;
	private String comment;
	
	public PlayabilityEntity(UserEntity gamer, Instant fromHour, Instant upToHour, String comment) {
		this.setGamer(gamer);
		this.fromHour = fromHour;
		this.upToHour = upToHour;
		this.comment = comment;
	}

	public Instant getFromHour() {
		return fromHour;
	}

	public void setFromHour(Instant fromHour) {
		this.fromHour = fromHour;
	}

	public Instant getUpToHour() {
		return upToHour;
	}

	public void setUpToHour(Instant upToHour) {
		this.upToHour = upToHour;
	}

	public UserEntity getGamer() {
		return gamer;
	}

	public void setGamer(UserEntity gamer) {
		this.gamer = gamer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}