package com.ksidesafio.pedro.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksidesafio.pedro.models.FavoriteFilme;
import com.ksidesafio.pedro.repository.FavoriteFilmeRepository;

@Service
public class FavoriteFilmeService {
    
    @Autowired
    private FavoriteFilmeRepository favoriteFilmeRepository;

    public ArrayList<FavoriteFilme> findAll() {
        return (ArrayList<FavoriteFilme>) favoriteFilmeRepository.findAll();
    }

    public FavoriteFilme create(FavoriteFilme favoriteFilme) {
        return favoriteFilmeRepository.save(favoriteFilme);
    }

    public FavoriteFilme update(FavoriteFilme favoriteFilme) {
        return favoriteFilmeRepository.save(favoriteFilme);
    }
}
