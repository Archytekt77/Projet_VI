package com.mkyong.controller;

import com.mkyong.entity.Star;
import com.mkyong.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
public class StarController {

    @Autowired
    public StarRepository starRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("star", this.starRepository.findAll());
        return "welcome"; //view
    }

    @GetMapping("/details")
    public String getStarById(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("star", this.starRepository.findById(id).get());
        return "details";
    }

    @GetMapping("/edition")
    public String edition(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("star", this.starRepository.findById(id));
        return "edition";
    }

    @PostMapping("/edition")
    public String updateStar(@RequestParam(value = "id") int id, Model model, Star star) {
        starRepository.save(star);
        model.addAttribute("star", this.starRepository.findById(id));
        return "details";
    }


    @GetMapping("/create")
    public String createStar(Model model) {
        model.addAttribute("star", new Star());
        return "create";
    }

    @PostMapping("/create")
    public String addStar(@ModelAttribute Star star, Model model) {
        starRepository.save(star);
        model.addAttribute("star", this.starRepository.findAll());
        return "welcome";
    }

    @GetMapping("/delete")
    public String DeleteStar(@RequestParam(value = "id") int id, Model model, Star star) {
        model.addAttribute("star", this.starRepository.findById(id).get());
        starRepository.delete(star);
        return "delete";
    }

}