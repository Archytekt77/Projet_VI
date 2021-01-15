package com.loicmaria.services;


import com.loicmaria.entities.Route;
import com.loicmaria.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * <b>Classe service permettant l'ORM de l'objet Route.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see Route
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class RouteServiceImpl extends Services<Route, RouteRepository> {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;

    /**
     * <b>Ajout de la voie dans la base de donnée.</b>
     * Ajoute l'utilisateur connecté et l'ID du site d'escalade
     * dont la voie appartient.
     * @param route La voie à modifier.
     */
    public void add(Route route, int id){
        route.setUser(this.userService.getLoggedUser());
        route.setClimbingSite(this.climbingSiteService.get(id));
        System.out.println(route.getClimbingSite());
        repository.save(route);
    }

    /**
     * <b>Mise à jour de la voie dans la base de donnée.</b>
     * Ajoute l'utilisateur connecté et l'ID du site d'escalade
     * dont la voie appartient.
     * @param route La voie à modifier.
     * @param id L'ID du site d'escalade
     * @return La voie modifiée.
     */
    public Route update(Route route, int id){
        route.setUser(this.userService.getLoggedUser());
        route.setClimbingSite(this.climbingSiteService.get(id));
        return repository.save(route);
    }


    /**
     * <b>Retourne une liste de voies de l'utilisateur connecté.</b>
     * Permet de trouver toutes les voies qu'il a lui même créées.
     * @param id L'ID de l'utilisateur connecté.
     * @return Une liste de voies.
     */
    public Collection<Route> findByUser_Id(int id) {
        return routeRepository.findByUser_Id(id);
    }

    /**
     * <b>Retourne une liste de voies en fonction du site d'escalade.</b>
     * Permet de trouver toutes les voies en fonction du site d'escalade.
     * @param id L'ID du site d'escalade.
     * @return Une liste de voies.
     */
    public Collection<Route> findByClimbingSite_Id(int id) {
        return routeRepository.findByClimbingSite_Id(id);
    }
}
