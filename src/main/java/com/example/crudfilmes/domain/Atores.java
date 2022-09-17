package com.example.crudfilmes.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Atores {
    @Id
    @GeneratedValue
    private Long id;
    private String nomeAtor;
    private String nacionalidade;

}
