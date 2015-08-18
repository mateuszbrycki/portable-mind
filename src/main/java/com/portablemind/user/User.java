package com.portablemind.user;

import com.portablemind.userRole.UserRole;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Mateusz Brycki on 12/05/2015.
 */
@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne
    @JoinColumn(name="FK_USER_ROLE")
    private UserRole role;

    @NotNull
    @Column(name="MAIL")
    private String mail;

    @NotNull
    @Column(name="PASSWORD")
    private String password;

    @NotNull
    @Column(name="IS_PUBLIC")
    private boolean isPublic;

    @NotNull
    @Column(name="IS_ENABLED")
    private boolean isEnabled;

    public static Boolean DEFAULT_IS_PUBLIC = true;
    public static Boolean DEFAULT_IS_ENABLED = true;
    public static String DEFAULT_ROLE = "ROLE_USER";

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}