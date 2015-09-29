package com.portablemind.project;

import com.portablemind.user.User;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @NotNull
    @JoinColumn(name = "fk_user_id")
    private User owner;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public Project() {}

    public Project(Integer id, String name, User owner) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
