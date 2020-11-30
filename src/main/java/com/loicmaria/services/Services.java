package com.loicmaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public class Services<T, S extends JpaRepository<T, Integer>> {

    @Autowired
    public S repository;


    // CRUD
    public Collection<T> getter() {
        return repository.findAll();
    }
    public T get(int id) {
        return repository.findById(id).get();
    }
    public void add(T val) {
        repository.save(val);
    }
    public T update(T val) {
       return repository.save(val);
    }
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
