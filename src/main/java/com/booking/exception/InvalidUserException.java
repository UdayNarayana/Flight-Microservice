package com.booking.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidUserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {
		super(message);
	}
}
