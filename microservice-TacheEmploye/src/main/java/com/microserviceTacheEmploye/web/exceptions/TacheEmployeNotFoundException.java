package com.microserviceTacheEmploye.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TacheEmployeNotFoundException extends RuntimeException {
    public TacheEmployeNotFoundException(String message) {
        super(message);
    }
}
