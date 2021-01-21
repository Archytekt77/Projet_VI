package com.loicmaria.web;

import com.loicmaria.entities.*;
import com.loicmaria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserAccountServiceImpl userAccountService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    RouteServiceImpl routeService;

    /**
     * Afficher les détails de l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page de détails.
     */
    @GetMapping("/details")
    public String getUserById(Model model){
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
        return "user/detailsUser";
    }

    /**
     * Afficher le formulaire pour créer un utilisateur.
     * @param model Contient les données à afficher.
     * @return La page de création d'un utilisateur.
     */
    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new UserAccount());
        return "user/createUser";
    }

    /**
     * Créer un nouvel utilisateur.
     * @param userAccount Les informations à intégrer à son compte.
     * @return La page de connexion.
     */
    @PostMapping("/create")
    public String addUser(@ModelAttribute UserAccount userAccount){
        userAccountService.add(userAccount);
        return "login";
    }

    /**
     * Afficher la page pour modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @return La page avec le formulaire permettant la modification.
     */
    @GetMapping("/edition")
    public String editionUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userAccountService.get(id));
        model.addAttribute("id", id);
        return "user/editionUser";
    }

    /**
     *  Modifier l'utilisateur connecté.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @param userAccount Les informations à intégrer au compte utilisateur.
     * @return La page détail de l'utilisateur connecté.
     */
    @PostMapping("/edition/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model, UserAccount userAccount){
        userAccountService.update(userAccount);
        model.addAttribute("user", userAccountService.get(id));
        return "user/detailsUser";
    }

    /**
     * Supprimer le compte d'un utilisateur connecté.
     * @param id L'ID du compte à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression du compte.
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userAccountService.get(id));
        userAccountService.delete(id);
        return "user/deleteUser";
    }



    //  Topo, Climbing Site and route
    /**
     * Afficher les Topo créés par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des Topos de l'utilisateur connecté.
     */
    @GetMapping("/topo")
    public String getToposByUser(Model model){
        model.addAttribute("toposList", topoService.findByUserAccount_Id(userAccountService.getLoggedUserAccount().getId()));
        return "topo/getTopo";
    }

    /**
     * Afficher les sites créés par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des sites de l'utilisateur connecté.
     */
    @GetMapping("/climbing-site")
    public String getClimbingSiteByUser(Model model){
        model.addAttribute("searchClimbingSite",new ClimbingSite());
        model.addAttribute("climbingSitesList", climbingSiteService.findByUserAccount_Id(userAccountService.getLoggedUserAccount().getId()));
        return "climbingSite/getClimbingSite";
    }

    /**
     * Afficher les voies créées par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des voies de l'utilisateur connecté.
     */
    @GetMapping("/route")
    public String getRouteByUser(Model model){
        model.addAttribute("routesList", routeService.findByUserAccount_Id(userAccountService.getLoggedUserAccount().getId()));
        return "route/getRoute";
    }

}