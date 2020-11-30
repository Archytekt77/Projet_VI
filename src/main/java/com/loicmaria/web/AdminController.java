package com.loicmaria.web;

import com.loicmaria.entities.Role;
import com.loicmaria.entities.User;
import com.loicmaria.services.RoleServiceImpl;
import com.loicmaria.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/userList")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getter());
        return "admin/getUser";
    }

    @PostMapping("/userList/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model){
        userService.changeRole(userService.get(id));
        model.addAttribute("users", userService.getter());
        return "admin/getUser";
    }
}