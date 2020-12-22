package com.loicmaria.services;


import com.loicmaria.entities.Role;
import com.loicmaria.entities.User;
import com.loicmaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends Services<User, UserRepository> {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleServiceImpl roleService;

    public Role role;
    public List<Role> roles;

    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        role = this.roleService.findByName("ROLE_USER");
        roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        super.add(user);
    }

    @Override
    public User update(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Optional<User> user = this.repository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }


    public boolean isAdmin(User user){
        return user.getRoles().stream().anyMatch(o -> o.getName().equals("ROLE_ADMIN"));
    }

    public User changeRole(User user){
        role = this.roleService.findByName("ROLE_ADMIN");
        if (this.isAdmin(user)){
            user.getRoles().remove(role);
        }else {
            user.getRoles().add(role);
        }
        this.update(user);
        return user;
    }
}
