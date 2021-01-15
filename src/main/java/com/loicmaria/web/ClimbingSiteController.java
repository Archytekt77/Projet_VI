package com.loicmaria.web;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.Comment;
import com.loicmaria.services.ClimbingSiteServiceImpl;
import com.loicmaria.services.CommentServiceImpl;
import com.loicmaria.services.UserServiceImpl;
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
    CommentServiceImpl commentService;
    @Autowired
    UserServiceImpl userService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("searchClimbingSite",new ClimbingSite());
        model.addAttribute("climbingSite", new ClimbingSite());
        model.addAttribute("climbingSitesList", climbingSiteService.getter());
    }


    @GetMapping("/get")
    public String getClimbingSites() {
        return "climbingSite/getClimbingSite";
    }


    @PostMapping("/get/{name}/{area}")
    public String getClimbingSitesBySearch(String name, String area, Model model) {
        ClimbingSite climbingSite = new ClimbingSite();
        climbingSite.setName(name);
        climbingSite.setArea(area);

        model.addAttribute("searchClimbingSite",climbingSite);
        model.addAttribute("climbingSitesList", climbingSiteService.findByNameAndArea(name, area));
        return "climbingSite/getClimbingSite";
    }

    @GetMapping("/details")
    public String getClimbingSitesById(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    @GetMapping("/create")
    public String createClimbingSite() {
        return "climbingSite/createClimbingSite";
    }

    @PostMapping("/create")
    public String addClimbingSite(@ModelAttribute ClimbingSite climbingSite, Model model) {
        climbingSiteService.add(climbingSite);

        model.addAttribute("climbingSitesList", climbingSiteService.getter());
        return "climbingSite/getClimbingSite";
    }

    @GetMapping("/edition")
    public String editionClimbingSite(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/editionClimbingSite";
    }
    @PostMapping("/edition/{id}")
    public String updateClimbingSite(@PathVariable(value = "id") int id, @ModelAttribute ClimbingSite climbingSite, Model model){
        climbingSiteService.update(climbingSite);

        model.addAttribute("comments", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }


    @PostMapping("/delete/{id}")
    public String deleteClimbingSite(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("climbingSite", climbingSiteService.get(id));

        climbingSiteService.delete(id);
        return "climbingSite/deleteClimbingSite";
    }


    // Gestion de commentaires de la page détails

    @PostMapping("/details/add-comment/{id}")
    public String addComment(@PathVariable(value = "id") int id, @ModelAttribute Comment comment, Model model) {
        commentService.add(comment,id);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }


    @GetMapping("/details/edit-comment")
    public String editionComment(@RequestParam(value = "id") int id, @RequestParam(value = "comment-id") int commentId, Model model){

        model.addAttribute("newComment", null);
        model.addAttribute("editComment", commentService.get(commentId));
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

    @PostMapping("/details/edit-comment/{id}")
    public String updateComment(@PathVariable(value = "id") int id,
                                @ModelAttribute Comment editComment, Model model){
        commentService.update(editComment, id);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("editComment", null);
        model.addAttribute("commentsList", commentService.findByClimbingSite_Id(id));
        model.addAttribute("climbingSite", climbingSiteService.get(id));
        return "climbingSite/detailsClimbingSite";
    }

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