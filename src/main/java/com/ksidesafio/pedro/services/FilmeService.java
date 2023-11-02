package com.ksidesafio.pedro.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ksidesafio.pedro.models.ApiResponse;
import com.ksidesafio.pedro.models.Filme;
import com.ksidesafio.pedro.repository.FilmeRepository;

import java.util.Date;
import java.util.Locale;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    private String urlBase = "https://www.omdbapi.com/?apikey=2536b146&i=";

    public ArrayList<Filme> getAll() {
        return (ArrayList<Filme>) filmeRepository.findAll();
    }

    public Filme create(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void choiceFilme(String id) {
        Locale.setDefault(Locale.US);        
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(urlBase + id, ApiResponse.class);
    
        if (response.getStatusCode() == HttpStatus.OK) {
            ApiResponse responseBody = response.getBody();
            Filme filme = new Filme();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            try {
                Date data = simpleDateFormat.parse(responseBody.Released);

                filme.setNome(responseBody.Title);
                filme.setAnoLancamento(data);
                filme.setDiretor(responseBody.Director);
                
                create(filme);
                System.out.println("Criou o filme");
            } catch (Exception e) {
                System.out.println("Erro gerado" + e.getMessage());
            }
        }
    }
}
