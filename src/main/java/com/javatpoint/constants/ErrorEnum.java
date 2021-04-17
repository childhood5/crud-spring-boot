package com.javatpoint.constants;

/**
 * List of all errors
 * 
 * @author phamrichard
 *
 */
public enum ErrorEnum {

	INVALID_BOOKID("400", "Invalid bookid"),
	INVALID_AUTHOR("401", "Invalid author");

	private String code;
	
	private String message;

	/**
	 * Initial constructor of ErrorEnum
	 * 
	 * @param code
	 * @param message
	 */
	ErrorEnum(final String code, final String message) {
		this.code = code;
		this.message = message;
	}

	// Get code
	public String getCode() {
		return code;
	}

	// Set code
	public void setCode(String code) {
		this.code = code;
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
