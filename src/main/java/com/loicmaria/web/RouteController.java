package com.loicmaria.web;

import com.loicmaria.services.ClimbingSiteServiceImpl;
import com.loicmaria.services.RouteServiceImpl;
import com.loicmaria.services.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.loicmaria.entities.Route;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteServiceImpl routeService;
    @Autowired
    UserAccountServiceImpl userAccountService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;

    /**
     * Ajoute au model l'utilisateur connecté à toutes les requêtes envoyées au contrôleur.
     * @param model Contient les données à afficher.
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
    }

    /**
     * Afficher la liste des voies.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des voies.
     */
    @GetMapping("/get")
    public String getRoutes(Model model){
        model.addAttribute("routesList", routeService.getter());
        return "route/getRoute";
    }

    /**
     * Afficher les détails d'une voie.
     * @param id La voie à afficher.
     * @param model Contient les données à afficher.
     * @return La page détails de la voie.
     */
    @GetMapping("/details")
    public String getRouteById(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        return "route/detailsRoute";
    }

    /**
     * Afficher la page de création d'une voie.
     * @param model Contient les données à afficher.
     * @return La page de création d'une voie.
     */
    @GetMapping("/create")
    public String createRoute(Model model){
        model.addAttribute("route", new Route());
        model.addAttribute("climbingSitesList", climbingSiteService.getter());
        return "route/createRoute";
    }

    /**
     * Créer une voie.
     * @param route Les informations de la voie.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des voies.
     */
    @PostMapping("/create")
    public String addRoute(@ModelAttribute Route route, Model model){
        routeService.add(route);

        model.addAttribute("routesList", routeService.getter());
        return "route/getRoute";
    }

    /**
     * Afficher la page pour modifier une voie.
     * @param id L'ID de la voie à modifier.
     * @param model Contient les données à afficher.
     * @return La page permettant la modification d'une voie.
     */
    @GetMapping("/edition")
    public String editionRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));
        model.addAttribute("climbingSitesList", climbingSiteService.getter());
        return "route/editionRoute";
    }

    /**
     * Modifier un voie.
     * @param id L'ID du site à modifier.
     * @param route Les informations à intégrer à la voie.
     * @param model Contient les données à afficher.
     * @return La page détail de la voie modifiée.
     */
    @PostMapping("/edition/{id}")
    public String updateRoute(@PathVariable(value = "id") int id, Model model, Route route){
        routeService.update(route);

        model.addAttribute("route", routeService.get(id));
        return "route/detailsRoute";
    }

    /**
     * Supprimer une voie.
     * @param id L'ID de la voie à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression de la voie.
     */
    @GetMapping("/delete")
    public String deleteRoute(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("route", routeService.get(id));

        routeService.delete(id);
        return "route/deleteRoute";
    }
}