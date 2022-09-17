package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.service.AtorService;
import com.example.crudfilmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ator")
@AllArgsConstructor
public class AtorController {

    private AtorService atorService;

    @PostMapping
    public ResponseEntity<Ator> adicionaAtor(@RequestBody Ator ator) {
        atorService.adicionaAtor(ator);
        return new ResponseEntity<>(ator, HttpStatus.CREATED);
    }

}