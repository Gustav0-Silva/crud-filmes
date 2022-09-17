package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.service.FilmesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmesController {

    private FilmesService filmesService;

    @PostMapping
    public ResponseEntity<Filme> adicionaFilme(@RequestBody Filme filme) {
        filmesService.adicionaFilme(filme);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("/{buscaNome}")
    public ResponseEntity<Filme> buscarNomeFilme (@PathVariable String nomeFilme){
        Filme retorno = filmesService.buscarPeloNome(nomeFilme);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
