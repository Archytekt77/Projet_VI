package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

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
                '}';
    }
}
