package com.loicmaria.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

/**
 * <b>Classe représentant un utilisateur.</b>
 * <p>Un utilisateur est caractérisé par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Un nom, que l'utilisateur définit lui même et pouvant être changé.</li>
 *         <li>Un email, donné par l'utilisateur permettant </li>
 *         <li>Une date de création, attribué automatiquement et définitivement</li>
 *         <li>Une date de mise à jour, attribué automatiquement.</li>
 *         <li>Une liste de rôles. Membre et parfois admin en plus.</li>
 *         <li>Une liste de Topos. Les Topos qu'il a ajouté lui même.</li>
 *         <li>Une liste de sites. Les sites qu'il a ajouté lui même.</li>
 *         <li>Une liste de voies. Les voies qu'il a ajouté lui même.</li>
 *         <li>Une liste de commentaires. Les commentaires qu'il a ajouté lui même.</li>
 *     </ul>
 * </p>
 *
 * @see Role
 * @see Topo
 * @see ClimbingSite
 * @see Route
 * @see Comment
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Entity
@Table(name = "usersAccount")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotEmpty
    private String name;
    @Column(unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;
    @Column
    @NotEmpty
    @Size(min = 4)
    private String password;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable
            (name = "user_account_role", joinColumns = {@JoinColumn(name = "user_account_id", referencedColumnName = "id")},
                    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
    @OneToMany(mappedBy = "userAccount")
    private Collection<Topo> topos;
    @OneToMany(mappedBy = "userAccount")
    private Collection<ClimbingSite> climbingSites;
    @OneToMany(mappedBy = "userAccount")
    private Collection<Route> routes;
    @OneToMany(mappedBy = "userAccount")
    private Collection<Comment> comments;


    //Constructor
    public UserAccount() {
    }

    public UserAccount(int id, String name, String email, String password, List<Role> roles, Collection<Topo> topos,
                Collection<ClimbingSite> climbingSites, Collection<Route> routes, Collection<Comment> comments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.topos = topos;
        this.climbingSites = climbingSites;
        this.routes = routes;
        this.comments = comments;
    }

    // Getters and Setters
    public Integer getId() {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public Collection<Topo> getTopos() {
        return topos;
    }
    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }
    public Collection<ClimbingSite> getClimbingSites() {
        return climbingSites;
    }
    public void setClimbingSites(Collection<ClimbingSite> climbingSites) {
        this.climbingSites = climbingSites;
    }
    public Collection<Route> getRoutes() {
        return routes;
    }
    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }
    public Collection<Comment> getComments() {
        return comments;
    }
    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
