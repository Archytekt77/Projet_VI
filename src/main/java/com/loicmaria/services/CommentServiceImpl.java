package com.loicmaria.services;


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
    UserServiceImpl userService;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void add(Comment val){
        User user = this.userService.getLoggedUser();
        val.setUser(user);
        super.add(val);
    }

    public Collection<Comment> findByClimbingSite_Id(int id) {
        return commentRepository.findByClimbingSite_Id(id);
    }
}
