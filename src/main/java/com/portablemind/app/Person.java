package com.portablemind.app;

/**
 * Created by Mateusz Brycki on 26/04/2015.
 */
public class Person {

    private String name;

    Person() {
        this.name = "Default name";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void settName(String name) {
        this.name = name;
    }
}
