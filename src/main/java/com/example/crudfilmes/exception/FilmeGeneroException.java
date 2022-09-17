package com.example.crudfilmes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmeGeneroException extends ResponseStatusException {
    public FilmeGeneroException(String reason) {
        super(HttpStatus.NOT_IMPLEMENTED, reason);
    }
}
