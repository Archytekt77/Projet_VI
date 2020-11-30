package com.loicmaria.repositories;

import com.loicmaria.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopoRepository extends JpaRepository<Topo, Integer> {
    List<Topo> findByUser_Id(int id);
}
