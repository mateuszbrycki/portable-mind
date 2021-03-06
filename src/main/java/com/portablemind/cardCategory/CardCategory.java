package com.portablemind.cardCategory;

import com.portablemind.helper.image.ImageHelper;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Entity
@Table(name="card_category")
public class CardCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="category_name")
    private String name;

    @Column(name="category_icon")
    private String icon;

    public CardCategory() {}

    public CardCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getIcon() {
        return ImageHelper.getCardCategoryImagePath() + "/" + icon;
    }

    public void setIcon(String icon) { this.icon = icon; }
}
