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

/**
 * <b>Classe service permettant l'ORM de l'objet User.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see User
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class UserServiceImpl extends Services<User, UserRepository> {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleServiceImpl roleService;

    /**
     * <b>Ajoute un utilisateur dans la base de donnée.</b>
     * Encode le mot de passe de l'utilisateur, puis lui attribue dans sa liste
     * de rôles le rôle d'utilisateur par défaut.
     * @param user L'utilisateur à modifier.
     */
    @Override
    public void add(User user) {
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = this.roleService.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        super.add(user);
    }

    /**
     * <b>Mise à jour de l'utilisateur dans la base de donnée.</b>
     * Encode le mot de passe de l'utilisateur.
     * @param user L'utilisateur à modifier.
     * @return L'utilisateur modifié.
     */
    @Override
    public User update(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    /**
     * <b>Permet d'avoir l'utilisateur connecté.</b>
     * @return L'utilisateur connecté ou null si l'utilisateur n'est pas inscrit ou connecté.
     */
    public User getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Optional<User> user = this.repository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }


    /**
     * <b>Permet de savoir si l'utilisateur est Administrateur</b>
     * @param user L'utilisateur à vérifier.
     * @return True s'il est 'Admin'
     */
    public boolean isAdmin(User user){
        return user.getRoles().stream().anyMatch(o -> o.getName().equals("ROLE_ADMIN"));
    }

    /**
     * <b>Attribue le rôle Admin ou l'enlève</b>
     * Si l'utilisateur est déjà Admin, cela supprime ce rôle de sa liste de rôles. Sinon
     * cela ajoute le rôle à sa liste.
     * @param user L'utilisateur à modifier.
     * @return L'utilisateur modifié.
     */
    public User changeRole(User user){
        Role role = this.roleService.findByName("ROLE_ADMIN");
        if (this.isAdmin(user)){
            user.getRoles().remove(role);
        }else {
            user.getRoles().add(role);
        }
        this.update(user);
        return user;
    }
}
