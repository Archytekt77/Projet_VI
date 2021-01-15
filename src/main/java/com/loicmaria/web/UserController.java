package com.loicmaria.web;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.Role;
import com.loicmaria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    RouteServiceImpl routeService;


    @GetMapping("/details")
    public String getUserById(Model model){
        model.addAttribute("user", userService.getLoggedUser());
        return "user/detailsUser";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "user/createUser";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute User user){
        System.out.println(user);
        userService.add(user);
        return "login";
    }

    @GetMapping("/edition")
    public String editionUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.get(id));
        model.addAttribute("id", id);
        return "user/editionUser";
    }

    @PostMapping("/edition/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model, User user){
        List<Role> role = userService.getLoggedUser().getRoles();
        user.setRoles(role);
        userService.update(user);
        model.addAttribute("user", userService.get(id));
        return "user/detailsUser";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.get(id));
        userService.delete(id);
        return "user/deleteUser";
    }



    //  Topo, Climbing Site and route
    @GetMapping("/topo")
    public String getToposByUser(Model model){
        model.addAttribute("toposList", topoService.findByUser_Id(userService.getLoggedUser().getId()));
        return "topo/getTopo";
    }

    @GetMapping("/climbing-site")
    public String getClimbingSiteByUser(Model model){
        model.addAttribute("searchClimbingSite",new ClimbingSite());
        model.addAttribute("climbingSitesList", climbingSiteService.findByUser_Id(userService.getLoggedUser().getId()));
        return "climbingSite/getClimbingSite";
    }
    @GetMapping("/route")
    public String getRouteByUser(Model model){
        model.addAttribute("routesList", routeService.findByUser_Id(userService.getLoggedUser().getId()));
        return "route/getRoute";
    }

}