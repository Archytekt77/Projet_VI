package com.loicmaria.web;

import com.loicmaria.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/home")
    public String main() {
        return "home";
    }
}