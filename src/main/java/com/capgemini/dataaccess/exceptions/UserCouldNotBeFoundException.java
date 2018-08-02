package com.capgemini.dataaccess.exceptions;

public class UserCouldNotBeFoundException extends RuntimeException {

	private static final long serialVersionUID = -8338924742645252049L;

	public UserCouldNotBeFoundException(String message) {
		super(message);
	}
}