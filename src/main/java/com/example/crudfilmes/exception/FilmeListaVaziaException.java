package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmeListaVaziaException extends ResponseStatusException {
    public FilmeListaVaziaException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
