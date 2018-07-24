package com.capgemini.dataaccess.entity;

import org.springframework.stereotype.Component;

@Component
public class BoardGameEntity {

	private String title;
	

	public BoardGameEntity(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
