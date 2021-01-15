package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * <b>Classe représentant un rôle, qui est prédéfinit à la création d'un membre en
 * membre simple mais pouvant être changé.</b>
 * <p>
 *     Il existe 2 rôles, ils sont caractérisés par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Un nom, actuellement il y a administrateur et simple membre</li>
 *     </ul>
 * </p>
 *
 * @author Loïc MARIA
 * @version 1.0
 */
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
