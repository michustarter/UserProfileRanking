package com.capgemini.utils.exceptions;

public class NullUsersException extends RuntimeException {

	private static final long serialVersionUID = -8338924742645252049L;

	public NullUsersException(String message) {
		super(message);
	}
}