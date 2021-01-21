package com.loicmaria.web;

import com.loicmaria.entities.Booking;
import com.loicmaria.services.BookingServiceImpl;
import com.loicmaria.services.TopoServiceImpl;
import com.loicmaria.services.UserAccountServiceImpl;
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
    UserAccountServiceImpl userAccountService;
    @Autowired
    TopoServiceImpl topoService;

    /**
     * Ajoute au model l'utilisateur connecté à toutes les requêtes envoyées au contrôleur.
     * @param model Contient les données à afficher.
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("user", userAccountService.getLoggedUserAccount());
    }

    /**
     * Créer une réservation.
     * @param id L'ID du Topo de la réservation.
     * @param model Contient les données à afficher.
     * @return La page détails du Topo attaché à la réservation.
     */
    @PostMapping("/create/{id}")
    public String addBooking(@PathVariable(value = "id") int id, Model model){
        Booking booking = new Booking();
        bookingService.add(booking, id);

        model.addAttribute("topo", topoService.get(id));
        return "topo/detailsTopo";
    }

    /**
     * Afficher les réservations faites par l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page des réservations.
     */
    @GetMapping("/get")
    public String getBookings(Model model){
        int userId = userAccountService.getLoggedUserAccount().getId();

        model.addAttribute("nullBookings",bookingService.findByUserAccount_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByUserAccount_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByUserAccount_IdAndStatus(userId, "finished"));
        return "booking/getBooking";
    }

    /**
     * Afficher les demandes de réservations des Topos de l'utilisateur connecté.
     * @param model Contient les données à afficher.
     * @return La page des demandes de réservations.
     */
    @GetMapping("/get_loan")
    public String getLoan(Model model){
        int userId = userAccountService.getLoggedUserAccount().getId();

        model.addAttribute("nullBookings",bookingService.findByTopo_UserAccount_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByTopo_UserAccount_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByTopo_UserAccount_IdAndStatus(userId, "finished"));
        return "booking/getLoan";
    }

    /**
     * Modifier l'état de la réservation.
     * @param id L'ID de la réservation à modifier.
     * @param id2 L'ID du Topo à modifier.
     * @param answer La réponse donnée par l'utilisateur à intégrer à la réservation.
     * @param model Contient les données à afficher.
     * @return La page des demandes de réservations avec les modifications.
     */
    @PostMapping("/edition_loan/{id}/{topo_id}")
    public String editionLoan(@PathVariable(value = "id") int id, @PathVariable(value = "topo_id") int id2, String answer, Model model){
        int userId = userAccountService.getLoggedUserAccount().getId();
        Booking booking = bookingService.get(id);
        bookingService.update(booking,answer, id2);

        model.addAttribute("nullBookings",bookingService.findByTopo_UserAccount_IdAndStatus(userId, null));
        model.addAttribute("inProgressBookings", bookingService.findByTopo_UserAccount_IdAndStatus(userId, "in progress"));
        model.addAttribute("finishedBookings", bookingService.findByTopo_UserAccount_IdAndStatus(userId, "finished"));
        return "booking/getLoan";
    }

}
