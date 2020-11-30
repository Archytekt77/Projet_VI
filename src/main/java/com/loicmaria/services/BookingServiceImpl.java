package com.loicmaria.services;

import com.loicmaria.entities.Booking;
import com.loicmaria.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookingServiceImpl extends Services<Booking, BookingRepository> {

    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    UserServiceImpl userService;


    public void add(Booking booking, int id){
        booking.setTopo(topoService.get(id));
        booking.setUser(userService.getLoggedUser());
        repository.save(booking);
    }

    public Collection<Booking> findByTopo_Id(int id){
        return repository.findByTopo_Id(id);
    }
    public Collection<Booking> findByUser_Id(int id){
        return repository.findByUser_Id(id);
    }
}
