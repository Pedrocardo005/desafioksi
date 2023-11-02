package com.ksidesafio.pedro.controllers.API;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksidesafio.pedro.models.FavoritePost;
import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.services.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ArrayList<Filme> getAll() {
        return filmeService.getAll();
    }

    @PostMapping
    public String choiceFilme(@RequestBody FavoritePost favoritePost) {
        filmeService.choiceFilme(favoritePost.favoriteFilme);
        return "Sucesso";
    }

    @PatchMapping
    public ResponseEntity<Filme> updateFilme(@RequestBody Filme filme) {
        Filme editedFilme = filmeService.updatFilme(filme);
        return new ResponseEntity<Filme>(editedFilme, HttpStatus.OK);
    }

    @DeleteMapping("/{identifier}")
    public void deleteFilme(@PathVariable("identifier") Integer identifier) {
        filmeService.deleteFilme(identifier);
    }
}
