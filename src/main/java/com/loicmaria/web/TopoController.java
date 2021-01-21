package com.loicmaria.web;


import com.loicmaria.services.ClimbingSiteServiceImpl;
import com.loicmaria.services.RoleServiceImpl;
import com.loicmaria.services.TopoServiceImpl;
import com.loicmaria.services.UserAccountServiceImpl;
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
    UserAccountServiceImpl userAccountService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    RoleServiceImpl roleService;

    /**
     * Ajoute au model l'utilisateur connecté à toutes les requêtes envoyées au contrôleur.
     * @param model Contient les données à afficher.
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
    }

    /**
     * Afficher la liste des Topos.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des Topos.
     */
    @GetMapping("/get")
    public String getTopos(Model model) {
        model.addAttribute("toposList", topoService.getter());
        return "topo/getTopo";
    }

    /**
     * Afficher les détails d'un Topo.
     * @param id Le Topo à afficher.
     * @param model Contient les données à afficher.
     * @return La page détails du Topo.
     */
    @GetMapping("/details")
    public String getToposById(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

    /**
     * Afficher la page de création d'un Topo.
     * @param model Contient les données à afficher.
     * @return La page de création d'un Topo.
     */
    @GetMapping("/create")
    public String createTopo(Model model) {
        model.addAttribute("topo", new Topo());
        return "topo/createTopo";
    }

    /**
     * Créer un site.
     * @param topo Les informations du Topo.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des Topos.
     */
    @PostMapping("/create")
    public String addTopo(@ModelAttribute Topo topo, Model model) {
        topoService.add(topo);
        model.addAttribute("toposList", topoService.getter());
        return "topo/getTopo";
    }

    /**
     * Afficher la page pour modifier un Topo.
     * @param id L'ID du Topo à modifier.
     * @param model Contient les données à afficher.
     * @return La page permettant la modification d'un Topo.
     */
    @GetMapping("/edition")
    public String editionTopo(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("topo", topoService.get(id));
        return "topo/editionTopo";
    }

    /**
     * Modifier un Topo.
     * @param id L'ID du Topo à modifier.
     * @param topo Les informations à intégrer au Topo.
     * @param model Contient les données à afficher.
     * @return La page détail du Topo modifié.
     */
    @PostMapping("/edition/{id}")
    public String updateTopo(@PathVariable(value = "id") int id, Model model, Topo topo) {
        topoService.update(topo);
        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

    /**
     * Supprimer un Topo.
     * @param id L'ID du Topo à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression du Topo.
     */
    @GetMapping("/delete")
    public String deleteTopo(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("topo", topoService.get(id));
        topoService.delete(id);
        return "topo/deleteTopo";
    }

    //ClimbingSite
    /**
     * Afficher la liste des sites attachées au Topo.
     * @param id L'ID du Topo recherché.
     * @param model Contient les données à afficher.
     * @return La pages avec la liste des sites.
     */
    @GetMapping("/climbing-site")
    public String getClimbingSiteByTopo(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("climbingSitesList", climbingSiteService.findByTopo_Id(id));
        return "climbingSite/getClimbingSite";
    }
}