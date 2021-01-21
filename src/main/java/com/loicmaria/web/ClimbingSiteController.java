package com.loicmaria.web;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.Comment;
import com.loicmaria.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@ControllerAdvice
@RequestMapping("/climbing-site")
public class ClimbingSiteController {

    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    RouteServiceImpl routeService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    UserAccountServiceImpl userAccountService;


    /**
     * Ajoute au model l'utilisateur connecté, instancie la recherche de site ainsi qu'un site,
     * et la liste de tous les sites à toutes les requêtes envoyées au contrôleur.
     * @param model Contient les données à afficher.
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
        model.addAttribute("searchClimbingSite",new ClimbingSite());
        model.addAttribute("climbingSite", new ClimbingSite());
        model.addAttribute("climbingSitesList", climbingSiteService.getter());
    }


    /**
     * Afficher la liste des sites.
     * @return La page avec la liste des sites.
     */
    @GetMapping("/get")
    public String getClimbingSites() {
        return "climbingSite/getClimbingSite";
    }


    /**
     * Afficher la liste des sites avec le système de recherche.
     * @param name Le nom du site recherché.
     * @param area Le secteur du site recherché.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des sites.
     */
    @PostMapping("/get/{name}/{area}")
    public String getClimbingSitesBySearch(String name, String area, Model model) {
        ClimbingSite climbingSite = new ClimbingSite();
        climbingSite.setName(name);
        climbingSite.setArea(area);

        model.addAttribute("searchClimbingSite",climbingSite);
        model.addAttribute("climbingSitesList", climbingSiteService.findByNameAndArea(name, area));
        return "climbingSite/getClimbingSite";
    }

    /**
     * Afficher les détails d'un site.
     * @param id Le site à afficher.
     * @param model Contient les données à afficher.
     * @return La page détails du site.
     */
    @GetMapping("/details")
    public String getClimbingSitesById(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    /**
     * Afficher la page de création d'un site.
     * @param model Contient les données à afficher.
     * @return La page de création d'un site.
     */
    @GetMapping("/create")
    public String createClimbingSite(Model model) {
        model.addAttribute("toposList", topoService.getter());
        return "climbingSite/createClimbingSite";
    }

    /**
     * Créer un site.
     * @param climbingSite Les informations du site.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des sites.
     */
    @PostMapping("/create")
    public String addClimbingSite(@ModelAttribute ClimbingSite climbingSite, Model model) {
        climbingSiteService.add(climbingSite);

        model.addAttribute("climbingSitesList", climbingSiteService.getter());
        return "climbingSite/getClimbingSite";
    }

    /**
     * Afficher la page pour modifier un site.
     * @param id L'ID du site à modifier.
     * @param model Contient les données à afficher.
     * @return La page permettant la modification d'un site.
     */
    @GetMapping("/edition")
    public String editionClimbingSite(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        model.addAttribute("toposList", topoService.getter());
        return "climbingSite/editionClimbingSite";
    }

    /**
     * Modifier un site.
     * @param id L'ID du site à modifier.
     * @param climbingSite Les informations à intégrer au site.
     * @param model Contient les données à afficher.
     * @return La page détail du site modifié.
     */
    @PostMapping("/edition/{id}")
    public String updateClimbingSite(@PathVariable(value = "id") int id, @ModelAttribute ClimbingSite climbingSite, Model model){
        climbingSiteService.update(climbingSite);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    /**
     * Supprimer un site.
     * @param id L'ID du site à supprimer.
     * @param model Contient les données à afficher.
     * @return La page confirmant la suppression du site.
     */
    @PostMapping("/delete/{id}")
    public String deleteClimbingSite(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("climbingSite", climbingSiteService.get(id));

        climbingSiteService.delete(id);
        return "climbingSite/deleteClimbingSite";
    }

    //Route
    /**
     * Afficher la liste des voies attachées au site.
     * @param id L'ID du site recherché.
     * @param model Contient les données à afficher.
     * @return La pages avec la liste des voies.
     */
    @GetMapping("/route")
    public String getRouteByClimbingSite(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("routesList", routeService.findByClimbingSite_Id(id));
        return "route/getRoute";
    }


    // Gestion de commentaires de la page détails
    /**
     * Créer un commentaire.
     * @param id L'ID du site concerné.
     * @param comment Les informations à intégrer au commentaire.
     * @param model Contient les données à afficher.
     * @return La page détails du site avec le commentaire ajouté.
     */
    @PostMapping("/details/add-comment/{id}")
    public String addComment(@PathVariable(value = "id") int id, @ModelAttribute Comment comment, Model model) {
        commentService.add(comment,id);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }


    /**
     * Afficher le formulaire pour modifier le commentaire
     * @param id L'ID du site concerné.
     * @param commentId L'ID du commentaire à modifier.
     * @param model Contient les données à afficher.
     * @return La page détails du site avec le commentaire pouvant être modifié.
     */
    @GetMapping("/details/edit-comment")
    public String editionComment(@RequestParam(value = "id") int id, @RequestParam(value = "comment-id") int commentId, Model model){

        model.addAttribute("newComment", null);
        model.addAttribute("editComment", commentService.get(commentId));
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    /**
     * Modifier un commentaire.
     * @param id L'ID du site concerné.
     * @param editComment Les informations du commentaire à intégrer.
     * @param model Contient les données à afficher.
     * @return La page détails du site avec le commentaire modifié.
     */
    @PostMapping("/details/edit-comment/{id}")
    public String updateComment(@PathVariable(value = "id") int id, @ModelAttribute Comment editComment, Model model){
        commentService.update(editComment, id);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    /**
     * Supprimer un commentaire
     * @param id L'ID du site concerné.
     * @param commentId L'ID du commentaire à supprimer.
     * @param model Contient les données à afficher.
     * @return La page détails du site avec le commentaire supprimé.
     */
    @PostMapping("/details/delete-comment")
    public String deleteComment(@RequestParam(value = "id") int id, @RequestParam(value = "comment-id") int commentId, Model model){
        commentService.delete(commentId);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }
}