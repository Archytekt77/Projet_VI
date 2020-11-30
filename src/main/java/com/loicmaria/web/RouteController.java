package com.loicmaria.web;

import com.loicmaria.services.RouteServiceImpl;
import com.loicmaria.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.Route;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteServiceImpl routeService;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/get")
    public String getRoutes(Model model){
        model.addAttribute("routes", routeService.getter());
        return "route/getRoute";
    }

    @GetMapping("/details")
    public String getRouteById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("route", routeService.get(id));
        return "route/detailsRoute";
    }

    @GetMapping("/create")
    public String createRoute(Model model){
        model.addAttribute("route", new Route());
        return "route/createRoute";
    }

    @PostMapping("/create")
    public String addRoute(@ModelAttribute Route route, Model model){
        System.out.println(route);
        routeService.add(route);
        model.addAttribute("routes", routeService.getter());
        return "route/getRoute";
    }

    @GetMapping("/edition")
    public String editionRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        model.addAttribute("user", userService.getLoggedUser());
        return "route/editionRoute";
    }

    @PostMapping("/edition/{id}")
    public String updateRoute(@PathVariable(value = "id") int id, Model model, Route route){
        route.setUser(userService.getLoggedUser());
        routeService.update(route);
        model.addAttribute("route", routeService.get(id));
        model.addAttribute("user", userService.getLoggedUser());
        return "route/detailsRoute";
    }

    @GetMapping("/delete")
    public String deleteRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        routeService.delete(id);
        return "route/deleteRoute";
    }
}