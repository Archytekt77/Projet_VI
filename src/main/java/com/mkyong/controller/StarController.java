package com.mkyong.controller;

import com.mkyong.entity.Star;
import com.mkyong.repository.StarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.time.LocalDate;
import java.util.*;

@Controller
public class StarController {

    public StarRepository starRepository;

    public StarRepository createStar(){
        starRepository.save(new Star(1, "Aaker", "Lee", new Date(1943, 9, 25), 76, "Rintintin", false));
        starRepository.save(new Star(2, "Aaron", "Victor", new Date(1943, 9, 25), 58, "Salt", true));
        starRepository.save(new Star(3, "Abbey", "John", new Date(1943, 9, 25), 84, "Mister Freedom", false));
        starRepository.save(new Star(4, "Abbey", "John", new Date(1943, 9, 25), 84, "Mister Freedom", false));
        return starRepository;
    }

    @GetMapping("/")
    public String main(Model model) {
        createStar();
        model.addAttribute("acteursAmericains", );
        return "welcome"; //view
    }

    @GetMapping("/details")
    public String getStarById(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("star", starRepository.findById(id));
        return "details";
    }


    @GetMapping("/edition")
    public String edition(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("star", starRepository.findById(id));
        return "edition";
    }

    @PutMapping("/edition")
    public String updateStar(@PathVariable(value = "id") int id, Model model){
        Star star = starRepository.findById(id);

        star.setId(star.getId());
        star.setNom(star.getNom());
        star.setPrenom(star.getPrenom());
        star.setDateNaissance(star.getDateNaissance());
        star.setAge(star.getAge());
        star.setFilmCulte(star.getFilmCulte());
        star.setActif(star.isActif());

        Star updatedStar = starRepository.save(star);
        return "details";
    }

    @PostMapping("/edition")
    public String saveEdition(Model model, @ModelAttribute Star star) {
        System.out.println(star);
        return "details";
    }
}