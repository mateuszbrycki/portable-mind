package com.portablemind.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Mateusz Brycki on 30/05/2015.
 */
public class UserUtilities {

    public static Integer getLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getPrincipal() instanceof String) {
            return 0;
        }

        UserSecurity currentUser = (UserSecurity)auth.getPrincipal();

        return currentUser.getId();
    }

    public static Boolean hasUserProjects() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getPrincipal() instanceof String) {
            return false;
        }
        UserSecurity currentUser = (UserSecurity)auth.getPrincipal();

        return currentUser.hasUserProjects();
    }

}
