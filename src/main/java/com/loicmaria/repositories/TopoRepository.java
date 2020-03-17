package com.loicmaria.repositories;

import com.loicmaria.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopoRepository extends JpaRepository<Topo, Integer> {
    void deleteById(String id);
    void findById(String id);
}
