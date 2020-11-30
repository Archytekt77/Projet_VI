package com.loicmaria.web;

import com.loicmaria.services.TopoServiceImpl;
import com.loicmaria.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.Topo;

@Controller
@RequestMapping("/topo")
public class TopoController {

    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/get")
    public String getTopos(Model model){
        model.addAttribute("topos", topoService.getter());
        return "topo/getTopo";
    }

    @GetMapping("/details")
    public String getToposById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

    @GetMapping("/create")
    public String createTopo(Model model){
        model.addAttribute("topo", new Topo());
        return "topo/createTopo";
    }

    @PostMapping("/create")
    public String addTopo(@ModelAttribute Topo topo, Model model){
        topoService.add(topo);
        model.addAttribute("topos", topoService.getter());
        return "topo/getTopo";
    }

    @GetMapping("/edition")
    public String editionTopo(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("topo", topoService.get(id));
        model.addAttribute("user", userService.getLoggedUser());
        return "topo/editionTopo";
    }

    @PostMapping("/edition/{id}")
    public String updateTopo(@PathVariable(value = "id") int id, Model model, Topo topo){
        topo.setUser(userService.getLoggedUser());
        topoService.update(topo);
        model.addAttribute("topo", topoService.get(id));
        model.addAttribute("user", userService.getLoggedUser());
        return "topo/detailsTopo";
    }

    @GetMapping("/delete")
    public String deleteTopo(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("topo", topoService.get(id));
        topoService.delete(id);
        return "topo/deleteTopo";
    }
}