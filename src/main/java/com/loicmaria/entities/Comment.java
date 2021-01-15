package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * <b>Classe représentant un commentaire créé par un membre du site, attaché à un site d'escalade.</b>
 * <p>
 *     Un commentaire est caractérisé par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Une description. Écrit par un membre du site, pourvant être modifié par le membre
 *         lui même ou un administrateur.</li>
 *         <li>Une date de création, attribué automatiquement et définitivement</li>
 *         <li>Une date de mise à jour, attribué automatiquement.</li>
 *         <li>Un utilisateur, celui qui l'écrit.</li>
 *         <li>Un site d'escalade auquel il est attaché.</li>
 *     </ul>
 * </p>
 *
 * @see ClimbingSite
 * @see User
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotEmpty
    private String description;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
        if (this.updateDate == null) updateDate = LocalDateTime.now();
    }
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    private User user;
    @ManyToOne
    private ClimbingSite climbingSite;

    //Constructor
    public Comment() {
    }

    public Comment(int id, String description, LocalDateTime createDate, LocalDateTime updateDate, User user,
                   ClimbingSite climbingSite) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
        this.climbingSite = climbingSite;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ClimbingSite getClimbingSite() {
        return climbingSite;
    }
    public void setClimbingSite(ClimbingSite climbingSite) {
        this.climbingSite = climbingSite;
    }

    //toString
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", user=" + user.getId() +
                ", climbingSite=" + climbingSite.getId() +
                '}';
    }
}
