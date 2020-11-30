package com.loicmaria.services;


import com.loicmaria.entities.Route;
import com.loicmaria.entities.User;
import com.loicmaria.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RouteServiceImpl extends Services<Route, RouteRepository> {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    public void add(Route val){
        User user = this.userService.getLoggedUser();
        val.setUser(user);
        super.add(val);
    }


    public Collection<Route> findByUser_Id(int id) {
        return routeRepository.findByUser_Id(id);
    }
}
