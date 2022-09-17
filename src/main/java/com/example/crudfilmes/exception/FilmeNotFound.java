package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmeNotFound extends ResponseStatusException {
    public FilmeNotFound(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
