package com.fabioz.api.error.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fabioz
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessExceptionError {
    @JsonProperty("status_code")
    private Integer status;
    private String message;
}