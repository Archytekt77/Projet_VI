package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String pitchName;

    // Constructor
    public Route() {
    }

    public Route(int id, String name, String pitchName) {
        this.id = id;
        this.name = name;
        this.pitchName = pitchName;
    }

    // Getters and Setters
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
    public String getPitchName() {
        return pitchName;
    }
    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }

    //toString
    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pitchName='" + pitchName + '\'' +
                '}';
    }
}
