package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List< User > users;
    @ManyToMany
    @JoinTable
            (name = "role_privileges", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
                    inverseJoinColumns = {@JoinColumn(name = "privilege_id", referencedColumnName = "id")})
    private List<Privilege> privileges;



    //Constructor
    public Role() {
    }

    public Role(int id, String name, List<User> users, List<Privilege> privileges) {
        this.id = id;
        this.name= name;
        this.users = users;
        this.privileges = privileges;
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
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Privilege> getPrivileges() {
        return privileges;
    }
    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    //toString
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", privileges=" + privileges +
                '}';
    }
}
