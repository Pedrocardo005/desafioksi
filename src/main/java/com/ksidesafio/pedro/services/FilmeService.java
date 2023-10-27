package com.ksidesafio.pedro.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public ArrayList<Filme> getAll() {
        return (ArrayList<Filme>) filmeRepository.findAll();
    }
}
