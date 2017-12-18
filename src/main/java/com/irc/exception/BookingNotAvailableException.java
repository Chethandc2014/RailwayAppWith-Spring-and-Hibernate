package com.irc.exception;

public class BookingNotAvailableException extends Exception {

	String message;
	public BookingNotAvailableException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
