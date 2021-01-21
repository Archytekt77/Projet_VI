package com.loicmaria.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;


/**
 * <b>Classe représentant un site d'escalade créé par un membre du site attaché à un topo.</b>
 * <p>
 *     Un site d'escalade est caractérisé par :
 *     <ul>
 *         <li>Un ID unique, attribué automatiquement et définitivement.</li>
 *         <li>Un nom. Celui du site.</li>
 *         <li>Un secteur. Lieu du site (ex: france, martinique). </li>
 *         <li>Un type. Falaise, Bloc ou les deux.</li>
 *         <li>Une hauteur. La hauteur maximale du site.</li>
 *         <li>Une orientation. Les points cardinaux.</li>
 *         <li>Un nombre de voies.</li>
 *         <li>Une cotation minimum. Que l'on peut trouver sur le site.</li>
 *         <li>Une cotation maximum. Que l'on peut trouver sur le site.</li>
 *         <li>Une date de création, attribué automatiquement et définitivement</li>
 *         <li>Une date de mise à jour, attribué automatiquement.</li>
 *         <li>Un topo. Auquel il est attaché.</li>
 *         <li>Une liste de voies. Que l'on voit si elles sont ajoutées à la base de donnée.</li>
 *         <li>Une liste de commentaires. Que l'on peut consulter sur la page détails du site.</li>
 *         <li>Un utilisateur, celui qui a ajouté le site à la base de donnée.</li>
 *     </ul>
 * </p>
 *
 * @see Topo
 * @see Comment
 * @see Route
 * @see UserAccount
 *
 * @author Loïc MARIA
 * @version 1.0
 */
@Entity
@Table(name = "climbingSites")
public class ClimbingSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String area;
    @Column
    private String type;
    @Column
    private int climbingHeight;
    @Column
    private String orientation;
    @Column
    private int route;
    @Column
    private String minGrade;
    @Column
    private String maxGrade;

    @Column
    private boolean official;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    private Topo topo;
    @OneToMany
    private Collection< Route > routes;
    @ManyToOne
    private UserAccount userAccount;
    @OneToMany(mappedBy = "climbingSite")
    private Collection< Comment> comments;


    //Constructor
    public ClimbingSite() {
    }

    public ClimbingSite(int id, String name, String area, String type, int climbingHeight, String orientation, int route,
                        String minGrade, String maxGrade,  Boolean official, LocalDateTime createDate, LocalDateTime updateDate,
                        Topo topo, Collection<Route> routes, Collection<Comment> comments, UserAccount userAccount) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.type = type;
        this.climbingHeight = climbingHeight;
        this.orientation = orientation;
        this.route = route;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.official = official;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.topo = topo;
        this.routes = routes;
        this.comments = comments;
        this.userAccount = userAccount;
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
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getClimbingHeight() {
        return climbingHeight;
    }
    public void setClimbingHeight(int climbingHeight) {
        this.climbingHeight = climbingHeight;
    }
    public String getOrientation() {
        return orientation;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    public int getRoute() {
        return route;
    }
    public void setRoute(int route) {
        this.route = route;
    }
    public String getMinGrade() {
        return minGrade;
    }
    public void setMinGrade(String minGrade) {
        this.minGrade = minGrade;
    }
    public String getMaxGrade() {
        return maxGrade;
    }
    public void setMaxGrade(String maxGrade) {
        this.maxGrade = maxGrade;
    }
    public boolean isOfficial() {
        return official;
    }
    public void setOfficial(boolean official) {
        this.official = official;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
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
    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    //toString()
    @Override
    public String toString() {
        return "ClimbingSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", climbingHeight=" + climbingHeight + '\'' +
                ", orientation='" + orientation + '\'' +
                ", route=" + route + '\'' +
                ", minGrade='" + minGrade + '\'' +
                ", maxGrade='" + maxGrade + '\'' +
                ", official=" + official + '\'' +
                ", createDate=" + createDate + '\'' +
                ", updateDate=" + updateDate + '\'' +
                ", topo=" + topo.getId() + '\'' +
                ", userAccount=" + userAccount.getId() +
                '}';
    }
}