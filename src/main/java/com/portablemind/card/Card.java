package com.portablemind.card;

import com.portablemind.cardCategory.CardCategory;
import com.portablemind.project.Project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="fk_user_id")
    private Integer owner;

    @OneToOne
    @NotNull
    @JoinColumn(name = "fk_category_id")
    private CardCategory category;

    @OneToOne
    @NotNull
    @JoinColumn(name="fk_project_id")
    private Project project;

    @Column(name="card_name")
    private String name;

    @NotNull
    @Column(name="card_description")
    private String description;

    public Card() {}

    public Card(Integer owner, Project project, CardCategory cardCategory, String cardDescription) {
        this.owner = owner;
        this.project = project;
        this.category = cardCategory;
        this.description = cardDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CardCategory getCategory() {
        return category;
    }

    public void setCategory(CardCategory category) {
        this.category = category;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project type) {
        this.project = type;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
