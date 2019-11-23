package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    private List<String> acteurAmericain = new ArrayList<String>() {{
        add("A");
        add("B");
        add("C");
    }}; /*{{"Lee", "Victor", "John", "Bruce", "Bud", "Christopher", "George", "Norman", "Philip", "Tommy"},
            {"Aaker", "Aaron", "Abbey", "Abbott", "Abbott", "Abbott", "Abbott", "Abbott", "Abbott", "Abbott"}};*/

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("acteurAmericain", acteurAmericain);

        return "welcome"; //view
    }

}