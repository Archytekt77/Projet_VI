package com.loicmaria.services;


import com.loicmaria.entities.Topo;
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

    /**
     * <b>Ajout du Topo dans la base de donnée.</b>
     * Ajoute l'utilisateur connecté.
     * @param topo Le Topo à modifier.
     */
    @Override
    public void add(Topo topo){
        topo.setUser(this.userService.getLoggedUser());
        super.add(topo);
    }

    /**
     * <b>Mise à jour du Topo dans la base de donnée.</b>
     * Ajoute l'utilisateur connecté.
     * @param topo Le Topo à modifier.
     * @return Le Topo modifié.
     */
    @Override
    public Topo update(Topo topo){
        topo.setUser(this.userService.getLoggedUser());
        return repository.save(topo);
    }

    /**
     * <b>Retourne une liste de Topo de l'utilisateur connecté.</b>
     * Permet de trouver tous les Topos qu'il a lui même créés.
     * @param id L'ID de l'utilisateur connecté.
     * @return Une liste de Topo.
     */
    public Collection<Topo> findByUser_Id(int id) {
        return topoRepository.findByUser_Id(id);
    }

}
