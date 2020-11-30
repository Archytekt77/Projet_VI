package com.loicmaria.web;

import com.loicmaria.entities.Booking;
import com.loicmaria.services.BookingServiceImpl;
import com.loicmaria.services.TopoServiceImpl;
import com.loicmaria.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TopoServiceImpl topoService;

    @GetMapping("/get")
    public String getBookings(Model model){
        model.addAttribute("bookings", bookingService.getter());
        return "booking/getBooking";
    }

    @PostMapping("/create")
    public String addBooking(@RequestParam(value = "id") int id, Model model){
        System.out.println(id);
        Booking booking = new Booking();
        System.out.println("1er : " + booking);
        bookingService.add(booking, id);
        System.out.println("2nd : " + booking);
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

}
