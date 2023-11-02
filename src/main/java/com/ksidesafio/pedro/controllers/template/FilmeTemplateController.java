package com.ksidesafio.pedro.controllers.template;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksidesafio.pedro.models.FavoriteFilme;
import com.ksidesafio.pedro.services.FavoriteFilmeService;

@Controller
public class FilmeTemplateController {

    @Autowired
    private FavoriteFilmeService favoriteFilmeService;
    
    @GetMapping
    public String index(Model model) {
        ArrayList<FavoriteFilme> favoriteFilmes;
        favoriteFilmes = favoriteFilmeService.findAll();
        model.addAttribute("favorite_filmes", favoriteFilmes);
        return "index.html";
    }
}
