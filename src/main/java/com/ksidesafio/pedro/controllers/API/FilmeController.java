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

import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.services.FilmeService;

import jakarta.servlet.http.HttpServletRequest;

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
    public String choiceFilme(HttpServletRequest request) {
        String texto = request.getParameter("favorite_filme");
        filmeService.choiceFilme(texto);
        return "Sucesso";
    }

    @PatchMapping("/filme")
    public ResponseEntity<Filme> updateFilme(@RequestBody Filme filme) {
        Filme editedFilme = filmeService.updatFilme(filme);
        return new ResponseEntity<Filme>(editedFilme, HttpStatus.OK);
    }
}
