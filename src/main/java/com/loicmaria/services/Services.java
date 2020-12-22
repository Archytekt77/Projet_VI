package com.loicmaria.services;

import com.loicmaria.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public class Services<T, S extends JpaRepository<T, Integer>> {

    @Autowired
    public S repository;


    // CRUD
    /**
     * Retourne une liste d'objet de la base de donnée faisant appelle .
     * @return Une liste d'objet.
     */
    public Collection<T> getter() {
        return repository.findAll();
    }

    /**
     * Retourne un objet par son ID.
     * @param id L'ID de l'objet recherché.
     * @return L'objet trouvé par son ID.
     */
    public T get(int id) {
        return repository.findById(id).get();
    }

    /**
     * Ajoute un objet
     * @param val
     */
    public void add(T val) {
        repository.save(val);
    }

    /**
     *
     * @param val
     * @return
     */
    public T update(T val) {
        return repository.save(val);
    }

    /**
     *
     * @param id
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
