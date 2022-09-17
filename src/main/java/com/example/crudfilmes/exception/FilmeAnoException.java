package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmeAnoException extends ResponseStatusException {
    public FilmeAnoException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
