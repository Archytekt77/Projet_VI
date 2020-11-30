package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "topos")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column
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
    private User user;

    //Constructor
    public Topo() {
    }

    public Topo(int id, String name, String description, String place, Boolean available, LocalDateTime createDate,
                LocalDateTime updateDate, Collection<ClimbingSite> climbingSites, User user){
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.available = available;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.climbingSites = climbingSites;
        this.user = user;
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
    public Collection<ClimbingSite> getClimbingSites() { return climbingSites; }
    public void setClimbingSites(Collection<ClimbingSite> climbingSites) { this.climbingSites = climbingSites; }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

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
                ", climbingSites=" + climbingSites +
                ", user=" + user +
                '}';
    }
}

