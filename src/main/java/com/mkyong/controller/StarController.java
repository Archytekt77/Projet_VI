package com.mkyong.controller;

import com.mkyong.entity.Star;
import com.mkyong.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.time.LocalDate;
import java.util.*;

@Controller
public class StarController {

    @Autowired
    public StarRepository starRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("acteursAmericains", this.starRepository.findAll());
        return "welcome"; //view
    }

    @GetMapping("/details")
    public String getStarById(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("star", this.starRepository.findById(id));
        return "details";
    }

    @GetMapping("/edition")
    public String edition(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("star", this.starRepository.findById(id));
        return "edition";
    }

    @PostMapping("/edition")
    public String updateStar(@PathVariable(value = "id") int id, Model model, Star star) {
        starRepository.save(star);
        model.addAttribute("star", this.starRepository.findById(id));
        return "details";
    }

    /*
    @GetMapping("/nouvelleStar")
    public String createStar(){
        return "nouvelleStar";
    }

    @PostMapping("/nouvelleStar")
    public String addStar(@ModelAttribute Star star, Model model, Star star){
        starRepository.save(star);
        return "welcome";
    }

    @PostMapping("")
    public String deleteStar(@PathVariable(value = "id") int id, Model model, Star star){
        model.addAttribute("star", starRepository.findById(id));

        starRepository.delete(star);
        return "welcome";
    }*/

}