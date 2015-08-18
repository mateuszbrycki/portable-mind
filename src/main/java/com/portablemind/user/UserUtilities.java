package com.portablemind.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Mateusz Brycki on 30/05/2015.
 */
public class UserUtilities {

    public static Integer getLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserSecurity currentUser = (UserSecurity)auth.getPrincipal();

        return currentUser.getId();
    }

}
