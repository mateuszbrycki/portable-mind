package com.portablemind.user;

import com.portablemind.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mateusz Brycki on 28/05/2015.
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

        User user = userService.findByMail(mail);

        if(user != null){

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

            UserSecurity securityUser = new
                    UserSecurity(user.getId(), user.getMail(), user.getPassword(), user.isEnabled(),
                    true, true, true, authorities
            );

            return securityUser;

        }else{
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
