package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <b>Classe représentant une réservation de Topo créé par un membre du site.</b>
 * <p>
 *     Une réservation est caractérisé par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Un statut. Null, en cours ou fini.</li>
 *         <li>Une réponse à la demande de réservation. Acceptée ou refusée.</li>
 *         <li>Une date de création, attribué automatiquement et définitivement</li>
 *         <li>Une date de mise à jour, attribué automatiquement.</li>
 *         <li>Un topo de la réservation en question.</li>
 *         <li>Un utilisateur, celui qui fait la demande.</li>
 *     </ul>
 * </p>
 *
 * @see Topo
 * @see UserAccount
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Entity(name = "Booking")
@Table(name = "Booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String status;
    @Column
    private String answer;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null){
            createDate = LocalDateTime.now();
            updateDate = null;
        }
    }
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @OneToOne
    private Topo topo;
    @OneToOne
    private UserAccount userAccount;


    //Constructor
    public Booking(){}

    public Booking(int id, String answer, String status, LocalDateTime createDate, LocalDateTime updateDate, Topo topo, UserAccount userAccount) {
        this.id = id;
        this.answer = answer;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.topo = topo;
        this.userAccount = userAccount;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
    }
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount UserAccount) {
        this.userAccount = userAccount;
    }

    //toString
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", answer='" + answer + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", topo=" + topo.getId() +
                ", UserAccount=" + userAccount.getId() +
                '}';
    }
}
