package com.booking.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	private String errorMessage;
	private HttpStatus status;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy hh.mm.ss")
	private LocalDateTime timestamp;
	
}
