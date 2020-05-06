package com.loicmaria.web;

import com.loicmaria.entities.Route;
import com.loicmaria.services.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteServiceImpl routeService;

    @GetMapping("/details")
    public String getRouteById(@RequestParam(value = "id") int id, Model model){

        return "detailsRoute";
    }

    @GetMapping("/create")
    public String createRoute(Route route){
        return "createRoute";
    }

    @PostMapping("/create")
    public String addRoute(@ModelAttribute Route route){
        routeService.add(route);
        return "home";
    }

    @GetMapping("/edition")
    public String editionRoute(@RequestParam(value = "id") int id, Route route){
        return "editionRoute";
    }

    @PostMapping("/edition")
    public String updateRoute(@RequestParam(value = "id") int id, Route route){
        routeService.get(id);
        routeService.update(route);
        return "home";
    }

    @PostMapping("/delete")
    public String deleteRoute(@RequestParam(value = "id") int id, Model model){
        routeService.delete(id);
        return "home";
    }
}
