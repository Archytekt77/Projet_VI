package com.loicmaria.services;

import com.loicmaria.entities.Booking;
import com.loicmaria.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * <b>Classe permettant l'ORM de l'objet Booking.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see Booking
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class BookingServiceImpl extends Services<Booking, BookingRepository> {

    @Autowired
    TopoServiceImpl topoService;
    @Autowired
    UserAccountServiceImpl userAccountService;


    /**
     * <b>Ajout de la réservation dans la base de donnée.</b>
     * Ajoute le Topo et l'utilisateur connecté.
     * @param booking La réservation à modifier.
     * @param topoId L'ID du Topo qui est ajouté dans la réservation.
     */
    public void add(Booking booking, int topoId) {
        booking.setTopo(topoService.get(topoId));
        booking.setUserAccount(this.userAccountService.getLoggedUserAccount());
        repository.save(booking);
    }


    /**
     * <b>Mise à jour de la réservation dans la base de donnée.</b>
     * @param booking La réservation à modifier.
     * @param answer La réponse donnée par l'utilisateur.
     * @param topoId L'ID du Topo à modifier en fonction de la réponse et du status.
     * @return la réservation modifié.
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


    /**
     * <b>Retourne une liste de réservation en fonction de l'ID de l'utilisateur qui a créé le Topo.</b>
     * Permet de créer plusieurs listes en fonction du statut des réservations ('Null', 'En cours' et 'Finis').
     * @param id L'ID de l'utilisateur qui a créé le Topo.
     * @param status Le statut de la réservation.
     * @return Une liste de réservation.
     */
    public Collection<Booking> findByTopo_UserAccount_IdAndStatus(int id, String status) {
        return repository.findByTopo_UserAccount_IdAndStatus(id, status);
    }

    /**
     * <b>Retourne une liste de réservation en fonction de l'utilisateur connecté.</b>
     * Permet de créer plusieurs listes en fonction du statut des réservations ('Null', 'En cours' et 'Finis').
     * @param id L'ID de l'utilisateur qui est connecté.
     * @param status Le status de la réservation.
     * @return Une liste de réservation.
     */
    public Collection<Booking> findByUserAccount_IdAndStatus(int id, String status) {
        return repository.findByUserAccount_IdAndStatus(id, status);
    }
}
