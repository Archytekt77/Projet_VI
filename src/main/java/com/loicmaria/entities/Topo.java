package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "topos")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    private Collection<ClimbingSite> climbingSites;

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
    @NotEmpty
    private String publicationDate;
    @Column
    private boolean available;

    //Constructor
    public Topo() {
    }

    public Topo(int id, Collection<ClimbingSite> climbingSites,
                String name, String description, String place, String publicationDate,
                Boolean available){
        this.id = id;
        this.climbingSites = climbingSites;
        this.name = name;
        this.description = description;
        this.place = place;
        this.publicationDate = publicationDate;
        this.available = available;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Collection<ClimbingSite> getClimbingSites() { return climbingSites; }
    public void setClimbingSites(Collection<ClimbingSite> climbingSites) { this.climbingSites = climbingSites; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public String getPublicationDate() { return publicationDate; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    //toString
    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", climbingSites=" + climbingSites +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", available=" + available +
                '}';
    }
}

