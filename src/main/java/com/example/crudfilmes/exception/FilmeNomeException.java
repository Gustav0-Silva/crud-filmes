package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmeNomeException extends ResponseStatusException {
    public FilmeNomeException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED,reason);
    }
}
