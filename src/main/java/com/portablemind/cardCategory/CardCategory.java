package com.portablemind.cardCategory;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Entity
@Table(name="CARD_CATEGORY")
public class CardCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="FK_USER_ID")
    private Integer owner;

    @NotNull
    @Column(name="CATEGORY_NAME")
    private String name;

    public CardCategory() {}

    public CardCategory(Integer id, String name, Integer owner) {
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
}
