package com.ksidesafio.pedro.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.services.FilmeService;

@Controller
@RequestMapping("")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ArrayList<Filme> getAll(){
        return filmeService.getAll();
    }
}
