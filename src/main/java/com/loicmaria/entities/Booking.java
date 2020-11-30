package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    @OneToOne
    private Topo topo;
    @OneToOne
    private User user;


    //Constructor
    public Booking(){}

    public Booking(int id, LocalDateTime createDate, LocalDateTime updateDate, Topo topo, User user) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.topo = topo;
        this.user = user;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
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
        return "Booking{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", topo=" + topo +
                ", user=" + user +
                '}';
    }
}
