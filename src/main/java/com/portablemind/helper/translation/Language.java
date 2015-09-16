package com.portablemind.helper.translation;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */
@Entity
@Table(name="LANGUAGE")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
