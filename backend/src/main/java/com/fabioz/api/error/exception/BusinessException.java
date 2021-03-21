package com.fabioz.api.error.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fabioz
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    /** Serial. */
	private static final long serialVersionUID = 7119597925087595157L;
	
	private final HttpStatus status;
    private final List<BusinessExceptionError> errors;

    public BusinessException(HttpStatus status, List<BusinessExceptionError> errorList) {
        this.status = status;
        this.errors = errorList;
    }

    public BusinessException(HttpStatus status, String message) {
        BusinessExceptionError error = new BusinessExceptionError(status.value(), message);
        List<BusinessExceptionError> errorList = new ArrayList<>();
        errorList.add(error);

        this.status = status;
        this.errors = errorList;
    }
}