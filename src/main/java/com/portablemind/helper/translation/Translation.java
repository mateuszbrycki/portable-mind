package com.portablemind.helper.translation;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */

@Entity
@Table(name="TRANSLATION")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="NAME")
    private String name;

    @NotNull
    @Column(name="VALUE")
    private String value;


    private String language;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
