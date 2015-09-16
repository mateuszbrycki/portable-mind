package com.portablemind.card;

import com.portablemind.cardcategory.CardCategory;
import com.portablemind.project.Project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Entity
@Table(name="CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="FK_USER_ID")
    private Integer owner;

    @OneToOne
    @NotNull
    @JoinColumn(name = "FK_CATEGORY_ID")
    private CardCategory category;

    @OneToOne
    @NotNull
    @JoinColumn(name="FK_PROJECT_ID")
    private Project project;

    @NotNull
    @Column(name="CARD_DESCRIPTION")
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
}
