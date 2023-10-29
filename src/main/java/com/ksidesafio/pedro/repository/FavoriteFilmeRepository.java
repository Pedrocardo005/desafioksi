package com.ksidesafio.pedro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksidesafio.pedro.models.FavoriteFilme;

@Repository
public interface FavoriteFilmeRepository extends JpaRepository<FavoriteFilme, Integer> {
    
}
