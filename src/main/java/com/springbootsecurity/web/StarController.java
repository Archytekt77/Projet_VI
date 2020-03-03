package com.springbootsecurity.web;

import com.springbootsecurity.entities.Star;
import com.springbootsecurity.entities.User;
import com.springbootsecurity.repositories.StarRepository;
import com.springbootsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StarController {

    @Autowired
    public StarRepository starRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("star", this.starRepository.findAll());
        return "home"; //view
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
        return "home";
    }

    @GetMapping("/delete")
    public String DeleteStar(@RequestParam(value = "id") int id, Model model, Star star) {
        model.addAttribute("star", this.starRepository.findById(id).get());
        starRepository.delete(star);
        return "delete";
    }

    @GetMapping("/user")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute User user){
        userRepository.save(user);
        return "home";
    }
}