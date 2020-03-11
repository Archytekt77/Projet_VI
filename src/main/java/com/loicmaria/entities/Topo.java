package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "topos")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer topoId;
    @Column(nullable = false)
    @NotEmpty
    private String topoName;
    @Column
    @NotEmpty
    private String topoDescription;
    @Column
    @NotEmpty
    private String topoPlace;
    @Column
    @NotEmpty
    private String topoPublicationDate;
    @Column
    @NotEmpty
    private boolean availableTopo;

    //Constructor
    public Topo() {
    }

    public Topo(int topoId, String topoName, String topoDescription, String topoPlace,
                String topoPublicationDate, boolean availableTopo) {
        this.topoId = topoId;
        this.topoName = topoName;
        this.topoDescription = topoDescription;
        this.topoPlace = topoPlace;
        this.topoPublicationDate = topoPublicationDate;
        this.availableTopo = availableTopo;
    }

    //Getters and Setters
    public int getTopoId() { return topoId; }
    public void setTopoId(int topoId) { this.topoId = topoId; }
    public String getTopoName() { return topoName; }
    public void setTopoName(String topoName) { this.topoName = topoName; }
    public String getTopoDescription() { return topoDescription; }
    public void setTopoDescription(String topoDescription) { this.topoDescription = topoDescription; }
    public String getTopoPlace() { return topoPlace; }
    public void setTopoPlace(String topoPlace) { this.topoPlace = topoPlace; }
    public String getTopoPublicationDate() { return topoPublicationDate; }
    public void setTopoPublicationDate(String topoPublicationDate) { this.topoPublicationDate = topoPublicationDate; }
    public boolean isAvailableTopo() { return availableTopo; }
    public void setAvailableTopo(boolean availableTopo) { this.availableTopo = availableTopo; }

    //toString
    @Override
    public String toString() {
        return "Topo{" +
                "topoId=" + topoId +
                ", topoName='" + topoName + '\'' +
                ", topoDescription='" + topoDescription + '\'' +
                ", topoPlace='" + topoPlace + '\'' +
                ", topoPublicationDate='" + topoPublicationDate + '\'' +
                ", availableTopo=" + availableTopo +
                '}';
    }
}

