package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "climbingSites")
public class ClimbingSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int climbingSiteId;
    @Column
    @NotEmpty
    private String climbingName;
    @Column
    @NotEmpty
    private String climbingArea;
    @Column
    @NotEmpty
    private String climbingRoute;
    @Column
    @NotEmpty
    private String climbingPitch;

    //Constructor
    public ClimbingSite() {
    }

    public ClimbingSite(int climbingSiteId, String climbingName, String climbingArea, String climbingRoute, String climbingPitch) {
        this.climbingSiteId = climbingSiteId;
        this.climbingName = climbingName;
        this.climbingArea = climbingArea;
        this.climbingRoute = climbingRoute;
        this.climbingPitch = climbingPitch;
    }

    //Getters and Setters
    public int getClimbingSiteId() { return climbingSiteId; }
    public void setClimbingSiteId(int climbingSiteId) { this.climbingSiteId = climbingSiteId; }
    public String getClimbingName() { return climbingName; }
    public void setClimbingName(String climbingName) { this.climbingName = climbingName; }
    public String getClimbingArea() { return climbingArea; }
    public void setClimbingArea(String climbingArea) { this.climbingArea = climbingArea; }
    public String getClimbingRoute() { return climbingRoute; }
    public void setClimbingRoute(String climbingRoute) { this.climbingRoute = climbingRoute; }
    public String getClimbingPitch() { return climbingPitch; }
    public void setClimbingPitch(String climbingPitch) { this.climbingPitch = climbingPitch; }

    //toString()
    @Override
    public String toString() {
        return "ClimbingSite{" +
                "climbingSiteId=" + climbingSiteId +
                ", climbingName='" + climbingName + '\'' +
                ", climbingArea='" + climbingArea + '\'' +
                ", climbingRoute='" + climbingRoute + '\'' +
                ", climbingPitch='" + climbingPitch + '\'' +
                '}';
    }
}