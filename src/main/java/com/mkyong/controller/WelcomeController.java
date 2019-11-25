package com.mkyong.controller;

import com.mkyong.entity.Star;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    }};

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("acteurAmericain", acteurAmericain);
        return "welcome"; //view
    }

    @GetMapping("/details")
    @ResponseBody
    public String details(Model model, @RequestParam String id) {
        model.addAttribute("acteurAmericain", acteurAmericain);
        return "details";
    }
}