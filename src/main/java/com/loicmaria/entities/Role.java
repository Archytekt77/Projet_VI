package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "roles")
    private List< User > users;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    //Constructor
    public Role() {
    }

    public Role(int id, List<User> users, String name) {
        this.id = id;
        this.users = users;
        this.name= name;
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
    public List < User > getUsers() {
        return users;
    }
    public void setUsers(List < User > users) {
        this.users = users;
    }

    //toString
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", users=" + users +
                ", name='" + name + '\'' +
                '}';
    }
}
