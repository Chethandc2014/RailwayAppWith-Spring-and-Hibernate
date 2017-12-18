package com.irc.exception;

public class TrainNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public TrainNotExistException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
}
