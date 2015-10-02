package com.portablemind.card;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Mateusz Brycki on 09/05/2015.
 */
public class CardDTO {

    private Integer id;

    @Length(min = 5)
    private String description;

    @Length(min = 5)
    private String name;

    private Integer project;

    private Integer category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer type) {
        this.project = type;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
