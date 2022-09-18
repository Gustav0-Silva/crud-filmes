package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
@AllArgsConstructor
public class FilmeController {

    private final FilmeService filmesService;

    @PostMapping
    public ResponseEntity<Filme> adicionaFilme(@RequestBody Filme filme) {
        Filme retorno = filmesService.adicionaFilme(filme);
        return new ResponseEntity<>(retorno, HttpStatus.CREATED);
    }

    @GetMapping("/{buscarNome}")
    public ResponseEntity<Filme> buscarNomeFilme (@PathVariable String buscarNome){
        Filme retorno = filmesService.buscarPeloNome(buscarNome);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/{buscarGenero}")
    public ResponseEntity <List<Filme>> buscarGeneroFilme (@PathVariable String buscarGenero){
        List<Filme> retorno = filmesService.buscarPeloGenero(buscarGenero);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/{buscarAno}")
    public ResponseEntity <List<Filme>> buscarGeneroFilme (@PathVariable Integer buscarAno){
        List<Filme> retorno = filmesService.buscarPeloAno(buscarAno);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
