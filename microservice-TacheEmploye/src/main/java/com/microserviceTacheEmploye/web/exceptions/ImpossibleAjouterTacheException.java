package com.microserviceTacheEmploye.web.exceptions;

public class ImpossibleAjouterTacheException extends RuntimeException {
    public ImpossibleAjouterTacheException(String message) {
        super(message);
    }
}
