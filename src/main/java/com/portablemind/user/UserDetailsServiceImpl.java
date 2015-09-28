package com.portablemind.user;

import com.portablemind.project.service.ProjectService;
import com.portablemind.user.service.UserService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mateusz Brycki on 28/05/2015.
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Inject
    private UserService userService;

    @Inject
    private ProjectService projectService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        User user = userService.findByMail(mail);

        if(user != null){

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

            Integer userId = user.getId();

            UserSecurity securityUser = new
                    UserSecurity(userId, user.getMail(), user.getPassword(), user.isEnabled(),
                    true, true, true, authorities
            );

            securityUser.setHasUserProjects(projectService.hasUserProjects(userId));

            return securityUser;

        }else{
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
