package com.fabioz.api.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fabioz.api.error.exception.BusinessException;
import com.fabioz.api.error.exception.BusinessExceptionError;

/**
 * @author fabioz
 *
 */
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionError> handleBusinessExceptions(BusinessException e) {		
		BusinessExceptionError error = new BusinessExceptionError(HttpStatus.BAD_REQUEST.value(), e.getErrors().get(0).getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
