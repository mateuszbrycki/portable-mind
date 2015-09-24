package com.portablemind.user;

import com.portablemind.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Mateusz Brycki on 30/05/2015.
 */
public class UserSecurity extends User {

    private Integer id;
    private Boolean hasUserProjects;

    public UserSecurity(Integer id, String mail, String password, Boolean isEnabled, Boolean accountNonExpired,
                        boolean credentialsNonExpired, boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities) {
        super(mail, password, isEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.id = id;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean hasUserProjects() {
        return hasUserProjects;
    }

    public void setHasUserProjects(Boolean hasUserProjects) {
        this.hasUserProjects = hasUserProjects;
    }
}
