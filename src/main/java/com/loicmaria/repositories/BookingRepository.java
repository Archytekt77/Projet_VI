package com.loicmaria.repositories;

import com.loicmaria.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUser_Id(int id);
    List<Booking> findByTopo_Id(int id);
}
