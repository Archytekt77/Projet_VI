package com.loicmaria.web;

import com.loicmaria.services.ClimbingSiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.ClimbingSite;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/climbing-site")
public class ClimbingSiteController {

    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;

    @GetMapping("/get")
    public String getClimbingSites(Model model){
        model.addAttribute("climbingSites", climbingSiteService.getter());
        return "climbingSite/getClimbingSite";
    }

    @GetMapping("/details")
    public String getClimbingSitesById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    @GetMapping("/create")
    public String createClimbingSite(Model model){
        model.addAttribute("climbingSite", new ClimbingSite());
        return "climbingSite/createClimbingSite";
    }

    @PostMapping("/create")
    public String addClimbingSite(@ModelAttribute ClimbingSite climbingSite, Model model){
        climbingSiteService.add(climbingSite);
        model.addAttribute("climbingSites", climbingSiteService.getter());
        return "climbingSite/getClimbingSite";
    }

    @GetMapping("/edition")
    public String editionClimbingSite(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        model.addAttribute("id", id);
        return "climbingSite/editionClimbingSite";
    }

    @PostMapping("/edition/{id}")
    public String updateClimbingSite(@PathVariable(value = "id") int id, Model model, ClimbingSite climbingSite){
        climbingSiteService.update(climbingSite);
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    @GetMapping("/delete")
    public String deleteClimbingSite(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        climbingSiteService.delete(id);
        return "climbingSite/deleteClimbingSite";
    }
}