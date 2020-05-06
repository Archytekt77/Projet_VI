package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "climbingSites")
public class ClimbingSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    private Collection< Route > routes;

    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String area;

    //Constructor
    public ClimbingSite() {
    }

    public ClimbingSite(int id, Collection<Route> routes, String name, String area) {
        this.id = id;
        this.routes = routes;
        this.name = name;
        this.area = area;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Collection<Route> getRoutes() {
        return routes;
    }
    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
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

    //toString()
    @Override
    public String toString() {
        return "ClimbingSite{" +
                "id=" + id +
                ", routes=" + routes +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}