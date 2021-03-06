package com.mbsystems.quickpolldemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND )
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
