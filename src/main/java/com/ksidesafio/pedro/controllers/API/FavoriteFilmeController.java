package com.ksidesafio.pedro.controllers.API;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<FavoriteFilme>> findAll() {
        ArrayList<FavoriteFilme> favoritos = favoriteFilmeService.findAll();
        return new ResponseEntity<ArrayList<FavoriteFilme>>( favoritos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FavoriteFilme> create(@RequestBody FavoriteFilme favoriteFilme) {
        FavoriteFilme favorite = favoriteFilmeService.create(favoriteFilme);
        return new ResponseEntity<FavoriteFilme>(favorite, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<FavoriteFilme> update(@RequestBody FavoriteFilme favoriteFilme) {
        FavoriteFilme favorite = favoriteFilmeService.update(favoriteFilme);
        return new ResponseEntity<FavoriteFilme>(favorite, HttpStatus.OK);
    }
}
