package com.microserviceTacheEmploye.web.exceptions;

public class ImpossibleAjouterEmployeException extends RuntimeException {
    public ImpossibleAjouterEmployeException(String message) {
        super(message);
    }
}
