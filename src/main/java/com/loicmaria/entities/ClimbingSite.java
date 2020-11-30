package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "climbingSites")
public class ClimbingSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String area;
    @Column
    private boolean official;

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
    private Collection< Route > routes;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "climbingSite")
    private Collection< Comment> comments;


    //Constructor
    public ClimbingSite() {
    }

    public ClimbingSite(int id, String name, String area, Boolean official, LocalDateTime createDate, LocalDateTime updateDate,
                        Collection<Route> routes, Collection<Comment> comments, User user) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.official = official;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.routes = routes;
        this.comments = comments;
        this.user = user;
    }

    //Getters and Setters
    public int getId() {
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
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public boolean isOfficial() {
        return official;
    }
    public void setOfficial(boolean official) {
        this.official = official;
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
    public Collection<Route> getRoutes() {
        return routes;
    }
    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }
    public Collection<Comment> getComments() {
        return comments;
    }
    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //toString()
    @Override
    public String toString() {
        return "ClimbingSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", official=" + official +
                ", routes=" + routes +
                ", comments=" + comments +
                '}';
    }
}