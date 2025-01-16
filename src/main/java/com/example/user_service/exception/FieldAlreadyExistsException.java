package com.example.user_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FieldAlreadyExistsException extends RuntimeException {

    // Getters for the fields (optional)
    private String fieldName;
    private String fieldValue;

    public FieldAlreadyExistsException(String fieldName, String fieldValue) {
        super(String.format("%s already exists with value: '%s'", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
