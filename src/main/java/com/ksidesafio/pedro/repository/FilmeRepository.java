package com.ksidesafio.pedro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksidesafio.pedro.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    
}
