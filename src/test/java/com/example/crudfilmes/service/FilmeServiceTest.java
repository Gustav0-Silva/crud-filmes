package com.example.crudfilmes.service;

import com.example.crudfilmes.domain.Ator;
import com.example.crudfilmes.domain.Filme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

@SpringBootTest
public class FilmeServiceTest {
    @Autowired
    AtorService atorService;

    @Autowired
    FilmeService filmesService;

    @Test
    public void adicionaAtorTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Gustavinho")
                .nacionalidade("Nigeriano")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Marthina")
                .nacionalidade("Camponesa")
                .build();

        atorService.adicionaAtor(ator1);
        atorService.adicionaAtor(ator2);

        Filme filme = Filme.builder()
                .nomeFilme("A espera de um milagre")
                .anoLancamento(2004)
                .listaAtores(List.of(ator1,ator2))
                .genero("Drama")
                .build();

        Filme filmeRetorno = filmesService.adicionaFilme(filme);

        Assertions.assertEquals(filme,filmeRetorno);
    }
    @Test
    public void buscaPorGeneroTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Gustavo")
                .nacionalidade("Colombiano")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Marthina")
                .nacionalidade("Francesa")
                .build();

        atorService.adicionaAtor(ator1);
        atorService.adicionaAtor(ator2);

        Filme filme1 = Filme.builder()
                .nomeFilme("A espera de um milagre")
                .anoLancamento(2004)
                .listaAtores(List.of(ator1,ator2))
                .genero("Drama")
                .build();


       filmesService.adicionaFilme(filme1);

        List<Filme> retorno = filmesService.buscarPeloGenero("Drama");

        Assertions.assertEquals(retorno.get(0).getNomeFilme(), filme1.getNomeFilme());
        Assertions.assertEquals(retorno.get(0).getAnoLancamento(), filme1.getAnoLancamento());
    }
    @Test
    public void buscaPorAnoTest(){
        Ator ator1 = Ator.builder()
                .nomeAtor("Gustavo")
                .nacionalidade("Colombiano")
                .build();

        Ator ator2 = Ator.builder()
                .nomeAtor("Marthina")
                .nacionalidade("Francesa")
                .build();

        atorService.adicionaAtor(ator1);
        atorService.adicionaAtor(ator2);

        Filme filme = Filme.builder()
                .nomeFilme("A espera de um milagre")
                .anoLancamento(2004)
                .listaAtores(List.of(ator1,ator2))
                .genero("Drama")
                .build();

        filmesService.adicionaFilme(filme);

        List<Filme> retorno = filmesService.buscarPeloAno(2004);

        Assertions.assertEquals(retorno.get(0).getNomeFilme(), filme.getNomeFilme());
        Assertions.assertEquals(retorno.get(0).getAnoLancamento(), filme.getAnoLancamento());
    }

}