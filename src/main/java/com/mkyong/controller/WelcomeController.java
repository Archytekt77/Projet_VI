package com.mkyong.controller;

import com.mkyong.entity.Star;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.time.LocalDate;
import java.util.*;

@Controller
public class WelcomeController {
    private List<Star> acteurAmericain = new ArrayList<Star>() {{
        add(new Star(1, "Aaker", "Lee", LocalDate.of(1943, 9, 25), 76, "Rintintin", false));
        add(new Star(2, "Aaron", "Victor", LocalDate.of(1943, 9, 25), 58, "Salt", true));
        add(new Star(3, "Abbey", "John", LocalDate.of(1943, 9, 25), 84, "Mister Freedom", false));
        add(new Star(4, "Abbey", "John", LocalDate.of(1943, 9, 25), 84, "Mister Freedom", false));
    }};

    public Star findStarByID(int i) {
        for (Star star : acteurAmericain) {
            if (star.getId() == i)
                return star;
        }
        return null;
    }

    public Star editStar(int i) {


        for(Star star : acteurAmericain){
            star.setId();
            star.setNom();
            star.setPrenom();
            star.setDateNaissance();
            star.setAge();
            star.setFilmCulte();
            star.setActif();
            return star;
        }
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("acteursAmericains", acteurAmericain);
        return "welcome"; //view
    }

    @GetMapping("/details")
    public String details(Model model, @RequestParam String id) {
        int i = Integer.parseInt(id);
        model.addAttribute("star", findStarByID(i));
        return "details";
    }


    @PostMapping("/edition")
    public String edition(Model model, @RequestParam String id) {
        int i = Integer.parseInt(id);
        model.addAttribute("star", editStar(i));
        return "details";
    }
}