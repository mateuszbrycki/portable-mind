package com.portablemind.project;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Entity
@Table(name="PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="FK_USER_ID")
    private Integer owner;

    @NotNull
    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    public Project() {}

    public Project(Integer id, String name, Integer owner) {
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

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
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
