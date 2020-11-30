package com.loicmaria.services;

import com.loicmaria.entities.Role;
import com.loicmaria.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends Services<Role, RoleRepository> {

    public Role findByName(String name){
       return this.repository.findByName(name);
    }
}
