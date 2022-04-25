package com.booking.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchFlightIdException.class)
	public ResponseEntity<ErrorDetails> handleNoFlightIdFound(NoSuchFlightIdException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				HttpStatus.NOT_FOUND, 
				LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoDataExists(NoDataFoundException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				HttpStatus.NOT_FOUND, 
				LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ErrorDetails> handleInvalidFormatOfData(InvalidFormatException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				HttpStatus.NOT_FOUND, 
				LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorDetails> handleInvalidUser(InvalidUserException ex){
		ErrorDetails error = new ErrorDetails(
				ex.getMessage(), 
				HttpStatus.NOT_FOUND, 
				LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
}
