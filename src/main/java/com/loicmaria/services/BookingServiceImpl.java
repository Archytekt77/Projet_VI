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


    /**
     *
     * @param booking
     * @param id
     */
    public void add(Booking booking, int id) {
        booking.setTopo(topoService.get(id));
        booking.setUser(this.userService.getLoggedUser());
        repository.save(booking);
    }


    /**
     *
     * @param booking
     * @param answer
     * @param topoId
     * @return
     */
    public Booking update(Booking booking, String answer, int topoId) {

        switch (answer){
            case "accepted":{
                booking.setAnswer("accepted");
                booking.setStatus("in progress");
                break;
            }
            case "refused":{
                booking.setAnswer("refused");
                booking.setStatus("finished");
                break;
            }
            case "finishedAndAvailable":{
                booking.setStatus("finished");
                topoService.get(topoId).setAvailable(true);
                break;
            }
            case "finishedAndNotAvailable":{
                booking.setStatus("finished");
                break;
            }
            default: break;
        }
        return repository.save(booking);
    }


    public Collection<Booking> findByTopo_User_IdAndStatus(int id, String status) {
        return repository.findByTopo_User_IdAndStatus(id, status);
    }
    public Collection<Booking> findByUser_IdAndStatus(int id, String status) {
        return repository.findByUser_IdAndStatus(id, status);
    }
}
