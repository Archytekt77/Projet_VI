package com.loicmaria.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    /**
     * Afficher la page d'accueil.
     * @return La page d'accueil.
     */
    @GetMapping("/home")
    public String main() {
        return "home";
    }
}