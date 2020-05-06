package com.loicmaria.web;

import com.loicmaria.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String main(Model model) {
        return "home";
    }

    @GetMapping("/user")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute User user){
        return "home";
    }
}