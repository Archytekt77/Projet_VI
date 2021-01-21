package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * <b>Classe représentant une voie créé par un membre du site, attaché à un site d'escalade.</b>
 * <p>
 *     Un commentaire est caractérisé par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Un nom. La nom de la voie.</li>
 *         <li>Une cotation. La cotation de la voie.</li>
 *         <li>Un nombre de longueur. Le nombre de longueur qui compose la voie.</li>
 *         <li>Une date de création, attribué automatiquement et définitivement</li>
 *         <li>Une date de mise à jour, attribué automatiquement.</li>
 *         <li>Un utilisateur, celui qui a ajouté la voie à la base de donnée.</li>
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
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column
    private String grade;
    @Column
    private int pitch;

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
    private UserAccount userAccount;

    // Constructor
    public Route() {
    }

    public Route(Integer id, String name, String grade, int pitch, LocalDateTime createDate,
                 LocalDateTime updateDate, ClimbingSite climbingSite, UserAccount userAccount) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.pitch = pitch;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.climbingSite = climbingSite;
        this.userAccount = userAccount;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public int getPitch() {
        return pitch;
    }
    public void setPitch(int pitch) {
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
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    //toString

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", pitch='" + pitch + '\'' +
                ", createDate=" + createDate + '\'' +
                ", updateDate=" + updateDate + '\'' +
                ", UserAccount=" + userAccount.getId() +
                '}';
    }
}
