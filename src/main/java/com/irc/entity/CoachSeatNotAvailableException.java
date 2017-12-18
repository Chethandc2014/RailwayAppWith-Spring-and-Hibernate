package com.irc.entity;

public class CoachSeatNotAvailableException extends Exception {

	String message;
	
	public CoachSeatNotAvailableException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
}
