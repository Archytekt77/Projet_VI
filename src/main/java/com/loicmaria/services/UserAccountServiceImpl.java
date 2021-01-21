package com.loicmaria.services;


import com.loicmaria.entities.Role;
import com.loicmaria.entities.UserAccount;
import com.loicmaria.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <b>Classe service permettant l'ORM de l'objet userAccount.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see UserAccount
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class UserAccountServiceImpl extends Services<UserAccount, UserAccountRepository> {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleServiceImpl roleService;

    /**
     * <b>Ajoute un utilisateur dans la base de donnée.</b>
     * Encode le mot de passe de l'utilisateur, puis lui attribue dans sa liste
     * de rôles le rôle d'utilisateur par défaut.
     * @param userAccount L'utilisateur à modifier.
     */
    @Override
    public void add(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        Role role = this.roleService.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        userAccount.setRoles(roles);
        super.add(userAccount);
    }

    /**
     * <b>Mise à jour de l'utilisateur dans la base de donnée.</b>
     * Encode le mot de passe de l'utilisateur. Et ajoute les rôles qu'il avait.
     * @param userAccount L'utilisateur à modifier.
     * @return L'utilisateur modifié.
     */
    @Override
    public UserAccount update(UserAccount userAccount){
        userAccount.setRoles(this.getLoggedUserAccount().getRoles());
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return repository.save(userAccount);
    }

    /**
     * <b>Permet d'avoir l'utilisateur connecté.</b>
     * @return L'utilisateur connecté ou null si l'utilisateur n'est pas inscrit ou connecté.
     */
    public UserAccount getLoggedUserAccount(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Optional<UserAccount> userAccount = this.repository.findByEmail(email);
        if(userAccount.isPresent()){
            return userAccount.get();
        }
        return null;
    }


    /**
     * <b>Permet de savoir si l'utilisateur est Administrateur</b>
     * @param userAccount L'utilisateur à vérifier.
     * @return True s'il est 'Admin'
     */
    public boolean isAdmin(UserAccount userAccount){
        return userAccount.getRoles().stream().anyMatch(o -> o.getName().equals("ROLE_ADMIN"));
    }

    /**
     * <b>Attribue le rôle Admin ou l'enlève</b>
     * Si l'utilisateur est déjà Admin, cela supprime ce rôle de sa liste de rôles. Sinon
     * cela ajoute le rôle à sa liste.
     * @param userAccount L'utilisateur à modifier.
     * @return L'utilisateur modifié.
     */
    public UserAccount changeRole(UserAccount userAccount){
        Role role = this.roleService.findByName("ROLE_ADMIN");
        if (this.isAdmin(userAccount)){
            userAccount.getRoles().remove(role);
        }else {
            userAccount.getRoles().add(role);
        }
        this.update(userAccount);
        return userAccount;
    }
}
