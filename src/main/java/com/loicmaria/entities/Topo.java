package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * <b>Classe représentant un Topo créé par un membre du site, attaché à un site d'escalade.</b>
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
 * @see UserAccount
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Entity
@Table(name = "topos")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column(length = 500)
    @NotEmpty
    private String description;
    @Column
    @NotEmpty
    private String place;
    @Column
    private boolean available;

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

    @OneToMany
    private Collection<ClimbingSite> climbingSites;
    @ManyToOne
    private UserAccount userAccount;

    //Constructor
    public Topo() {
    }

    public Topo(int id, String name, String description, String place, Boolean available, LocalDateTime createDate,
                LocalDateTime updateDate, Collection<ClimbingSite> climbingSites, UserAccount userAccount){
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.available = available;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.climbingSites = climbingSites;
        this.userAccount = userAccount;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
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
    public Collection<ClimbingSite> getClimbingSites() {
        return climbingSites;
    }
    public void setClimbingSites(Collection<ClimbingSite> climbingSites) {
        this.climbingSites = climbingSites;
    }
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    //toString
    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ", available=" + available +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", UserAccount=" + userAccount.getId() +
                '}';
    }
}

