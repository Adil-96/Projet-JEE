package com.microserviceTacheEmploye.web.exceptions;

public class ImpossibleAjouterTacheEmployeException extends RuntimeException {
    public ImpossibleAjouterTacheEmployeException(String message) {
        super(message);
    }
}
