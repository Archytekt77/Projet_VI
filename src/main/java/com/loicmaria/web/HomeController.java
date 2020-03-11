package com.loicmaria.web;

import com.loicmaria.entities.User;
import com.loicmaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String main(Model model) {
        return "home"; //view
    }

    @GetMapping("/details")
    public String getStarById(@RequestParam(value = "id") int id, Model model) {
        return "details";
    }

    @GetMapping("/edition")
    public String edition(@RequestParam(value = "id") int id, Model model) {
        return "edition";
    }

    @PostMapping("/edition")
    public String updateStar(@RequestParam(value = "id") int id, Model model) {
        return "details";
    }


    @GetMapping("/create")
    public String createStar(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String addStar(Model model) {
        return "home";
    }

    @GetMapping("/delete")
    public String DeleteStar(@RequestParam(value = "id") int id, Model model) {
        return "delete";
    }

    @GetMapping("/user")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute User user){
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
        return "home";
    }
}