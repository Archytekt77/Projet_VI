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
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String pitch;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    private ClimbingSite climbingSite;
    @ManyToOne
    private User user;

    // Constructor
    public Route() {
    }

    public Route(Integer id, String name, String pitch, LocalDateTime createDate, LocalDateTime updateDate, ClimbingSite climbingSite, User user) {
        this.id = id;
        this.name = name;
        this.pitch = pitch;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.climbingSite = climbingSite;
        this.user = user;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPitch() {
        return pitch;
    }
    public void setPitch(String pitch) {
        this.pitch = pitch;
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
    public ClimbingSite getClimbingSite() {
        return climbingSite;
    }
    public void setClimbingSite(ClimbingSite climbingSite) {
        this.climbingSite = climbingSite;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //toString

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pitch='" + pitch + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", user=" + user.getId() +
                '}';
    }
}
