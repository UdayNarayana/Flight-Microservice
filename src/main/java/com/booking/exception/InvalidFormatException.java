package com.booking.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidFormatException(String message) {
		super(message);
	}
}
