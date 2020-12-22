package com.loicmaria.repositories;

import com.loicmaria.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUser_IdAndStatus(int id, String status);
    List<Booking> findByTopo_User_IdAndStatus(int id, String status);
}
