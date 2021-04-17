package com.javatpoint.util;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.javatpoint.exception.InvalidAuthorException;
import com.javatpoint.exception.InvalidBookidException;

/**
 * Validation class
 * 
 * @author phamrichard
 *
 */
public final class ValidatorUtil {

	private ValidatorUtil() {
		// Default constructor.
	}

	/**
	 * Binding the field to occur error
	 * 
	 * @param result
	 */
	public static void validateSearchRequest(BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			errors.forEach(error -> {
				String fieldName = error.getField();
				switch (fieldName) {
					case "bookid":
						throw new InvalidBookidException();
					case "author":
						throw new InvalidAuthorException();
					default:
						break;
				}
			});
		}
	}

}
