package com.ksidesafio.pedro.controllers.API;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksidesafio.pedro.models.FavoriteFilme;
import com.ksidesafio.pedro.services.FavoriteFilmeService;

@RestController
@RequestMapping("/favorite_filme")
public class FavoriteFilmeController {
    @Autowired
    FavoriteFilmeService favoriteFilmeService;

    @GetMapping
    public ArrayList<FavoriteFilme> findAll() {
        return favoriteFilmeService.findAll();
    }

    @PostMapping
    public FavoriteFilme create(@RequestBody FavoriteFilme favoriteFilme) {
        return favoriteFilmeService.create(favoriteFilme);
    }

    @PatchMapping
    public FavoriteFilme update(@RequestBody FavoriteFilme favoriteFilme) {
        return favoriteFilmeService.update(favoriteFilme);
    }
}
