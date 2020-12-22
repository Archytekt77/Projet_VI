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

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userService.getLoggedUser());
    }

    @PostMapping("/create/{id}")
    public String addBooking(@PathVariable(value = "id") int id, Model model){
        Booking booking = new Booking();
        bookingService.add(booking, id);

        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

    @GetMapping("/get")
    public String getBookings(Model model){
        int userId = userService.getLoggedUser().getId();

        model.addAttribute("nullBookings",bookingService.findByUser_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByUser_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByUser_IdAndStatus(userId, "finished"));
        return "booking/getBooking";
    }

    @GetMapping("/get_loan")
    public String getLoan(Model model){
        int userId = userService.getLoggedUser().getId();

        model.addAttribute("nullBookings",bookingService.findByTopo_User_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByTopo_User_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByTopo_User_IdAndStatus(userId, "finished"));
        return "booking/getLoan";
    }

    @PostMapping("/edition_loan/{id}/{topo_id}")
    public String editionLoan(@PathVariable(value = "id") int id, @PathVariable(value = "topo_id") int id2, String answer, Model model){
        int userId = userService.getLoggedUser().getId();
        Booking booking = bookingService.get(id);
        bookingService.update(booking,answer, id2);

        model.addAttribute("nullBookings",bookingService.findByTopo_User_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByTopo_User_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByTopo_User_IdAndStatus(userId, "finished"));
        return "booking/getLoan";
    }

}
