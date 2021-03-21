package com.fabioz.api.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fabioz.api.error.exception.BusinessExceptionError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fabioz
 *
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<List<BusinessExceptionError>> handleException(BindException e) {
		List<BusinessExceptionError> erros = e.getFieldErrors().stream()
                .map(fieldError -> new BusinessExceptionError(HttpStatus.BAD_REQUEST.value(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<List<BusinessExceptionError>> handleRestException(MethodArgumentNotValidException e) {
        List<BusinessExceptionError> erros = e.getFieldErrors().stream()
                .map(fieldError -> new BusinessExceptionError(HttpStatus.BAD_REQUEST.value(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
