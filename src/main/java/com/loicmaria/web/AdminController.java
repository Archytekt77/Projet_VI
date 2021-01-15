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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;
    @Autowired
    CommentServiceImpl commentService;

    @ModelAttribute
    public void addAtttributes(Model model){
        model.addAttribute("user", userService.getLoggedUser());
    }

    @GetMapping("/userList")
    public String getUsers(Model model){
        if (userService.isAdmin(userService.getLoggedUser())){
            model.addAttribute("usersList", userService.getter());
            return "admin/getUser";
        }else
            return "/home";
    }

    @PostMapping("/userList/{id}")
    public String updateUser(@PathVariable(value = "id") int id, Model model){
        if (userService.isAdmin(userService.getLoggedUser())){
            userService.changeRole(userService.get(id));
            model.addAttribute("usersList", userService.getter());
            return "admin/getUser";
        }else
            return "/home";
    }

    @GetMapping("/approve")
    public String approveClimbingSite(@RequestParam(value = "id") int id, Model model){
        if (userService.isAdmin(userService.getLoggedUser())) {
            model.addAttribute("climbingSite", climbingSiteService.get(id));
            return "admin/approveClimbingSite";
        }else
            return "/home";
    }

    @PostMapping("/approve/{id}")
    public String updateClimbingSite(@PathVariable(value = "id") int id, @ModelAttribute ClimbingSite climbingSite, Model model){
        if (userService.isAdmin(userService.getLoggedUser())){
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