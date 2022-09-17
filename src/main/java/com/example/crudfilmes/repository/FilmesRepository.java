package com.example.crudfilmes.repository;

import com.example.crudfilmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filme, Long> {
}
