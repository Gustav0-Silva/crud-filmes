package com.example.crudfilmes.controller;

import com.example.crudfilmes.domain.Atores;
import com.example.crudfilmes.domain.Filme;
import com.example.crudfilmes.service.FilmesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmesControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void inserePorApi(){
        Atores ator1 = new Atores();
        ator1.setNomeAtor("Emile Hirsch");
        ator1.setNacionalidade("Americano");

        Atores ator2 = new Atores();
        ator2.setNomeAtor("Kristen Stewart");
        ator2.setNacionalidade("Americana");

        List<Atores> listaAtores = new ArrayList<>();
        listaAtores.add(ator1);
        listaAtores.add(ator2);

        Filme filme = new Filme();
        filme.setId(1L);
        filme.setNomeFilme("Into The Wild");
        filme.setGenero("Drama");
        filme.setAnoLancamento(2007);
        filme.setListaAtores(listaAtores);

        ResponseEntity<Filme> filmeResposta = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/filmes",
                        filme, Filme.class);


//        Filme filmeResposta = filmesService.adicionaFilme(filme);

        Assertions.assertEquals(HttpStatus.CREATED, filmeResposta.getStatusCode());
    }
}
