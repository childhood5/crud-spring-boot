package com.javatpoint.exception;

import org.springframework.http.HttpStatus;

/**
 * This is api error class
 * 
 * @author phamrichard
 *
 */
public class ApiError {

	private HttpStatus status;
	
	private String message;

	/**
	 * Initial constructor of ApiError
	 * 
	 * @param status
	 * @param message
	 */
	public ApiError(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	// Get status
	public HttpStatus getStatus() {
		return status;
	}

	// Set status
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	// Get message
	public String getMessage() {
		return message;
	}

	// Set message
	public void setMessage(String message) {
		this.message = message;
	}
}
