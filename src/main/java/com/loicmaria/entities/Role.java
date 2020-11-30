package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;



    //Constructor
    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
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

    //toString
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
