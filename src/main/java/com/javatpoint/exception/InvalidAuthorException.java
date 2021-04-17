package com.javatpoint.exception;

import com.javatpoint.constants.ErrorEnum;

/**
 * This is InvalidAuthorException class
 * 
 * @author phamrichard
 *
 */
@ErrorCode(status = 404, code = ErrorEnum.INVALID_AUTHOR)
public class InvalidAuthorException extends BaseException {

  public InvalidAuthorException() {
    super(ErrorEnum.INVALID_AUTHOR.getMessage());
  }
}