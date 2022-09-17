package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.exception.*;
import com.example.crudfilmes.repository.FilmesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmesService {

    private final FilmesRepository filmesRepository;


    public Filme adicionaFilme(Filme filme) {
        if (filme.getNomeFilme() == null){
            throw new FilmeNomeException("Não se deve adicionar remedio sem nome");
        }
        return filmesRepository.save(filme);
    }

    public void validaFilme(Filme filme){

        if (filme.getNomeFilme() == null || filme.getNomeFilme().equals("")){
            throw new FilmeNomeException("O filme não foi adicionado por não ter um nome válido");
        }
        if (filme.getGenero()==null || filme.getGenero().equals("")){
            throw new FilmeGeneroException("O filme não foi adicionado por não ter um gênero válido");
        }
        if(filme.getAnoLancamento() <= 1984 || filme.getAnoLancamento() > 2022){
            throw new FilmeAnoException("O filme não foi adicionado por não ter um ano válido");
        }
        if(filme.getListaAtores().isEmpty()){
            throw new FilmeListaVaziaException("A lista de atores não pode estar vazia");
        }
    }

    public Filme buscarPeloNome(String nomeFilme) {
        List<Filme> listaFilmes = filmesRepository.findAll();
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().equals(nomeFilme)){
                return filme;
            }
        }
        throw new FilmeNotFound("O filme não foi encontrado na lista");
    }
}
