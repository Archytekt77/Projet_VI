package com.loicmaria.services;


import com.loicmaria.entities.Role;
import com.loicmaria.repositories.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * <b>Classe service permettant l'ORM de l'objet Role.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see Role
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class RoleServiceImpl extends Services<Role, RoleRepository> {

    /**
     * <b>Retourne un Rôle selon son nom.</b>
     * @param name Le nom du rôle.
     * @return Un Rôle.
     */
    public Role findByName(String name){
       return this.repository.findByName(name);
    }
}
