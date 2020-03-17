package com.loicmaria.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.User;
import com.loicmaria.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get-user")
    public String getUser(){
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user){
        userService.createUser(user);
        return "home";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return "home";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String putUser(@RequestBody User user){
        userService.updateUser(user);
        return "home";
    }
}
