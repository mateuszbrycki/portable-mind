package com.portablemind.userrole;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 12/05/2015.
 */
@Entity
@Table(name="USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="ROLE")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}