package com.loicmaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 *  <b>Classe mère des services.</b>
 *  <p>
 *      Elle utilise le framework de Spring Data JPA, permet la redéfinition des CRUD en général
 *      et elle est attachée à :
 *      <ul>
 *          <li>BookingServiceImpl</li>
 *          <li>ClimbingSiteServiceImpl</li>
 *          <li>CommentServiceImpl</li>
 *          <li>RoleServiceImpl</li>
 *          <li>RouteServiceImpl</li>
 *          <li>TopoServiceImpl</li>
 *          <li>UserServiceImpl</li>
 *      </ul>
 *  </p>
 *
 * @param <T> Objet.
 * @param <S> Repository de l'objet. Qui hérite de la JpaRepository.
 *
 * @see JpaRepository
 * @see BookingServiceImpl
 * @see ClimbingSiteServiceImpl
 * @see CommentServiceImpl
 * @see RoleServiceImpl
 * @see RouteServiceImpl
 * @see TopoServiceImpl
 * @see UserServiceImpl
 *
 * @author Loïc MARIA
 * @version 1.0
 */

public class Services<T, S extends JpaRepository<T, Integer>> {

    @Autowired
    public S repository;


    // CRUD
    /**
     * Retourne une liste d'objet de la base de donnée.
     * @return Une liste d'objet.
     */
    public Collection<T> getter() {
        return repository.findAll();
    }

    /**
     * Retourne un objet par son ID de la base de donnée.
     * @param id L'ID de l'objet recherché.
     * @return L'objet trouvé par son ID.
     */
    public T get(int id) {
        return repository.findById(id).get();
    }

    /**
     * Ajoute un objet à la base de donnée.
     * @param val L'objet qui est ajouté.
     */
    public void add(T val) {
        repository.save(val);
    }

    /**
     * Met à jour un objet dans la base de donnée.
     * @param val L'objet à mettre à jour.
     * @return L'objet
     */
    public T update(T val) {
        return repository.save(val);
    }

    /**
     * Supprime un objet de la base de donnée.
     * @param id L'ID de l'objet à supprimer.
     */
    public void delete(int id) {
        repository.deleteById(id);
    }


    // Getters and Setters
    public S getRepository() {
        return repository;
    }
    public void setRepository(S repository) {
        this.repository = repository;
    }
}
