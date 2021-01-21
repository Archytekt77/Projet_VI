package com.loicmaria.services;


import com.loicmaria.entities.Comment;
import com.loicmaria.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


/**
 * <b>Classe service permettant l'ORM de l'objet Comment.</b>
 * <p>
 *     Elle hérite de la classe Services.
 * </p>
 *
 * @see Services
 * @see Comment
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Service
public class CommentServiceImpl extends Services<Comment, CommentRepository> {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserAccountServiceImpl userAccountService;
    @Autowired
    ClimbingSiteServiceImpl climbingSiteService;


    /**
     * <b>Ajout du commentaire dans la base de donnée.</b>
     * Ajoute l'utilisateur connecté et l'ID du site d'escalade
     * dont le commentaire appartient.
     * @param comment Le commentaire à modifier.
     * @param id L'ID du site d'escalade.
     */
    public void add(Comment comment, int id){
        comment.setUserAccount(this.userAccountService.getLoggedUserAccount());
        comment.setClimbingSite(this.climbingSiteService.get(id));
        repository.save(comment);
    }

    /**
     * <b>Mise à jour du commentaire dans la base de donnée.</b>
     * Ajoute l'utilisateur qui à créé le commentaire, et l'ID
     * du site d'escalade dont le commentaire appartient.
     * @param comment Le commentaire à modifier.
     * @param id L'ID du site d'escalade.
     * @return Le commentaire modifié.
     */
    public Comment update(Comment comment, int id){
        comment.setUserAccount(comment.getUserAccount());
        comment.setClimbingSite(this.climbingSiteService.get(id));
        return repository.save(comment);
    }


    /**
     * <b>Retourne une liste de commentaires en fonction du site d'escalade</b>
     * Permet de trouver tous les commentaires reliés à un site d'escalade.
     * @param id L'ID du site d'escalade.
     * @return Une liste de commentaires.
     */
    public Collection<Comment> findByClimbingSite_Id(int id) {
        return commentRepository.findByClimbingSite_Id(id);
    }
}
