package com.ksidesafio.pedro.controllers.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeTemplateController {

    private String[] filmes = {"Os vingadores", "Capitão américa"};
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("filmes", filmes);
        return "index.html";
    }
}
