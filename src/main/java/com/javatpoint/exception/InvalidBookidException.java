package com.javatpoint.exception;

import com.javatpoint.constants.ErrorEnum;

/**
 * This is InvalidBookidException class
 * 
 * @author phamrichard
 *
 */
@ErrorCode(status = 404, code = ErrorEnum.INVALID_BOOKID)
public class InvalidBookidException extends BaseException {

  public InvalidBookidException() {
    super(ErrorEnum.INVALID_BOOKID.getMessage());
  }
}