package com.loicmaria.web;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.Comment;
import com.loicmaria.services.ClimbingSiteServiceImpl;
import com.loicmaria.services.CommentServiceImpl;
import com.loicmaria.services.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserAccountServiceImpl userAccountService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    CommentServiceImpl commentService;

    /**
     * Ajoute au model l'utilisateur connecté à toutes les requêtes envoyées au contrôleur.
     * @param model Contient les données à afficher.
     */
    @ModelAttribute
    public void addAtttributes(Model model){
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
    }

    /**
     * Afficher la liste des utilisateurs.
     * @param model Contient les données à afficher.
     * @return La page des utilisateurs si la personne est admin ou sinon la page d'accueil.
     */
    @GetMapping("/userList")
    public String getUsers(Model model){
        if (userAccountService.isAdmin(userAccountService.getLoggedUserAccount())){
            model.addAttribute("usersList", userAccountService.getter());
            return "admin/getUser";
        }else
            return "/home";
    }

    /**
     * Modifier le rôle admin d'un utilisateur.
     * @param id L'ID du compte utilisateur à modifier.
     * @param model Contient les données à afficher.
     * @return La page des utilisateurs si la personne est admin ou sinon la page d'accueil.
     */
    @PostMapping("/userList/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model){
        if (userAccountService.isAdmin(userAccountService.getLoggedUserAccount())){
            userAccountService.changeRole(userAccountService.get(id));
            model.addAttribute("usersList", userAccountService.getter());
            return "admin/getUser";
        }else
            return "/home";
    }

    /**
     * Afficher la page permettant de valider un site comme officiel.
     * @param id L'ID du site à modifier.
     * @param model Contient les données à afficher.
     * @return La page permettant de valider un site si la personne est admin ou sinon la page d'accueil.
     */
    @GetMapping("/approve")
    public String approveClimbingSite(@RequestParam(value = "id") int id, Model model){
        if (userAccountService.isAdmin(userAccountService.getLoggedUserAccount())) {
            model.addAttribute("climbingSite", climbingSiteService.get(id));
            return "admin/approveClimbingSite";
        }else
            return "/home";
    }

    /**
     * Modifier l'officialité du site.
     * @param id L'ID du site à modifier.
     * @param climbingSite Le site à modifier.
     * @param model Contient les données à afficher.
     * @return La page du site qui a été modifié si la personne est admin ou sinon la page d'accueil.
     */
    @PostMapping("/approve/{id}")
    public String updateClimbingSite(@PathVariable(value = "id") int id, @ModelAttribute ClimbingSite climbingSite, Model model){
        if (userAccountService.isAdmin(userAccountService.getLoggedUserAccount())){
            ClimbingSite climbingSite1 = climbingSiteService.get(id);
            climbingSite1.setOfficial(climbingSite.isOfficial());
            climbingSiteService.update(climbingSite1);

            model.addAttribute("newComment", new Comment());
            model.addAttribute("editComment", null);
            model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
            model.addAttribute("climbingSite", climbingSiteService.get(id));
            return "climbingSite/detailsClimbingSite";
        }else
            return "/home";
    }
}