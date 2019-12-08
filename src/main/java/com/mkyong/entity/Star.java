package com.mkyong.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "Stars")

public class Star implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;

    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private LocalDate dateNaissance;

    private int age;

    @Column(name = "filmCulte")
    private String filmCulte;
    private boolean actif;

    public Star() {

    }

    public Star(int id, String nom, String prenom, LocalDate dateNaissance, int age, String filmCulte, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.filmCulte = filmCulte;
        this.actif = actif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFilmCulte() {
        return filmCulte;
    }

    public void setFilmCulte(String filmCulte) {
        this.filmCulte = filmCulte;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", age=" + age +
                ", filmCulte='" + filmCulte + '\'' +
                ", actif=" + actif +
                '}';
    }
}
