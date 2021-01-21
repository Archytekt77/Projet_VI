package com.loicmaria.repositories;


import com.loicmaria.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findByUserAccount_Id(int id);
    List<Route> findByClimbingSite_Id(int id);
}
