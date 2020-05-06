package com.loicmaria.web;

import com.loicmaria.services.TopoServiceImpl;
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

    @GetMapping("/get")
    public String getTopos(Model model){
        model.addAttribute("topo", topoService.getter());
        return "getTopo";
    }

    @GetMapping("/details")
    public String getToposById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("topo", topoService.get(id));
        return "detailsTopo";
    }

    @GetMapping("/create")
    public String createTopo(Model model){
        model.addAttribute("topo", new Topo());
        return "createTopo";
    }

    @PostMapping("/create")
    public String addTopo(@ModelAttribute Topo topo, Model model){
        topoService.add(topo);
        model.addAttribute("topo", topoService.getter());
        return "getTopo";
    }

    @GetMapping("/edition")
    public String editionTopo(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("topo", topoService.get(id));
        return "editionTopo";
    }

    @PostMapping("/edition")
    public String updateTopo(@RequestParam(value = "id") int id, Model model, Topo topo){
        topoService.update(topo);
        model.addAttribute("topo", topoService.get(id));
        return "detailsTopo";
    }

    @GetMapping("/delete")
    public String deleteTopo(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("topo", topoService.get(id));
        topoService.delete(id);
        return "deleteTopo";
    }
}