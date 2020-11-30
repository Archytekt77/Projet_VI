package com.loicmaria.services;


import com.loicmaria.entities.Topo;
import com.loicmaria.entities.User;
import com.loicmaria.repositories.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class TopoServiceImpl extends Services<Topo, TopoRepository> {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    TopoRepository topoRepository;

    @Override
    public void add(Topo val){
        User user = this.userService.getLoggedUser();
        val.setUser(user);
        super.add(val);
    }

    public Collection<Topo> findByUser_Id(int id) {
        return topoRepository.findByUser_Id(id);
    }

}
