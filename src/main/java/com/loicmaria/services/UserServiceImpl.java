package com.loicmaria.services;

import com.loicmaria.entities.User;
import com.loicmaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(String id, User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public Collection<User> getUser() {
        return userRepository.findAll();
    }
}
