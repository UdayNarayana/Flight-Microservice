package com.booking.exception;

public class NoSuchFlightIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchFlightIdException() {
	}
	
	public NoSuchFlightIdException(String message) {
		super(message);
	}
	
	
}
