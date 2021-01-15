package com.loicmaria.web;

import com.loicmaria.services.ClimbingSiteServiceImpl;
import com.loicmaria.services.RouteServiceImpl;
import com.loicmaria.services.UserServiceImpl;
import groovy.transform.AutoImplement;
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
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userService.getLoggedUser());
    }

    @GetMapping("/get")
    public String getRoutesByClimbingSite(@RequestParam(value = "id") int id, Model model){
        System.out.println("ICI : " + id);
        model.addAttribute("routesList", routeService.findByClimbingSite_Id(id));
        System.out.println("LA : " + routeService.findByClimbingSite_Id(id));
        return "route/getRoute";
    }

    @GetMapping("/details")
    public String getRouteById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        return "route/detailsRoute";
    }

    @GetMapping("/create")
    public String createRoute(@RequestParam(value = "id") int id, Model model){
        System.out.println("HERE : " + id);
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        model.addAttribute("route", new Route());
        return "route/createRoute";
    }

    @PostMapping("/create/{id}")
    public String addRoute(@PathVariable(value = "id") int id, @ModelAttribute Route route, Model model){
        System.out.println("HERE : " + id);
        routeService.add(route,id);
        model.addAttribute("routes", routeService.getter());
        return "route/getRoute";
    }

    @GetMapping("/edition")
    public String editionRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        return "route/editionRoute";
    }

    @PostMapping("/edition/{id}")
    public String updateRoute(@PathVariable(value = "id") int id, Model model, Route route){
        route.setUser(userService.getLoggedUser());
        routeService.update(route);
        model.addAttribute("route", routeService.get(id));
        return "route/detailsRoute";
    }

    @GetMapping("/delete")
    public String deleteRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        routeService.delete(id);
        return "route/deleteRoute";
    }
}