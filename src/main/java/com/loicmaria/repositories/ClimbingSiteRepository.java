package com.loicmaria.repositories;

import com.loicmaria.entities.ClimbingSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClimbingSiteRepository extends JpaRepository<ClimbingSite, Integer> {
    List<ClimbingSite> findByUserAccount_Id(int id);
    List<ClimbingSite> findByTopo_Id(int id);
    List<ClimbingSite> findByNameAndArea(String name, String area);
}
