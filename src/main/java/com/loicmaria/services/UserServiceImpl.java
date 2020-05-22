package com.loicmaria.services;


import com.loicmaria.entities.User;
import com.loicmaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends Services<User, UserRepository> {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleServiceImpl roleService;

    @Override
    public void add(User val) {
        val.setPassword(passwordEncoder.encode(val.getPassword()));
        super.add(val);
    }
}
