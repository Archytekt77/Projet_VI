package com.loicmaria.services;


import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.Comment;
import com.loicmaria.entities.Topo;
import com.loicmaria.entities.User;
import com.loicmaria.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommentServiceImpl extends Services<Comment, CommentRepository> {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;


    public void add(Comment comment, int id){
        comment.setUser(this.userService.getLoggedUser());
        comment.setClimbingSite(this.climbingSiteService.get(id));
        repository.save(comment);
    }


    public Collection<Comment> findByClimbingSite_Id(int id) {
        return commentRepository.findByClimbingSite_Id(id);
    }
}
