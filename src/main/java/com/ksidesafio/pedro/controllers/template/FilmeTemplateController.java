package com.ksidesafio.pedro.controllers.template;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksidesafio.pedro.models.FavoriteFilme;
import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.services.FavoriteFilmeService;
import com.ksidesafio.pedro.services.FilmeService;

@Controller
public class FilmeTemplateController {

    @Autowired
    private FavoriteFilmeService favoriteFilmeService;

    @Autowired
    private FilmeService filmeService;
    
    @GetMapping
    public String index(Model model) {
        ArrayList<FavoriteFilme> favoriteFilmes;
        ArrayList<Filme> filmes;
        favoriteFilmes = favoriteFilmeService.findAll();
        filmes = filmeService.getAll();

        model.addAttribute("favorite_filmes", favoriteFilmes);
        model.addAttribute("filmes", filmes);

        return "index.html";
    }
}
